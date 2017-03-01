package test;

import org.junit.Test;

import fr.esiea.unique.debout.naudet.ChoixJoueur;
import fr.esiea.unique.debout.naudet.Player;

public class ChoixJoueurTest {

	Player joueur1 = new Player(false);
	Player joueur2 = new Player(false);
	
	@Test
	public void testChoixJoueur () {
		//int resultatAttendu1 = 1;
		//int resultatAttendu2 = 2;
		
		ChoixJoueur choixDuJoueur = new ChoixJoueur(joueur1, joueur2);
		choixDuJoueur.choixJoueur();	
	}
}
