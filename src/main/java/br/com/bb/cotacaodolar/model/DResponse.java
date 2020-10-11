package br.com.bb.cotacaodolar.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class DResponse<T> {
	private Integer codigoRetorno;
	private String mensagem;

	@JsonInclude(Include.NON_NULL)
	private T conteudo;

	public static <T> DResponse<T> ok(T data, String message) {
		return null; // new DResponse<>(0, message, data);
	}

	public static <T> DResponse<T> notOk(String message) {
		return null; // new DResponse<>(1, message, null);
	}

	public static <T> DResponse<T> notOk(Integer codigo, String message) {
		if (null == codigo) {
			notOk(message);
		}
		return null; // new DResponse<>(codigo, message, null);
	}
}