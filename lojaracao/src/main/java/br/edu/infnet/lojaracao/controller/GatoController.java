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

import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.domain.Gato;
import br.edu.infnet.lojaracao.model.service.GatoService;

@Controller
public class GatoController {

	@Autowired
	GatoService gatoService;
	
	@RequestMapping(value = "/cadastro/gato", method = RequestMethod.GET)
	public String telaCadastro() {
		return "gato/cadastro";
	}

	@PostMapping(value = "/gato/incluir")
	public String incluir(Gato gato, HttpSession session, SessionStatus status) {
		status.setComplete();
		gato.setFuncionario((Funcionario) session.getAttribute("funcionarioLogado"));
		gatoService.incluir(gato);
		System.out.println(gatoService.obterLista());

		return "redirect:/lista/gato";
	}

	@GetMapping(value = "/lista/gato")
	public String telaLista(@RequestParam("id") Optional<String> idParam, Model model) {
		model.addAttribute("gato", gatoService);
		if (!idParam.isEmpty()) {
			gatoService.excluir(Integer.parseInt(idParam.get().toString()));
		}
		return "gato/lista";
	}
}
