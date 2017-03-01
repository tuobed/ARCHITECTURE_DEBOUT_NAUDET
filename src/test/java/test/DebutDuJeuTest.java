package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.esiea.unique.debout.naudet.DebutDuJeu;
import fr.esiea.unique.debout.naudet.Player;


public class DebutDuJeuTest {

	Player joueur1 = new Player(false);
	Player joueur2 = new Player(false);
	
	@Test
	public void testMain() {
		
		int result1;
		int result2;
		int mode1 = 1;
		int mode2= 2;
		int resultAttendu = 0;
		
		DebutDuJeu ddj = new DebutDuJeu(joueur1, joueur2);
		result1 = ddj.main(mode1);
		result2 = ddj.main(mode2);
		assertTrue("", result1 == resultAttendu);
		assertTrue("", result2 == resultAttendu);
	}
}
