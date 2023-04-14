package br.edu.infnet.lojaracao.model.service;

import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.infnet.lojaracao.model.domain.Endereco;

@Service
public class EnderecoService {

	public Endereco obterEndereco(String cep) {
		try {
			URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			String informationString = "";
			Scanner scanner = new Scanner(url.openStream());
			while (scanner.hasNext()) {
				informationString += scanner.nextLine();
			}
			scanner.close();
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

			Endereco endereco = objectMapper.readValue(informationString, Endereco.class);

			System.out.println(endereco.getBairro());
			System.out.println("Endereco obtido com sucesso.");
			return endereco;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Endereco endereco = new Endereco();
			endereco.setCep("Cep invalido.");
			return endereco;
		}
	}

}
