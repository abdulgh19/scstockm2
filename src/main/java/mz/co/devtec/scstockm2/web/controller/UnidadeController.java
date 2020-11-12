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

import mz.co.devtec.scstockm2.domain.Tipo;
import mz.co.devtec.scstockm2.domain.Unidade;
import mz.co.devtec.scstockm2.web.service.TipoService;
import mz.co.devtec.scstockm2.web.service.UnidadeService;

@Controller
@RequestMapping("/unidades")
public class UnidadeController {

	@Autowired
	private UnidadeService unidadeService;
	
	@Autowired
	private TipoService tipoService;
	
	@GetMapping("/registar")
	public String registar(Unidade unidade) {
		return "unidade/registo";
	}
	
	@GetMapping("/visualizar")
	public String listar(ModelMap model) {
		model.addAttribute("unidades", unidadeService.buscarTodas()); //"unidades" eh a variavel que eh mandada para os unidade!
		return "unidade/lista";
	}
	
	@PostMapping("/registar")
	public String registar(@Valid Unidade unidade, BindingResult result, RedirectAttributes attr) { //@Valid informa ao Spring que a validacao esta a ser feita via bean validation para o objecto cargo
		if(result.hasErrors()) {
			return "/unidade/registo";
		}
		unidadeService.registarUnidade(unidade);
		attr.addFlashAttribute("success", "Unidade registado com Sucesso!");
		return "redirect:/unidades/visualizar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) { //Pega uum id na URL e transforma em LONG depois busca o unidade com aquele ID e retorna a tela de registo com o(s) campo(s) preenchido(s)
		model.addAttribute("unidade", unidadeService.buscarPorId(id));
		return "unidade/registo";
	}

	
	@ModelAttribute("tipos")
	public List<Tipo> listaDeTipos(){
		
		return tipoService.buscarTodos();
	}
	
	


}
