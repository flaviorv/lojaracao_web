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
import br.edu.infnet.lojaracao.model.domain.Cao;
import br.edu.infnet.lojaracao.model.service.CaoService;

@Controller
public class CaoController {
	
	@Autowired
	CaoService caoService;
	
	@RequestMapping(value = "/cadastro/cao", method = RequestMethod.GET)
	public String telaCadastro() {
		return "cao/cadastro";
	}

	@PostMapping(value = "/cao/incluir")
	public String incluir(Cao cao) {
		caoService.incluir(cao);
		System.out.println(caoService.obterLista());
		return "redirect:/lista/cao";
	}

	@GetMapping(value = "/lista/cao")
	public String telaLista(@RequestParam("id") Optional<String> idParam, Model model) {
		System.out.println("Tentativa de exclusão pelo id: " + idParam.toString());
		model.addAttribute("cao", caoService);
		if (!idParam.isEmpty()) {
			caoService.excluir(Integer.parseInt(idParam.get().toString()));
		}
		return "cao/lista";
	}
}
