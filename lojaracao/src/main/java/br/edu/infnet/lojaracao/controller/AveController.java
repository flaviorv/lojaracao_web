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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import br.edu.infnet.lojaracao.model.domain.Ave;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.service.AveService;

@Controller
@SessionAttributes()
public class AveController {
	@Autowired
	AveService aveService;

	@RequestMapping(value = "/cadastro/ave", method = RequestMethod.GET)
	public String telaCadastro() {

		return "ave/cadastro";

	}

	@PostMapping(value = "/ave/incluir")
	public String incluir(Ave ave, HttpSession session, SessionStatus status) {
		status.setComplete();
		ave.setFuncionario((Funcionario) session.getAttribute("funcionarioLogado"));
		aveService.incluir(ave);
		System.out.println(aveService.obterLista());
		return "redirect:/lista/ave";
	}

	@GetMapping(value = "/lista/ave")
	public String telaLista(@RequestParam("id") Optional<String> idParam, Model model) {
		System.out.println("Tentativa de exclusão pelo id: " + idParam.toString());
		model.addAttribute("ave", aveService);
		if (!idParam.isEmpty()) {
			aveService.excluir(Integer.parseInt(idParam.get().toString()));
		}
		return "ave/lista";
	}
}
