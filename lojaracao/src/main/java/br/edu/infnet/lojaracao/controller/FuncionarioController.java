package br.edu.infnet.lojaracao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	@RequestMapping(value = "/acesso/funcionario", method = RequestMethod.GET)
	public String telaAcesso() {
		FuncionarioRepository.setFuncionarioStatus("Acessar como funcionário");
		return "funcionario/acesso";
	}
	
	@GetMapping(value = "/acesso/funcionario/invalido")
	public String funcionarioInvalido() {
		FuncionarioRepository.setFuncionarioStatus("Dados de funcionário inválido");
		return "funcionario/acesso";
	}
	
	@PostMapping(value = "/funcionario/validar")
	public String validar(Funcionario funcionario) {
		if(FuncionarioRepository.validarAcesso(funcionario)) {
			FuncionarioRepository.setFuncionarioStatus("Bem vindo: " + funcionario.getNome());
			FuncionarioRepository.setFuncionarioLogado(true);
			return "redirect:/";
		}	
		return "redirect:/acesso/funcionario/invalido";
	}

	@GetMapping(value = "/cadastro/funcionario")
	public String telaCadastro() {
		return "funcionario/cadastro";
	}

	
	@PostMapping(value = "/funcionario/incluir")
	public String incluir(Funcionario funcionario){
		FuncionarioRepository.incluir(funcionario);
		return "redirect:/acesso/funcionario";
	}
	
	@GetMapping(value = "/funcionario/sair")
	public String telaIndex() {
		FuncionarioRepository.encerrarSessao();
		return "redirect:/";
	}
	
	
}
