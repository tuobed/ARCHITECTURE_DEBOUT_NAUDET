package test;

import static org.junit.Assert.*;
import org.junit.Test;

import fr.esiea.unique.debout.naudet.Game;
import fr.esiea.unique.debout.naudet.Lettre;



public class GameTest {

	@Test
	public void testRemplirLePotCommun () {
		int result;		
		int resultAttendu=1;

		Lettre lettre = new Lettre('n', 1);
		lettre.tableau();
		lettre.letter='A';
		result=Game.remplirLePotCommun(lettre);
		assertTrue("", result==resultAttendu);
		
	}
	
	@Test
	public void testCheckTheWordPotCommun() {
		
		int result;		
		int resultAttendu=1;
		String mot = "mot";
		Lettre lettreM = new Lettre('M', 1);
		Lettre lettreO = new Lettre('O', 1);
		Lettre lettreT = new Lettre('T', 1);
		
		Game.remplirLePotCommun(lettreM);
		Game.remplirLePotCommun(lettreO);
		Game.remplirLePotCommun(lettreT);
		result=Game.checkTheWordPotCommun(mot);
		assertTrue("", result==resultAttendu);
		
		
	}
}
