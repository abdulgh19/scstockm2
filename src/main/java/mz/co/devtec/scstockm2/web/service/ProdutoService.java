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
import mz.co.devtec.scstockm2.domain.Produto;
import mz.co.devtec.scstockm2.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Autowired
	private Datatables datatables;
	
	
	@Transactional(readOnly = false)
	public void registarProduto(Produto produto) {
		repository.save(produto);		
	}
	
	@Transactional(readOnly = true)
	public Map<String, Object> buscarProdutos(HttpServletRequest request) { //Seta o request o tipo de coluna que desejamos mostrar na datatables
		datatables.setRequest(request);
		datatables.setColunas(DatatablesColunas.PRODUTOS); // As colunas que desejamos mostrar na tela sao da classe Produto 
		Page<?> page = datatables.getSearch().isEmpty()
				? repository.findAll(datatables.getPageable()) //caso o usuario nao escreva nada traz todos os dados
				: repository.findAllByDesignacao(datatables.getSearch(), datatables.getPageable()); // de contario traz o resultado metodo findAllByDesignacao
		return datatables.getResponse(page);
	}
	
	
	
	@Transactional(readOnly = true)
	public Produto buscarPorId(Long id) { //Busca Produtos por ID
		return repository.findById(id).get(); // dado que o retorno do findById eh OPTIONAL, precisa-se acrescentar o get() para buscar o objecto Produto
	}


	@Transactional(readOnly = false)
	public void remover(Long id) {
		repository.deleteById(id);				
	}

	@Transactional(readOnly = true)
	public List<Produto> buscarTodos() {
		return repository.findAll();
	}



}
