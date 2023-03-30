package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.lojaracao.model.repository.FuncionarioRepository;

@Controller
public class AppController {

	@GetMapping(value = "/")
	public String telaIndex(Model model) {
		model.addAttribute("funcionarioStatus", FuncionarioRepository.getFuncionarioStatus());
		model.addAttribute("isFuncLogado", FuncionarioRepository.isFuncionarioLogado());

		return "index";
	}
}
