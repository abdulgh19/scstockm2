package mz.co.devtec.scstockm2.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@SuppressWarnings("serial")
@Entity
@Table(name = "entrada")
public class Entrada extends AbstractEntity {


	@Column(name = "data_entrada", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate data_entrada;
	
	@Column(name="codigo", nullable = false, unique = true)
	private String codigo;
	
	
	public LocalDate getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(LocalDate data_entrada) {
		this.data_entrada = data_entrada;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
		

}
