package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.lojaracao.model.domain.Ave;

@Controller
public class AveController {
	@RequestMapping(value = "/cadastro/ave", method = RequestMethod.GET)
	public String telaCadastro() {
		return "cadastro/ave";
	}
	
	@PostMapping(value = "/ave/incluir")
	public String incluirAve(Ave ave){
		System.out.println(ave);
		return "redirect:/confirmacao/ave";
	}
	
	@GetMapping(value = "/confirmacao/ave")
	public String confirmarCadastroAve() {
		return "confirmacao/ave";
	}
}
