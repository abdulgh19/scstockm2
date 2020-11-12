package mz.co.devtec.scstockm2.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.devtec.scstockm2.domain.Categoria;
import mz.co.devtec.scstockm2.domain.Grupo;
import mz.co.devtec.scstockm2.domain.Produto;
import mz.co.devtec.scstockm2.domain.Unidade;
import mz.co.devtec.scstockm2.web.service.CategoriaService;
import mz.co.devtec.scstockm2.web.service.GrupoService;
import mz.co.devtec.scstockm2.web.service.ProdutoService;
import mz.co.devtec.scstockm2.web.service.UnidadeService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private UnidadeService unidadeService;
	
	
	@GetMapping("/registar")
	public String registar(Produto produto) {
		return "produto/registo";
	}
	
	@GetMapping("/visualizar")
	public String visualizar(ModelMap model) {
		model.addAttribute("produtos", produtoService.buscarTodos()); //"produtos" eh a variavel que eh mandada para os produtos!
		return "produto/lista";
	}
	
	@PostMapping("/registar")
	public String registar(@Valid Produto produto, BindingResult result, RedirectAttributes attr) { //@Valid informa ao Spring que a validacao esta a ser feita via bean validation para o objecto produto
		if(result.hasErrors()) {
			return "/produto/registo";
		}
		produtoService.registarProduto(produto);
		attr.addFlashAttribute("success", "Produto registado com Sucesso!");
		return "redirect:/produtos/visualizar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) { //Pega uum id na URL e transforma em LONG depois busca o produto com aquele ID e retorna a tela de registo com o(s) campo(s) preenchido(s)
		model.addAttribute("produto", produtoService.buscarPorId(id));
		return "produto/registo";
	}
	
	
	@GetMapping("/grupos/categoria/{idCategoria}")		//Preenche a ComboBox de grupos com base na categoria escolhida na como de categorias
	@ResponseBody
	public List<Grupo> getListaGruposPorCategoria(@PathVariable("idCategoria") Long idCategoria) {
		return grupoService.buscarGrupoPorIdCategoria(idCategoria);
	}
	

		
	@ModelAttribute("unidades")
	public List<Unidade> listaDeUnidades(){
		
		return unidadeService.buscarTodas();
	}
	
	@ModelAttribute("grupos")
	public List<Grupo> listaDeGrupos(){
		
		return grupoService.buscarTodos();
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> listaDeCategoria(){
		return categoriaService.buscarTodas();
	}
	
	
	
	
	


}
