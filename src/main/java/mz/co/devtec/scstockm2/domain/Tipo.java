package mz.co.devtec.scstockm2.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "tipo")
public class Tipo extends AbstractEntity {

	@NotBlank(message = "Informe uma designação")
	@Size(min = 3, max = 45, message = "A designação do tipo deve ter entre {min} e {max} caracteres")
	@Column(name = "designacao", unique = true, nullable = false)
	private String designacao;

	@JsonIgnore
	@OneToMany(mappedBy = "tipo")
	private List<Unidade> unidades;

	public String getDesignacao() {
		return designacao;
	}


	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}


	public List<Unidade> getUnidades() {
		return unidades;
	}


	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	
	
	

}
