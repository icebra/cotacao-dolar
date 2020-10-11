package br.com.bb.cotacaodolar.handler;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.DocumentException;
import org.springframework.context.MessageSource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.bb.cotacaodolar.exception.APIException;
import br.com.bb.cotacaodolar.exception.DuplicatedException;
import br.com.bb.cotacaodolar.exception.InvalidTechnologyException;
import br.com.bb.cotacaodolar.exception.ItemNotFoundException;
import br.com.bb.cotacaodolar.exception.MandatoryFieldException;
import br.com.bb.cotacaodolar.model.DResponse;
import br.com.bb.cotacaodolar.util.LogUtil;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LogManager.getLogger();
	private final MessageSource messageSource;

	public GlobalExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(Exception.class)
	private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request) {
		return handleException("error.server", new Object[] { e.getMessage() }, e, request,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	private ResponseEntity<Object> handleConstraintViolationException(Exception e, WebRequest request) {
		return handleException("error.mandatoryfield", new Object[] { e.getMessage() }, e, request,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ItemNotFoundException.class)
	private ResponseEntity<Object> handleItemNotFound(ItemNotFoundException e, WebRequest request) {
		LOGGER.info(LogUtil.buildMessage("TESTE", request, "Item not found..."));
		return handleException("não encontrado"/* e.getMessageKey() */, e, request, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(APIException.class)
	private ResponseEntity<Object> handleAPI(APIException e, WebRequest request) {
		LOGGER.info(LogUtil.buildMessage("TESTE", request, e.getMessage()));
		return handleException("error.api", new Object[] { e.getMessage() }, e, request,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(DocumentException.class)
	private ResponseEntity<Object> handleDocument(DocumentException e, WebRequest request) {
		LOGGER.info(LogUtil.buildMessage("TESTE", request, e.getMessage()));
		return handleException("error.document", new Object[] { e.getMessage() }, e, request, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidTechnologyException.class)
	private ResponseEntity<Object> handleDocument(InvalidTechnologyException e, WebRequest request) {
		LOGGER.info(LogUtil.buildMessage("TESTE", request, e.getMessage()));
		return handleException("error.invalidTechnology", new Object[] { e.getMessage() }, e, request,
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DuplicatedException.class)
	private ResponseEntity<Object> handleDuplicatedItem(DuplicatedException e, WebRequest request) {
		return handleException("error.duplicated", new Object[] { e.getMessage() }, e, request, HttpStatus.CONFLICT);
	}

	private ResponseEntity<Object> handleException(String messageKey, Exception e, WebRequest request,
			HttpStatus status) {
		return handleException(messageKey, new Object[] {}, e, request, status);
	}

	@ExceptionHandler(MandatoryFieldException.class)
	private ResponseEntity<Object> handleMandatoryField(MandatoryFieldException e, WebRequest request) {
		LOGGER.info(LogUtil.buildMessage("TESTE", request, "Mandatory Fields.") + e.getMessage());
		return handleException("error.mandatoryfield", new Object[] { e.getMessage() }, e, request,
				HttpStatus.PARTIAL_CONTENT);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = e.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		return handleException("error.validation", new Object[] { errors }, e, request, HttpStatus.PARTIAL_CONTENT);
	}

	private ResponseEntity<Object> handleException(String messageKey, Object[] params, Exception e, WebRequest request,
			HttpStatus status) {
		String message = messageSource.getMessage(messageKey, params, Locale.getDefault());
		ApiError apiError = new ApiError(status);
		// apiError.setMessage(message);

		return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(DResponse.notOk("Erro"/* apiError.getMessage() */), null/* apiError.getStatus() */);
	}
}
