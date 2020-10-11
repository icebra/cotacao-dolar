package br.com.bb.cotacaodolar.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Data
public class DSecurity implements Serializable {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4742283449140456003L;
	private Integer codigoRetorno;
	private String mensagem;
}
