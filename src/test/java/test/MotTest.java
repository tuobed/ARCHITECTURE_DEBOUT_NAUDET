package test;

import static org.junit.Assert.*;
import org.junit.Test;
import fr.esiea.unique.debout.naudet.Mots;

public class MotTest {
	
	@Test
	public void testVerifierSiMotDansMotsCommuns() {
		
		int result;
		int result2;
		int resultAttendu = 1;
		int resultAttendu2 = 0;
		String mot = "bonjour";
		String mot2 = "coucou";
		Mots.remplirLeTableauDeMot(mot);
		result = Mots.verifierSiMotDansMotsCommuns(mot);
		result2 = Mots.verifierSiMotDansMotsCommuns(mot2);
		assertTrue("Le mot est dans le pot de mot commun", resultAttendu == result);
		assertTrue("Le mot n'est pas dans le pot commun de mot", resultAttendu2 == result2);
				
	}

}
