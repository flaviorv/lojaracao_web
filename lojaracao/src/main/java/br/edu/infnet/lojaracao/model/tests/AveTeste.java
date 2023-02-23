package br.edu.infnet.lojaracao.model.tests;
import br.edu.infnet.lojaracao.model.domain.Ave;
import br.edu.infnet.lojaracao.model.exceptions.NumeroBaixoException;
import br.edu.infnet.lojaracao.model.exceptions.PalavraInvalidaException;

public class AveTeste {
	public static void main(String[] args) {
		Ave a1 = new Ave("VaroTorneio", 234, 24.23f);
		try {
			a1.setAroma("Mamão");
			a1.setPeso(0.2f);
			a1.setTipo("Canário");
			System.out.println(a1.toString());
		
		} catch (PalavraInvalidaException | NumeroBaixoException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
