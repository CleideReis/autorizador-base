package la.foton.treinamento.desafio.autorizador.conta.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import la.foton.treinamento.desafio.autorizador.cliente.entity.Cliente;
import la.foton.treinamento.desafio.autorizador.conta.converter.TipoDoPacoteDeServicosConverter;

@Table(name = "CTA")
@Entity
@IdClass(ContaPK.class)
public class Conta {

	@Id
	@Column(name = "PTACOD")
	private Integer agencia;

	@Id
	@Column(name = "CTANUM")
	private Integer numero;

	@Column(name = "CTASLD")
	protected BigDecimal saldo;

	@ManyToOne
	@JoinColumn(name = "CLTCPF")
	private Cliente titular;

	@Column(name = "CTASTA")
	@Enumerated(EnumType.ORDINAL)
	private EstadoDaConta estado;

	@Column(name = "CTAPSV")
	@Convert(converter = TipoDoPacoteDeServicosConverter.class)
	private TipoDoPacoteDeServicos tipoDoPacoteDeServicos;

	@OneToMany(cascade = CascadeType.ALL)
	private List<LancamentoDaConta> lancamentos;

}
