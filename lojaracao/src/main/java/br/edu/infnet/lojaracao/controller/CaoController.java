package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.lojaracao.model.domain.Cao;

@Controller
public class CaoController {
	@RequestMapping(value = "/cadastro/cao", method = RequestMethod.GET)
	public String telaCadastro() {
		return "cadastro/cao";
	}
	
	@PostMapping(value = "/cao/incluir")
	public String incluirCao(Cao cao){
		System.out.println(cao);
		return "redirect:/confirmacao/cao";
	}
	
	@GetMapping(value = "/confirmacao/cao")
	public String confirmarCadastroCao() {
		return "confirmacao/cao";
	}
}
