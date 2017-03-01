package test;

import static org.junit.Assert.*;
import org.junit.Test;

import fr.esiea.unique.debout.naudet.Player;
import fr.esiea.unique.debout.naudet.SaisirEtVerifierMot;

public class SaisirEtVerifierMotTest {

	Player joueur1 = new Player(false);
	Player joueur2 = new Player(false);
	
	@Test
	public void testSaisirEtVerifierMot() {
		int result;
		int resultAttendu = 0;
		
		SaisirEtVerifierMot sevm = new SaisirEtVerifierMot(joueur1, joueur2);
		result = sevm.saisirEtVerifierMot();
		assertTrue("", result == resultAttendu);
	}
}
