package la.foton.treinamento.desafio.autorizador.conta.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "LAN")
@Entity
public class LancamentoDaConta {

	@Id
	@Column(name = "LANSEQ")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sequencial;

	@Column(name = "LANDATHOR")
	private LocalDateTime dataHora;

	@Column(name = "LANTIP")
	@NotNull
	private TipoDoLancamento tipo;

	@Column(name = "LANDES")
	@Size(max = 50)
	private String descricao;

	@Column(name = "LANVAL")
	private BigDecimal valor;

	public LancamentoDaConta() {
	}

	public LancamentoDaConta(TipoDoLancamento tipo, String descricao, BigDecimal valor) {
		super();
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;
	}

	@PrePersist
	public void prePersist() {
		this.dataHora = LocalDateTime.now();
	}

	public Long getSequencial() {
		return sequencial;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public TipoDoLancamento getTipo() {
		return tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

}
