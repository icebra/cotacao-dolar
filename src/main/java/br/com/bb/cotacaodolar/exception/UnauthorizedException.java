package br.com.bb.cotacaodolar.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UnauthorizedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String messageKey = "error.unauthorized";
}
