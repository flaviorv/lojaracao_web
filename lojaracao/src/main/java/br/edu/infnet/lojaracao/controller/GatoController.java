package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.lojaracao.model.domain.Gato;

@Controller
public class GatoController {
	
	@RequestMapping(value = "cadastro/gato", method = RequestMethod.GET)
	public String telaCadastro() {
		return "cadastro/gato";
	}
	
	@PostMapping(value = "/gato/incluir")
	public String incluirGato(Gato gato) {
		System.out.println(gato);
		
		return "redirect:/confirmacao/gato";
	}
	
	@GetMapping(value = "/confirmacao/gato")
	public String confirmarCadastroGato() {
		return "confirmacao/gato";
	}
}
