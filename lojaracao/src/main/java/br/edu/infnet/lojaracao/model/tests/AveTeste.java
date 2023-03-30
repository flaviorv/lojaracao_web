package br.edu.infnet.lojaracao.model.tests;
import br.edu.infnet.lojaracao.model.domain.Ave;

public class AveTeste {
	public static void main(String[] args) {
		
		Ave a1 = new Ave(1, "RacaoAve1", 234, 24.23f, "Canário", "Mamão", 1.1f);
		System.out.println(a1.toString());
		
	}
}
