package br.com.bb.cotacaodolar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.cotacaodolar.domain.TbCotacaoDolar;
import br.com.bb.cotacaodolar.dto.CotacaoDolarRespDTO;
import br.com.bb.cotacaodolar.repository.ICotacaoDolarRepository;

@Service
public class CotacaoDolarService {

	@Autowired
	ICotacaoDolarRepository cotacaoDolarRepository;

	public CotacaoDolarRespDTO findByDataCotacao(final String dataCotacao) {
		TbCotacaoDolar tbCotacaoDolar = new TbCotacaoDolar();
		// TODO
		TbCotacaoDolar tb = cotacaoDolarRepository.save(tbCotacaoDolar);
		// CotacaoDolarDto dto = CotacaoDolarMapper.cotacaoDolarToCotacaoDolarDTO(tb);

		return null; // dto
	}
}
