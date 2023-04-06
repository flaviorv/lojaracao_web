package br.edu.infnet.lojaracao.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.infnet.lojaracao.model.domain.Cliente;
import br.edu.infnet.lojaracao.model.service.ClienteService;

@Controller
public class ClienteController {
	@Autowired
	ClienteService clienteService;

	@RequestMapping(value = "/cadastro/cliente", method = RequestMethod.GET)
	public String telaCadastro() {
		return "cliente/cadastro";
	}

	@PostMapping(value = "/cliente/incluir")
	public String incluir(Cliente cliente) {
		clienteService.incluir(cliente);
		return "redirect:/lista/cliente";
	}

	@GetMapping(value = "/lista/cliente")
	public String telaLista(@RequestParam("id") Optional<String> idParam, Model model) {
		System.out.println(idParam.toString());
		model.addAttribute("cliente", clienteService);
		if (!idParam.isEmpty()) {
			clienteService.excluir(Integer.parseInt(idParam.get().toString()));
		}
		return "cliente/lista";
	}

}
