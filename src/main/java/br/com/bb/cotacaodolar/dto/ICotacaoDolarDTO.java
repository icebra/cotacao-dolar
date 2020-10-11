package br.com.bb.cotacaodolar.dto;

import br.com.bb.cotacaodolar.domain.TbCotacaoDolar;

public interface ICotacaoDolarDTO {
	String codigoRetorno();
	String descricaoRetorno();
	String dataCotacao();
	TbCotacaoDolar cotacaoDolar();
}