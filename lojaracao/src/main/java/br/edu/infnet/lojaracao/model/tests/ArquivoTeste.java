package br.edu.infnet.lojaracao.model.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ArquivoTeste {
	public static void main(String[] args) {

		try {
			String diretorio = "C:\\INFNET\\java\\java_web\\assessment\\src\\";
			String arquivo = "lojaDeRacao.txt";

			FileReader fr = new FileReader(diretorio + arquivo);
			BufferedReader br = new BufferedReader(fr);

			String linha = br.readLine();
			String[] campos = null;

			int quantidade = 0;

			while (linha != null) {
				campos = linha.split(";");

				switch (campos[0].toUpperCase()) {
				case "V":
					System.out.println(escrever(diretorio, arquivo, campos[5].toString() + "\r\n", false));
					break;
				case "A", "C", "G":
					quantidade++;
					break;
				}

				System.out.println(Arrays.asList(campos));
				linha = br.readLine();
			}

			System.out
					.println(escrever(diretorio, arquivo, "Quantidade de objetos da classe mãe: " + quantidade, true));

			br.close();
			fr.close();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public static String escrever(String diretorio, String arquivo, String conteudo, boolean naoSobrescrever) {
		String status = null;

		try {
			FileWriter fw;
			fw = new FileWriter(diretorio + "out_" + arquivo, naoSobrescrever);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(conteudo);
			bw.close();
			fw.close();
			status = "Escrita realizada com sucesso";
		} catch (IOException e) {
			status = "Erro";
			System.out.println(e.getMessage());
		}
		return status;
	}
}
