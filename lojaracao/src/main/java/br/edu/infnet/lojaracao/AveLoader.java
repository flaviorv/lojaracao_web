package br.edu.infnet.lojaracao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.lojaracao.model.domain.Ave;
import br.edu.infnet.lojaracao.model.domain.Funcionario;
import br.edu.infnet.lojaracao.model.service.AveService;

@Order(3)
@Component
public class AveLoader implements ApplicationRunner {
	@Autowired
	private AveService aveService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		try {

			String arquivo = "ave.txt";

			try {

				FileReader fr = new FileReader(arquivo);
				BufferedReader br = new BufferedReader(fr);

				String linha = br.readLine();
				String[] campos = null;

				int quantidade = 0;

				while (linha != null) {
					campos = linha.split(";");

					Ave ave = new Ave(campos[0], Integer.parseInt(campos[1]), Float.parseFloat(campos[2]), campos[3],
							campos[4], Float.parseFloat(campos[5]));
					Funcionario funcionario = new Funcionario();
					funcionario.setId(1);
					ave.setFuncionario(funcionario);
					aveService.incluir(ave);
					System.out.println(ave + " incluido");
					linha = br.readLine();
					quantidade++;
				}

				System.out.println("Quantidade de racoes de ave adicionadas pelo loader: " + quantidade);

				br.close();
				fr.close();

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}

		} finally {
			System.out.println("Ave Loader finalizado");
		}

	}

}
