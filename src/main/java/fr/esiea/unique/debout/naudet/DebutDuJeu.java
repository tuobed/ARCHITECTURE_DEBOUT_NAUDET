package fr.esiea.unique.debout.naudet;

//import java.util.Scanner;
public class DebutDuJeu {

	
Player joueur1 = new Player(false);
Player joueur2 = new Player(false);

	public DebutDuJeu(Player joueur1, Player joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}

	
	public void main(int mode) {
				
		joueur1.player = 1;
		joueur2.player = 2;
		String fichierPath = "src/main/java/fr/esiea/unique/debout/naudet/dico.txt";
		Lettre lettre = new Lettre('n',1);
		lettre.tableau();
			
		////////////////    1er tour    /////////////////
		System.out.println("Le joueur 1 tire une lettre");
		joueur1.lettreDeDepart.letter = lettre.getLetter();
		Game.remplirLePotCommun(joueur1.lettreDeDepart);
		System.out.println("Le joueur 1 a tiré la lettre: " + joueur1.lettreDeDepart.letter);
		
		System.out.println("Le joueur 2 tire une lettre");
		joueur2.lettreDeDepart.letter = lettre.getLetter();
		Game.remplirLePotCommun(joueur2.lettreDeDepart);
		System.out.println("Le joueur 2 a tiré la lettre: " + joueur2.lettreDeDepart.letter);
		
		int tour = lettre.compareLetter(joueur1.lettreDeDepart.letter, joueur2.lettreDeDepart.letter);
		if(tour==2 && mode==1) {
			System.out.println("joueur 2 a toi de commencer");
			joueur2.tour = true;
			Piocher2Lettres.piocher2Lettres();
			IntelligenceArtificielle ia = new IntelligenceArtificielle(joueur2);
			ia.intelligenceArtificielle(fichierPath);
		}
		else if(tour==1) {
			System.out.println("joueur 1 a toi de commencer");
			joueur1.tour = true;
			Piocher2Lettres.piocher2Lettres();
			ChoixJoueur choixJoueur = new ChoixJoueur(joueur1,joueur2);
			choixJoueur.choixJoueur();
		}
		else if(tour==2 && mode==2) {
			System.out.println("joueur 2 a toi de commencer");
			joueur2.tour = true;
			Piocher2Lettres.piocher2Lettres();
			ChoixJoueur choixJoueur = new ChoixJoueur(joueur1,joueur2);
			choixJoueur.choixJoueur();
		}

		
		

	}

}
