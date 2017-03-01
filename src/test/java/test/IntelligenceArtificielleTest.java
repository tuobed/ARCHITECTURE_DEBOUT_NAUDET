package test;

import org.junit.Test;

import fr.esiea.unique.debout.naudet.IntelligenceArtificielle;
import fr.esiea.unique.debout.naudet.Player;

public class IntelligenceArtificielleTest {

	Player joueurIA = new Player(false);
	
	@Test
	public void testIntelligenceArtificielle() {
		String fichierPath = "src/main/java/fr/esiea/unique/debout/naudet/dico.txt";
		IntelligenceArtificielle ia = new IntelligenceArtificielle(joueurIA);
		ia.intelligenceArtificielle(fichierPath);
		
	}
}
