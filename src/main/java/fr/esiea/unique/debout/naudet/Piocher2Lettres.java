package fr.esiea.unique.debout.naudet;


public class Piocher2Lettres {

	//Cette classe va permettre au joueur de piocher 2 lettres
	//Elle a �t� cr�� dans le but d'a�rer mon code
	
	public static void piocher2Lettres() {
		
		Lettre nouvelleLettre1 = new Lettre('n',1);
		nouvelleLettre1.tableau();
		Lettre nouvelleLettre2 = new Lettre('n',1);
		nouvelleLettre2.tableau();
		
		System.out.println("Piocher 2 lettres ");
		
		nouvelleLettre1.letter=nouvelleLettre1.getLetter();
		Game.remplirLePotCommun(nouvelleLettre1);
		nouvelleLettre2.letter=nouvelleLettre2.getLetter();
		Game.remplirLePotCommun(nouvelleLettre2);
		System.out.println("Vous avez pioch�: " + nouvelleLettre1.letter + " et " + nouvelleLettre2.letter);
		Game.afficherLePotCommun();
		
	}
}
