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
import br.edu.infnet.lojaracao.model.domain.Gato;
import br.edu.infnet.lojaracao.model.service.GatoService;
@Order(5)
@Component
public class GatoLoader implements ApplicationRunner  {

	@Autowired
	private GatoService gatoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {

			String arquivo = "gato.txt";

			try {
				System.out.println("Gato Loader iniciado.");
				FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);

				String linha = br.readLine();
				String[] campos = null;

				int quantidade = 0;

				while (linha != null) {
					campos = linha.split(";");
					Gato gato = new Gato(campos[0], Integer.parseInt(campos[1]), 
							Float.parseFloat(campos[2]), campos[3],
							Boolean.parseBoolean(campos[4]), Boolean.parseBoolean(campos[5]));
					Funcionario funcionario = new Funcionario();
					funcionario.setId(1);
					gato.setFuncionario(funcionario);
					gatoService.incluir(gato);
					System.out.println(gato + " incluido");
					linha = br.readLine();
					quantidade++;
				}

				System.out.println("Quantidade de racoes de gato adicionadas pelo loader: " + quantidade);

				br.close();
				fr.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Gato Loader finalizado");
		}

	}

}
