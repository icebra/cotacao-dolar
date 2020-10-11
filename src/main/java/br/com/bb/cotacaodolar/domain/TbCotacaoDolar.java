package br.com.bb.cotacaodolar.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Cotacao")
@Table(name = "tbCotacaoDolar")
public class TbCotacaoDolar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "dataHoraRequisicao", nullable = false, updatable = false)
	private Timestamp dataHoraRequisicao;

	@Column(name = "dataCotacao", nullable = false, updatable = false)
	private Date dataCotacao;

	@Column(name = "compra", nullable = false, updatable = false)
	private Currency compra;

	@Column(name = "venda", nullable = false, updatable = false)
	private Currency venda;

	@Column(name = "dataHoraCotacao", nullable = false, updatable = false)
	private Timestamp dataHoraCotacao;
}
