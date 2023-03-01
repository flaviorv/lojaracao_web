package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.lojaracao.model.domain.Ave;
import br.edu.infnet.lojaracao.model.repository.AveRepository;

@Controller
public class AveController {
	@RequestMapping(value = "/cadastro/ave", method = RequestMethod.GET)
	public String telaCadastro() {
		return "ave/cadastro";
	}
	
	@PostMapping(value = "/ave/incluir")
	public String incluirAve(Ave ave){
		AveRepository.incluir(ave);
		System.out.println(AveRepository.obterLista());
		return "redirect:/lista/ave";
	}
	
	@GetMapping(value = "/lista/ave")
	public String confirmarCadastroAve() {
		return "ave/lista";
	}
}
