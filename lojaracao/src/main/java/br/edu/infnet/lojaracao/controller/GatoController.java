package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.lojaracao.model.domain.Gato;
import br.edu.infnet.lojaracao.model.repository.GatoRepository;
import br.edu.infnet.lojaracao.model.repository.RacaoRepository;

@Controller
public class GatoController {
	
	@RequestMapping(value = "/cadastro/gato", method = RequestMethod.GET)
	public String telaCadastro() {
		return "gato/cadastro";
	}
	
	@PostMapping(value = "/gato/incluir")
	public String incluir(Gato gato) {
		GatoRepository.incluir(gato);
		RacaoRepository.incluir(gato);
		System.out.println(GatoRepository.obterLista());
		
		return "redirect:/lista/gato";
	}
	
	@GetMapping(value = "/lista/gato")
	public String telaLista() {
		return "gato/lista";
	}
}
