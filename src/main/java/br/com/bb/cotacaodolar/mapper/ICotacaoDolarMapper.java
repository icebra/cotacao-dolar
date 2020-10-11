package br.com.bb.cotacaodolar.mapper;

import org.mapstruct.Mapper;

import br.com.bb.cotacaodolar.domain.TbCotacaoDolar;
import br.com.bb.cotacaodolar.dto.CotacaoDolarRespDTO;
import br.com.bb.cotacaodolar.dto.ICotacaoDolarDTO;
import br.com.bb.cotacaodolar.model.DResponse;

@Mapper(componentModel = "spring")
public interface ICotacaoDolarMapper {
	CotacaoDolarRespDTO toCotacaoDolarDTO(ICotacaoDolarDTO cotacaoDolarDTO);
	public CotacaoDolarRespDTO cotacaoDolarToCotacaoDolarDTO(TbCotacaoDolar cotacaoDolar);

	default DResponse<CotacaoDolarRespDTO> cotacaoDolarToDResponse(CotacaoDolarRespDTO cotacaoDolar) {
		return DResponse.ok(cotacaoDolar, "Sucesso.");
	}
}
