package test;

import static org.junit.Assert.*;
import org.junit.Test;
import fr.esiea.unique.debout.naudet.Fichier;

public class FichierTest {

public String fileName;
	
	@Test
	public void testCheckIfWordCorrect() {
		
		String mot = "bonjour";
		String mot2 = "aipbfn";
		int resultAttendu1 = 1;
		int resultAttendu2 = 0;
		int result;
		int result2;
		String fichierPath = "src/main/java/fr/esiea/unique/debout/naudet/dico.txt";
		Fichier fichier = new Fichier(fichierPath);
		result = fichier.checkIfWordCorrect(fichierPath, mot);
		result2 = fichier.checkIfWordCorrect(fichierPath, mot2);
		assertTrue("Le mot est dans le dictionnaire", resultAttendu1== result );
		assertTrue("Le mot n'est pas dans le dictionnaire", resultAttendu2 == result2);
	}
	
	

}
