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

import br.edu.infnet.lojaracao.model.domain.Cao;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
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
	public String incluir(Cao cao, HttpSession session, SessionStatus status) {
		status.setComplete();
		cao.setFuncionario((Funcionario) session.getAttribute("funcionarioLogado"));
		caoService.incluir(cao);
		return "redirect:/lista/cao";
	}

	@GetMapping(value = "/lista/cao")
	public String telaLista(@RequestParam("id") Optional<String> idParam, Model model) {
		model.addAttribute("cao", caoService);
		if (!idParam.isEmpty()) {
			try {
				caoService.excluir(Integer.parseInt(idParam.get().toString()));
			} catch (Exception e) {
				model.addAttribute("statusRacao",
						"Não é possível excluir essa ração. " + "Pode ser que haja dados da ração em vendas. "
								+ "Se for o caso, exclua os dados da venda antes de excluir a ração.");
			}	}
		return "cao/lista";
	}
}
