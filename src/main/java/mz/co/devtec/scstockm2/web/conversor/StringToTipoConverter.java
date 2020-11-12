package mz.co.devtec.scstockm2.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.co.devtec.scstockm2.domain.Tipo;
import mz.co.devtec.scstockm2.web.service.TipoService;

@Component
public class StringToTipoConverter implements Converter<String, Tipo> {
	
	@Autowired
	private TipoService service;
	
	@Override
	public Tipo convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
