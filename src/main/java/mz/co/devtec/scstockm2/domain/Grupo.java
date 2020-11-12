package mz.co.devtec.scstockm2.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@SuppressWarnings("serial")
@Entity
@Table(name = "grupo")
public class Grupo extends AbstractEntity {

	@NotBlank(message = "Informe um nome!")
	@Size(max = 45, message = "A designacao do Grupo deve no maximo 60 caracteres!")
	@Column(name = "designacao", unique = true, nullable = false)
	private String designacao;
	
	@JsonIgnore
	@NotNull(message = "Selecione a categoria relativa ao cargo!")
	@ManyToOne (optional = false)
	@JoinColumn(name = "id_categoria", unique = false, nullable = false)
	private Categoria categoria;	
	
	@OneToMany(mappedBy = "grupo")
	private List<Produto> produtos;

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	


	
	
	

}
