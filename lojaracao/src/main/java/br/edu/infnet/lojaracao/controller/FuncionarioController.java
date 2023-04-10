package br.edu.infnet.lojaracao.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.service.FuncionarioService;

@Controller
@SessionAttributes({ "status", "funcionarioLogado" })
public class FuncionarioController {
	@Autowired
	private FuncionarioService funcionarioService;

	@GetMapping(value = "/acesso/funcionario")
	public String telaAcesso() {

		return "funcionario/acesso";
	}

	@PostMapping(value = "/funcionario/validar")
	public String validarFuncionario(@RequestParam String email, @RequestParam String senha, Model model) {
		Funcionario funcionarioValido = new Funcionario();
		funcionarioValido.setEmail(email);
		funcionarioValido.setSenha(senha);
		funcionarioValido = funcionarioService.autenticar(funcionarioValido);
		if (funcionarioValido != null) {
			model.addAttribute("funcionarioLogado", funcionarioValido);
			model.addAttribute("status", "Funcionário Logado");
			return "redirect:/";
		}
		model.addAttribute("status", "Dados Inválidos");
		System.out.println("Dados Inválidos");
		return "redirect:/acesso/funcionario";
	}

	@GetMapping(value = "/cadastro/funcionario")
	public String telaCadastro() {
		return "funcionario/cadastro";
	}

	@PostMapping(value = "/funcionario/incluir")
	public String incluir(Model model, Funcionario novoFuncionario, 
			HttpSession session) {
		
		if (funcionarioService.autenticar(novoFuncionario) != null) {
			System.out.println("Já Existe Funcionário Com Este Email");
			model.addAttribute("status", "Já Existe Funcionário Com Este Email");
			return "funcionario/cadastro";

		} else {
			funcionarioService.incluir(novoFuncionario);
			System.out.println("Funcionário Cadastrado Com Sucesso");
			model.addAttribute("status", "Funcionário Cadastrado Com Sucesso");
			return "redirect:/acesso/funcionario";
		}		
		
	}

	@GetMapping(value = "/funcionario/sair")
	public String telaIndex(HttpSession session, SessionStatus status) {
		status.setComplete();
		session.removeAttribute("funcionarioLogado");
		session.removeAttribute("status");
		return "redirect:/";
	}
	
	@GetMapping(value = "/lista/funcionario")
	public String telaLista(@RequestParam("id") Optional<String> idParam, Model model) {
		System.out.println(idParam.toString());
		model.addAttribute("funcionario", funcionarioService);
		if (!idParam.isEmpty()) {
			funcionarioService.excluir(Integer.parseInt(idParam.get().toString()));
		}
		return "funcionario/lista";
	}

}
