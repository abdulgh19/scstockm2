package mz.co.devtec.scstockm2.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "produto")
public class Produto extends AbstractEntity {
	
	@Column(name = "designacao", unique = false, nullable = false)
	private String designacao;
	
	@Column(name = "quantidade", unique = false, nullable = false)
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "id_grupo", unique = false, nullable = false)
	private Grupo grupo;
	
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
