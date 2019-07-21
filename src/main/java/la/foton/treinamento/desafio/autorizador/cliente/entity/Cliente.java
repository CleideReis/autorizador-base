package la.foton.treinamento.desafio.autorizador.cliente.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Table(name = "CLT")
@Entity
public class Cliente {

	@Id
	@Size(max = 11)
	@Column(name = "CLTCPF")
	private String cpf;

	@Column(name = "CLTNOM", nullable = false)
	private String nome;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "CLTSTA")
	private SituacaoDoCliente situacao;

	public Cliente() {
		this.situacao = SituacaoDoCliente.PENDENTE;
	}

	public Cliente(String cpf, String nome) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.situacao = SituacaoDoCliente.PENDENTE;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public SituacaoDoCliente getSituacao() {
		return situacao;
	}

	public void ativa() {
		this.situacao = SituacaoDoCliente.ATIVO;
	}
}
