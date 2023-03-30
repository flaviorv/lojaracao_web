package br.edu.infnet.lojaracao.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.lojaracao.model.domain.Cliente;
import br.edu.infnet.lojaracao.model.repository.ClienteRepository;


@Controller
public class ClienteController {
	
	@RequestMapping(value = "/cadastro/cliente", method = RequestMethod.GET)
	public String telaCadastro() {
		return "cliente/cadastro";
	}
	
	@PostMapping(value = "/cliente/incluir")
	public String incluir(Cliente cliente) {
		ClienteRepository.incluir(cliente);
		return "redirect:/lista/cliente";
	}
	
	@GetMapping(value = "/lista/cliente")
	public String telaLista(@RequestParam("id") Optional<String> idParam) {
		System.out.println(idParam.toString());
		if(!idParam.isEmpty()) {
			ClienteRepository.excluir(Integer.parseInt(idParam.get().toString()));
		}
		return "cliente/lista";
	}
	
}
