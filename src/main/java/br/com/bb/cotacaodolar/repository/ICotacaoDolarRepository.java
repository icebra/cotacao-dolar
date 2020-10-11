package br.com.bb.cotacaodolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.bb.cotacaodolar.domain.TbCotacaoDolar;

@Repository
public interface ICotacaoDolarRepository extends JpaRepository<TbCotacaoDolar, Integer> {

	@Transactional
	public default void insertWithEntityManager(TbCotacaoDolar tbCotacaoDolar) {
		this.insertWithEntityManager(tbCotacaoDolar);
	}
}
