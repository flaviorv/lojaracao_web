package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.lojaracao.model.domain.Usuario;

@Controller
public class UsuarioController {
	
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public String telaCadastro() {
		return "usuario/cadastro";
	}
	
	@PostMapping(value = "/usuario/incluir")
	public String incluirUsuario(Usuario usuario) {
		System.out.println("Usuário: " + usuario);
		
		return "redirect:/";
	}
	
}
