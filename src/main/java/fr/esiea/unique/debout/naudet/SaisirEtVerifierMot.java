package fr.esiea.unique.debout.naudet;


import java.util.Scanner;

public class SaisirEtVerifierMot {

	private static Scanner sc;
	Player joueur1 = new Player(false);
	Player joueur2 = new Player(false);
	
	public SaisirEtVerifierMot(Player joueur1, Player joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
	
	public void saisirEtVerifierMot() {
		
		Lettre nouvelleLettre = new Lettre('n',1);
		Lettre lettre = new Lettre('n',1);
		lettre.tableau();
		String fichierPath = "src/main/java/fr/esiea/unique/debout/naudet/dico.txt";
		Fichier fichier = new Fichier(fichierPath);
		
		System.out.println("");
		System.out.println("");
		System.out.println("Veuillez saisir un mot :");
		
		sc = new Scanner(System.in);
		String mot = sc.nextLine();
		int resultPotCommun = Game.checkTheWordPotCommun(mot);
		int resultDictionary = fichier.checkIfWordCorrect(fichierPath, mot);
		int resultMotsCommuns = Mots.verifierSiMotDansMotsCommuns(mot);
		
		if((resultPotCommun == 1 && resultDictionary == 1) || (resultDictionary == 1 && resultMotsCommuns == 1)) {
			Game.updatePotCommun(mot);
			Mots.remplirLeTableauDeMot(mot);
			Mots.afficherLeTableauDeMot();
			if(joueur1.tour==true) {
				joueur1.nbMot++;
				
				System.out.println("Repiocher une carte");
				nouvelleLettre.letter=lettre.getLetter();
				Game.remplirLePotCommun(nouvelleLettre);
				System.out.println("Vous avez pioch�: " + nouvelleLettre.letter);
				Game.afficherLePotCommun();
				
				SaisirEtVerifierMot sevm = new SaisirEtVerifierMot(joueur1,joueur2);
				sevm.saisirEtVerifierMot();
				
			}
			else {
				joueur2.nbMot++;
				nouvelleLettre.letter=lettre.getLetter();
				Game.remplirLePotCommun(nouvelleLettre);
				Game.afficherLePotCommun();
				
				SaisirEtVerifierMot sevm = new SaisirEtVerifierMot(joueur1,joueur2);
				sevm.saisirEtVerifierMot();
			}
		}
		else {
			Game.afficherLePotCommun();
			Mots.afficherLeTableauDeMot();
		}
	}
}
