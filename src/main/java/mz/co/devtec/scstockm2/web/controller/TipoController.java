package mz.co.devtec.scstockm2.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mz.co.devtec.scstockm2.domain.Tipo;
import mz.co.devtec.scstockm2.web.service.TipoService;

@Controller
@RequestMapping("/tipos")
public class TipoController {

	@Autowired
	private TipoService tipoService;

	@GetMapping("/registar")
	public String registar(Tipo tipo) { // Este metodo abre a pagina de registar tipos com o objecto "tipo" que eh uma instancia de Tipo
		return "tipo/registo";		//tipo eh a pasta com ficheiro HTML denominado registo. Que abre tela de registo de tipos
	}

	@GetMapping("/visualizar")
	public String visualizar(ModelMap model) { // Este metodo abre a pagina de visualizar tipos
		model.addAttribute("tipos", tipoService.buscarTodos()); // tipos e' o nome da variavel que eh
																		// enviada la para a pagina
		return "tipo/lista";			//tipos eh a pasta com ficheiro HTML denominado lista. Que abre tela de visualizacao de tipo
	}

	@PostMapping("/registar")
	public String registar(@Valid Tipo tipo,BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "tipo/registo";
		}
		tipoService.registarTipo(tipo);
		attr.addFlashAttribute("success", "Tipo registado com Sucesso!");
		return "redirect:/tipos/visualizar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) { //Chama a tela de registo com o(s) campo(s) preenchido(s)
		model.addAttribute("tipo", tipoService.buscarPorId(id));
		return "tipo/registo";
	}



}
