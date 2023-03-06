package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RacaoController {
	@GetMapping(value="lista/racao")
	public String telaLista() {
		return "racao/lista";
	}
}
