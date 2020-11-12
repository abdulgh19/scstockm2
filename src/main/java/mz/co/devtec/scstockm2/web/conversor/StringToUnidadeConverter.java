package mz.co.devtec.scstockm2.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mz.co.devtec.scstockm2.domain.Unidade;
import mz.co.devtec.scstockm2.web.service.UnidadeService;

@Component
public class StringToUnidadeConverter implements Converter<String, Unidade> {
	
	@Autowired
	private UnidadeService service;
	
	@Override
	public Unidade convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
