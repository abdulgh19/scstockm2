package mz.co.devtec.scstockm2.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.co.devtec.scstockm2.domain.Grupo;
import mz.co.devtec.scstockm2.web.service.GrupoService;

@Component
public class StringToGrupoConverter implements Converter<String, Grupo> {
	
	@Autowired
	private GrupoService service;
	
	@Override
	public Grupo convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
