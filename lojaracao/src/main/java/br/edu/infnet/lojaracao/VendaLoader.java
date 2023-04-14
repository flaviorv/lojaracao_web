package br.edu.infnet.lojaracao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.domain.Racao;
import br.edu.infnet.lojaracao.model.domain.Venda;
import br.edu.infnet.lojaracao.model.service.ClienteService;
import br.edu.infnet.lojaracao.model.service.RacaoService;
import br.edu.infnet.lojaracao.model.service.VendaService;

@Order(6)
@Component
public class VendaLoader implements ApplicationRunner {
	@Autowired
	private VendaService vendaService;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private RacaoService racaoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {

			String arquivo = "vendas.txt";

			try {
				System.out.println("Venda Loader iniciado.");
				FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);

				String linha = br.readLine();
				String[] campos = null;

				int quantidade = 0;

				while (linha != null) {
					campos = linha.split(";");

					Venda venda = new Venda(campos[0], Boolean.parseBoolean(campos[1]), campos[2],
							clienteService.obteCliente(quantidade + 1), (List<Racao>) racaoService.obterLista());
					Funcionario funcionario = new Funcionario();
					funcionario.setId(1);
					venda.setFuncionario(funcionario);
					vendaService.incluir(venda);
					System.out.println(venda);
					linha = br.readLine();
					quantidade++;
				}

				System.out.println("Quantidade de vendas adicionadas pelo loader: " + quantidade);

				br.close();
				fr.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Vendas Loader finalizado");
		}

	}

}
