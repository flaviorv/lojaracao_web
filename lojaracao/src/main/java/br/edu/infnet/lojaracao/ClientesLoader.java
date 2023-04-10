package br.edu.infnet.lojaracao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import br.edu.infnet.lojaracao.model.domain.Cliente;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.service.ClienteService;

@Order(2)
@Component
public class ClientesLoader implements ApplicationRunner {
	@Autowired
	private ClienteService clienteService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {

			String arquivo = "clientes.txt";

			try {

				FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);

				String linha = br.readLine();
				String[] campos = null;

				int quantidade = 0;

				while (linha != null) {
					campos = linha.split(";");
					Cliente cliente = new Cliente(campos[0], campos[1], campos[2]);
					Funcionario funcionario = new Funcionario();
					funcionario.setId(1);
					cliente.setFuncionario(funcionario);
					clienteService.incluir(cliente);
					System.out.println(cliente + "incluido");
					linha = br.readLine();
					quantidade++;
				}

				System.out.println("Quantidade de clientes adicionados pelo loader: " + quantidade);

				br.close();
				fr.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Cliente Loader finalizado.");
		}

	}
}
