package br.edu.infnet.lojaracao.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import br.edu.infnet.lojaracao.model.domain.Cliente;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
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
	public String incluir(Cliente cliente, HttpSession session, SessionStatus status) {
		status.setComplete();
		cliente.setFuncionario((Funcionario) session.getAttribute("funcionarioLogado"));
		clienteService.incluir(cliente);
		return "redirect:/lista/cliente";
	}

	@GetMapping(value = "/lista/cliente")
	public String telaLista(@RequestParam("id") Optional<String> idParam, Model model) {
		model.addAttribute("cliente", clienteService);
		if (!idParam.isEmpty()) {
			try {
				clienteService.excluir(Integer.parseInt(idParam.get().toString()));
			} catch (Exception e) {
				return "redirect:/lista/venda";
			}
		}
		return "cliente/lista";
	}

}
