package br.edu.infnet.lojaracao.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.lojaracao.model.domain.Endereco;
import br.edu.infnet.lojaracao.model.service.EnderecoService;
@Controller
public class EnderecoController {
	@Autowired
	EnderecoService enderecoService;
	
	@GetMapping(value = "/cep/pesquisar")
	public ModelAndView telaIndex(@RequestParam("cep") Optional<String> cepParam) {
		String cep = cepParam.isEmpty()?"":cepParam.get();
		ModelAndView mv = new ModelAndView("cliente/cadastro");
		if(cep != "") {
			Endereco endereco = enderecoService.obterEndereco(cep);
			mv.addObject("cep", endereco.getCep());
			mv.addObject("logradouro", endereco.getLogradouro());
			mv.addObject("complemento", endereco.getComplemento());
			mv.addObject("bairro", endereco.getBairro());
			mv.addObject("localidade", endereco.getLocalidade());
			mv.addObject("uf", endereco.getUf());
		}
		return mv;
	}
}
