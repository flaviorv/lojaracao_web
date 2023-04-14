package br.edu.infnet.lojaracao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.lojaracao.model.domain.Cao;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.service.CaoService;
@Order(4)
@Component
public class CaoLoader implements ApplicationRunner  {
	@Autowired
	private CaoService caoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {

			String arquivo = "cao.txt";

			try {
				System.out.println("Cao Loader iniciado.");

				FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);

				String linha = br.readLine();
				String[] campos = null;

				int quantidade = 0;

				while (linha != null) {
					campos = linha.split(";");
					Cao cao = new Cao(campos[0], Integer.parseInt(campos[1]), 
							Float.parseFloat(campos[2]), Boolean.parseBoolean(campos[3]),
							Boolean.parseBoolean(campos[4]), campos[5]);
					Funcionario funcionario = new Funcionario();
					funcionario.setId(1);
					cao.setFuncionario(funcionario);
					caoService.incluir(cao);
					System.out.println(cao + " incluido");
					linha = br.readLine();
					quantidade++;
				}

				System.out.println("Quantidade de racoes de cao adicionadas pelo loader: " + quantidade);

				br.close();
				fr.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Cao Loader finalizado");
		}

	}

}
