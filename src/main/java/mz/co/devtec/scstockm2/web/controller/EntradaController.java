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

import mz.co.devtec.scstockm2.domain.Entrada;
import mz.co.devtec.scstockm2.web.service.EntradaService;

@Controller
@RequestMapping("/entradas")
public class EntradaController {

	@Autowired
	private EntradaService entradaService;

	@GetMapping("/cadastrar")
	public String cadastrar(Entrada entrada) { // Este metodo abre a pagina de cadastrar entradas com o objecto
												// "entrada" que eh uma instancia de Entrada
		return "entrada/cadastro"; // entrada eh a pasta com ficheiro HTML denominado cadastro. Que abre tela de
									// cadastro de entradas
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) { // Este metodo abre a pagina de listar entradas
		model.addAttribute("entradas", entradaService.buscarTodas()); // entradas e' o nome da variavel que eh
																// enviada la para a pagina
		return "entrada/lista"; // entradas eh a pasta com ficheiro HTML denominado lista. Que abre tela de
								// visualizacao de entrada
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Entrada entrada, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "entrada/cadastro";
		}
		entradaService.salvarEntrada(entrada);
		attr.addFlashAttribute("success", "Entrada registado com Sucesso!");
		return "redirect:/entradas/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) { // Chama a tela de cadastro com o(s) campo(s)
																			// preenchido(s)
		model.addAttribute("entrada", entradaService.buscarPorId(id));
		return "entrada/cadastro";
	}


}
