package br.edu.infnet.lojaracao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.lojaracao.model.service.ClienteService;
import br.edu.infnet.lojaracao.model.service.RacaoService;

@Controller
public class VendaController {
	@Autowired
	ClienteService clienteService;
	@Autowired
	RacaoService racaoService;
	
	@GetMapping(value = "/cadastro/venda")
	public String telaCadastro(Model model) {
		model.addAttribute("cliente", clienteService);
		model.addAttribute("racao", racaoService);
		return "venda/cadastro";
	}
	
	@PostMapping(value = "venda/incluir")
	public void incluir() {
		
	}
}
