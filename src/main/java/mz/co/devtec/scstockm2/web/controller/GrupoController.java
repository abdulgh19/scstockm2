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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.devtec.scstockm2.domain.Categoria;
import mz.co.devtec.scstockm2.domain.Grupo;
import mz.co.devtec.scstockm2.web.service.CategoriaService;
import mz.co.devtec.scstockm2.web.service.GrupoService;

@Controller
@RequestMapping("/grupos")
public class GrupoController {

	@Autowired
	private GrupoService grupoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/registar")
	public String registar(Grupo grupo) {
		return "grupo/registo";
	}
	
	@GetMapping("/visualizar")
	public String visualizar(ModelMap model) {
		model.addAttribute("grupos", grupoService.buscarTodos()); //"grupos" eh a variavel que eh mandada para os grupo!
		return "grupo/lista";
	}
	
	@PostMapping("/registar")
	public String registar(@Valid Grupo grupo, BindingResult result, RedirectAttributes attr) { //@Valid informa ao Spring que a validacao esta a ser feita via bean validation para o objecto cargo
		if(result.hasErrors()) {
			return "/grupo/registo";
		}
		grupoService.registarGrupo(grupo);
		attr.addFlashAttribute("success", "Grupo registado com Sucesso!");
		return "redirect:/grupos/visualizar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) { //Pega uum id na URL e transforma em LONG depois busca o grupo com aquele ID e retorna a tela de registo com o(s) campo(s) preenchido(s)
		model.addAttribute("grupo", grupoService.buscarPorId(id));
		return "grupo/registo";
	}

	
	@ModelAttribute("categorias")
	public List<Categoria> ListaDeCategorias(){
		
		return categoriaService.buscarTodas();
	}
	
	


}
