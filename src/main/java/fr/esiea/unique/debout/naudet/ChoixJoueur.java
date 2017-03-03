package fr.esiea.unique.debout.naudet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChoixJoueur {
	//Cette classe va demander au joueur si il veut passer ou entrer un mot


	Player joueur1 = new Player(false);
	Player joueur2 = new Player(false);
	private Scanner sc;
	
	public ChoixJoueur(Player joueur1, Player joueur2) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
	
	public void choixJoueur() {
		
		
		int x; int rep =0;
		
		while(rep==0 ) {
			
			try {
				System.out.println("");
				System.out.println("Taper 1 pour entrer un mot, ou 2 pour passer son tour");
				sc = new Scanner(System.in);
				x = sc.nextInt();
				
				if(x==1) {
					final SaisirEtVerifierMot sevm = new SaisirEtVerifierMot(joueur1,joueur2);
					sevm.saisirEtVerifierMot();
					rep = 1;
					
				}
				else if(x==2) {
					
					System.out.println("Vous avez passé votre tour ");
					Game.afficherLePotCommun();
					rep = 1;
					
				}
				
			}
			catch(InputMismatchException e){
             System.out.println("vous n'avez pas entré 1 ou 2 !");
			}
			
		}
		
	}
}
