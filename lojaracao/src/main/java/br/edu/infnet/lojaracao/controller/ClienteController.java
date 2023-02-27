package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.edu.infnet.lojaracao.model.domain.Cliente;

@Controller
public class ClienteController {
	
	@RequestMapping(value = "cadastro/cliente", method = RequestMethod.GET)
	public String telaCadastro() {
		return "cadastro/cliente";
	}
	
	@PostMapping(value = "/cliente/incluir")
	public String incluirCliente(Cliente cliente) {
		System.out.println("Cliente: " + cliente);
		
		return "redirect:/confirmacao/cliente";
	}
	
	@GetMapping(value = "/confirmacao/cliente")
	public String confirmarCadastroCliente() {
		return "confirmacao/cliente";
	}

	
}
