package mz.co.devtec.scstockm2.web.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mz.co.devtec.scstockm2.datatables.Datatables;
import mz.co.devtec.scstockm2.datatables.DatatablesColunas;
import mz.co.devtec.scstockm2.domain.Categoria;
import mz.co.devtec.scstockm2.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private Datatables datatables;
	
	
	@Transactional(readOnly = false)
	public void registarCategoria(Categoria categoria) {
		repository.save(categoria);		
	}
	
	@Transactional(readOnly = true)
	public Map<String, Object> buscarCategorias(HttpServletRequest request) { //Seta o request o tipo de coluna que desejamos mostrar na datatables
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.CATEGORIAS); // As colunas que desejamos mostrar na tela sao da classe Categoria 
		Page<?> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable()) //caso o usuario nao escreva nada traz todos os dados
				: repository.findAllByDesignacao(datatables.getSearch(), datatables.getPageable()); // de contario traz o resultado metodo findAllByDesignacao
		return datatables.getResponse(page);
	}
	
	
	
	@Transactional(readOnly = true)
	public Categoria buscarPorId(Long id) { //Busca Categorias por ID
		return repository.findById(id).get(); // dado que o retorno do findById eh OPTIONAL, precisa-se acrescentar o get() para buscar o objecto Categoria
	}


	@Transactional(readOnly = false)
	public void remover(Long id) {
		repository.deleteById(id);				
	}

	@Transactional(readOnly = true)
	public List<Categoria> buscarTodas() {
		return repository.findAll();
	}



}
