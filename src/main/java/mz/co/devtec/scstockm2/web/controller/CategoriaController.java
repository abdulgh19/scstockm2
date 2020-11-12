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

import mz.co.devtec.scstockm2.domain.Categoria;
import mz.co.devtec.scstockm2.web.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping({"/registar","", "/"})
	public String registar(Categoria categoria) { // Este metodo abre a pagina de registar categorias com o objecto "categoria" que uma instancia de Categoria
		return "categoria/registo";		//categoria eh a pasta com ficheiro HTML denominado registo. Que abre tela de registo de categorias
	}

	@GetMapping("/visualizar")
	public String visualizar(ModelMap model) { // Este metodo abre a pagina de visualiza categorias
		model.addAttribute("categorias", categoriaService.buscarTodas()); // categorias e' o nome da variavel que eh
																		// enviada la para a pagina
		return "categoria/lista";			//categoria eh a pasta com ficheiro HTML denominado lista. Que abre tela de visualizacao de categorias
	}

	@PostMapping("/registar")
	public String registar(@Valid Categoria categoria,BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "categoria/registo";
		}
		categoriaService.registarCategoria(categoria);
		attr.addFlashAttribute("success", "Categoria registada com Sucesso!");
		return "redirect:/categorias/visualizar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) { //Chama a tela de registo com o(s) campo(s) preenchido(s)
		model.addAttribute("categoria", categoriaService.buscarPorId(id));
		return "categoria/registo";
	}






}
