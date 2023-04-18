package br.edu.infnet.lojaracao.controller;

import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.domain.Venda;
import br.edu.infnet.lojaracao.model.exceptions.RacaoNaoAtribuidaException;
import br.edu.infnet.lojaracao.model.service.ClienteService;
import br.edu.infnet.lojaracao.model.service.RacaoService;
import br.edu.infnet.lojaracao.model.service.VendaService;

@Controller
public class VendaController {
	@Autowired
	ClienteService clienteService;
	@Autowired
	RacaoService racaoService;
	@Autowired
	VendaService vendaService;
	
	@GetMapping(value = "/cadastro/venda")
	public String telaCadastro(Model model) {
		model.addAttribute("cliente", clienteService);
		model.addAttribute("racao", racaoService);
		return "venda/cadastro";
	}
	
	@PostMapping(value = "/venda/incluir")
	public String incluir(Venda venda, HttpSession session, SessionStatus status, Model model){
		try {
			venda.getRacoes();
			status.setComplete();
			venda.setFuncionario((Funcionario)	session.getAttribute("funcionarioLogado"));
			vendaService.incluir(venda);
			return "redirect:/lista/venda";
			
		} catch (RacaoNaoAtribuidaException e) {
			System.out.println(e.getMessage());
			model.addAttribute("racaoException", "Ração não informada");
			model.addAttribute("cliente", clienteService);
			model.addAttribute("racao", racaoService);
			return "venda/cadastro";
		}
		
	}
	
	@GetMapping(value = "/lista/venda")
	public String telaLista(@RequestParam("id") Optional<String> idParam, Model model) {
		model.addAttribute("venda", vendaService);
		if (!idParam.isEmpty()) {
			vendaService.excluir(Integer.parseInt(idParam.get().toString()));
		}
		return "venda/lista";
	}
}
