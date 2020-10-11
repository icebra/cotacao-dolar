package br.com.bb.cotacaodolar.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import br.com.bb.cotacaodolar.dto.CotacaoDolarRespDTO;
import br.com.bb.cotacaodolar.mapper.ICotacaoDolarMapper;
import br.com.bb.cotacaodolar.service.CotacaoDolarService;
import br.com.bb.cotacaodolar.util.LogUtil;
import io.swagger.annotations.ApiParam;

@RestController
@RequestScope
@RequestMapping("/cotacao-dolar/v1")
public class CotacaoDolarController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CotacaoDolarController.class);

	@Autowired
	private CotacaoDolarService service;

	@Autowired
	private ICotacaoDolarMapper mapper;

	@RequestMapping(value = "/{dataCotacao}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getDollarRate(
			@ApiParam(value = "Data da Cotação", name = "dataCotacao", required = true) @PathVariable("dataCotacao") String dataCotacao,
			HttpServletRequest servletRequest) {

		LOGGER.info(LogUtil.buildMessage("TESTE", "Inicio consulta TAXAS DE DISPOSITIVO por institution e merchantID"));
		CotacaoDolarRespDTO resp = service.findByDataCotacao(dataCotacao);

		return new ResponseEntity<CotacaoDolarRespDTO>(resp, HttpStatus.OK);
	}

}
