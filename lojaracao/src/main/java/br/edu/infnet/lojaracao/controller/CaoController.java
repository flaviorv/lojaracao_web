package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.lojaracao.model.domain.Cao;
import br.edu.infnet.lojaracao.model.repository.CaoRepository;

@Controller
public class CaoController {
	@RequestMapping(value = "/cadastro/cao", method = RequestMethod.GET)
	public String telaCadastro() {
		return "cao/cadastro";
	}
	
	@PostMapping(value = "/cao/incluir")
	public String incluirCao(Cao cao){
		CaoRepository.incluir(cao);
		System.out.println(CaoRepository.obterLista());
		return "redirect:/lista/cao";
	}
	
	@GetMapping(value = "/lista/cao")
	public String confirmarCadastroCao() {
		return "cao/lista";
	}
}
