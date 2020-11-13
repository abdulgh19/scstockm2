package mz.co.devtec.scstockm2.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@SuppressWarnings("serial")
@Entity
@Table(name = "unidade")
public class Unidade extends AbstractEntity {

	@NotBlank(message = "Informe uma designação")
	@Size(min = 3, max = 45, message = "A designação da unidade deve ter entre {min} e {max} caracteres")
	@Column(name = "designacao", unique = true, nullable = false)
	private String designacao;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo", unique = false, nullable = false)
	private Tipo tipo;
	
	@OneToMany(mappedBy = "unidade")
	private List<Produto> produtos;

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	

	
}
