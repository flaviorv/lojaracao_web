package br.edu.infnet.lojaracao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.service.FuncionarioService;
import br.edu.infnet.lojaracao.model.service.FuncionarioService;

@Order(1)
@Component
public class FuncionarioLoader implements ApplicationRunner {
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		try {

			String arquivo = "funcionarios.txt";

			try {

				FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);

				String linha = br.readLine();
				String[] campos = null;

				int quantidade = 0;

				while (linha != null) {
					campos = linha.split(";");

					Funcionario funcionario = new Funcionario(campos[0], campos[1], campos[2]);
					funcionario.setAdmin(true);
					funcionarioService.incluir(funcionario);
					System.out.println(funcionario + " incluido");
					linha = br.readLine();
					quantidade++;
				}
				

				System.out.println("Quantidade de funcionarios adicionados pelo loader: " + quantidade);

				br.close();
				fr.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Funcionario Loader finalizado");
		}

	}

}
