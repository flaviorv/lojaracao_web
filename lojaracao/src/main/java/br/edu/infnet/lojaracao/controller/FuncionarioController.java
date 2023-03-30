package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	@GetMapping(value = "/acesso/funcionario")
	public String telaAcesso(Model model) {
		FuncionarioRepository.setFuncionarioStatus("Acessar como funcionário");
		model.addAttribute("funcionarioStatus", FuncionarioRepository.getFuncionarioStatus());
		return "funcionario/acesso";
	}
	
	@PostMapping(value = "/funcionario/validar/index")
	public String validarTelaIndex(Funcionario funcionario, Model model) {
		if(FuncionarioRepository.validarAcesso(funcionario)) {
			FuncionarioRepository.setFuncionarioStatus("Bem vindo: " + funcionario.getNome());
			model.addAttribute("funcionarioStatus", FuncionarioRepository.getFuncionarioStatus());
			model.addAttribute("isFuncLogado", FuncionarioRepository.isFuncionarioLogado());
			System.out.println(FuncionarioRepository.isFuncionarioLogado());
			return "index";
		}	
		FuncionarioRepository.setFuncionarioStatus("Dados de funcionário inválido");
		model.addAttribute("funcionarioStatus", FuncionarioRepository.getFuncionarioStatus());
		return "funcionario/acesso";
	}

	@GetMapping(value = "/cadastro/funcionario")
	public String telaCadastro() {
		return "funcionario/cadastro";
	}

	
	@PostMapping(value = "/funcionario/incluir")
	public String incluir(Model model, Funcionario funcionario){
		FuncionarioRepository.incluir(funcionario);
		FuncionarioRepository.setFuncionarioStatus("Funcionário Cadastrado com Sucesso!");
		model.addAttribute("funcionarioStatus", FuncionarioRepository.getFuncionarioStatus());
		return "/funcionario/acesso";
	}
	
	@GetMapping(value = "/funcionario/sair")
	public String telaIndex() {
		FuncionarioRepository.encerrarSessao();
		return "redirect:/";
	}
	
}
