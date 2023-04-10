package br.edu.infnet.lojaracao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import br.edu.infnet.lojaracao.model.service.RacaoService;

@Controller
public class RacaoController {
	@Autowired
	RacaoService racaoService;
	
	@GetMapping(value = "/lista/racao")
	public String telaLista(Model model) {
		model.addAttribute("racao", racaoService);
		
		return "racao/lista";
	}
}
