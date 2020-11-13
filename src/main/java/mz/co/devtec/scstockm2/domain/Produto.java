package mz.co.devtec.scstockm2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "produto")
public class Produto extends AbstractEntity {
	
	@NotBlank(message = "Informe uma designação para o produto")
	@Size(min = 3, max = 45, message = "A designação do produto deve ter entre {min} e {max} caracteres")
	@Column(name = "designacao", unique = true, nullable = false)
	private String designacao;
	
	@NotNull(message = "Informe a quantidade")
	@Column(name = "quantidade", unique = false, nullable = false)
	private Integer quantidade;
	
	@NotNull(message = "Selecione um grupo!")
	@ManyToOne
	@JoinColumn(name = "id_grupo", unique = false, nullable = false)
	private Grupo grupo;
	
	@NotNull(message = "Selecione uma unidade!")
	@ManyToOne
	@JoinColumn(name = "id_unidade", unique = false, nullable = false)
	private Unidade unidade;

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
