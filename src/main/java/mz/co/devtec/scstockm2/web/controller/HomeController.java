package mz.co.devtec.scstockm2.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/") 		//Acessa a raiz do projecto
	public String home() {
		return "home";
	}

}
