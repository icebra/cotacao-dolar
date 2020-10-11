package br.com.bb.cotacaodolar.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_NULL)
public class CotacaoDolarRespDTO {
	@JsonInclude(Include.NON_NULL)
	private String requestDataCotacao;

	@JsonInclude(Include.NON_NULL)
	private String id;

	@JsonInclude(Include.NON_NULL)
	private String dataHoraRequisicao;

	@JsonInclude(Include.NON_NULL)
	private String dataCotacao;

	@JsonInclude(Include.NON_NULL)
	private String compra;

	@JsonInclude(Include.NON_NULL)
	private String venda;

	@JsonInclude(Include.NON_NULL)
	private String dataHoraCotacao;

	@JsonInclude(Include.NON_NULL)
	private String errorCode;

	@JsonInclude(Include.NON_NULL)
	private String errorDescription;
}
