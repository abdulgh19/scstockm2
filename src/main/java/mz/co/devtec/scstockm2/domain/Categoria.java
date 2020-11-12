package mz.co.devtec.scstockm2.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "categoria")
public class Categoria extends AbstractEntity {

	@NotBlank(message = "Informe um nome")
	@NotNull(message = "Informe uma designacao")
	@Size(min = 3, max = 45, message = "A designacao da categoria deve ter entre {min} e {max} caracteres")
	@Column(name = "designacao", unique = true, nullable = false)
	private String designacao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "categoria")
	private List<Grupo> grupos;

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	
	
	

}
