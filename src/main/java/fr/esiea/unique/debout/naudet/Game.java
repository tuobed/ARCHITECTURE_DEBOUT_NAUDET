package fr.esiea.unique.debout.naudet;

//import java.util.Scanner;

public class Game {
	
public static Lettre potCommun[] = new Lettre [25];
public static Lettre potCommunTemp[] = new Lettre [25];

Player joueur1 = new Player(false);
Player joueur2 = new Player(false);

	
	public static int remplirLePotCommun (Lettre lettre) {
		int flag=0;
		int flag2=0;
		for(int i = 0; i<potCommun.length; i++) {
			if(potCommun[i] != null && potCommun[i].letter == lettre.letter && flag==0) {
				potCommun[i].nombre++; 
				flag = 1;
				flag2=1;
			}
		}
		if(flag2==0) {
			for(int i = 0; i<potCommun.length; i++) {
					if(potCommun[i] == null && flag == 0) {
						potCommun[i] = lettre;
						potCommun[i].letter = lettre.letter;
						potCommun[i].nombre = 1;
						flag = 1;
					}
			}
		}
		return flag;
	}
	
	public static void remplirLePotCommunTemp() {
	
		for(int i=0; i<potCommun.length; i++) {
			if(potCommun[i] != null) {
				potCommunTemp[i] = potCommun[i];
				potCommunTemp[i].letter = potCommun[i].letter;
				potCommunTemp[i].nombre = potCommun[i].nombre;
			}
		}
	
	}
	
	public static void viderLePotCommunTemp() {
		
		for(int i=0; i<potCommun.length; i++) {
			if(potCommun[i] != null) {
				potCommunTemp[i] = null;

			}
		}
	
	}
	
	public static int checkTheWordPotCommun(String word) {
		word=word.toUpperCase();
		int length = word.length();
		int i, j;
		boolean quit = false;
		char result;
		int count = 0;
		//potCommunTemp[] = potCommun[];
		remplirLePotCommunTemp();
		
		for(i=0; i<length; i++) {
			result = word.charAt(i);
			for(j=0; j<25; j++) {
				
				try {
					if(potCommunTemp[j] != null && potCommunTemp[j].letter == result) {
						if(potCommunTemp[j].nombre == 1) {
							potCommunTemp[j] = null;
						}
						else {
							potCommunTemp[j].nombre --;
						}
						count ++;
						break;
					}								
				}
				catch (Exception e) {
					System.out.println(e.toString());
				}	
			}
			if( quit) {
				break;
			}
		}
		if(count == length) {
			viderLePotCommunTemp();
			return 1;
		}
		else {
			//System.out.println("Certaines lettres ne sont pas dans le pot commun");
			viderLePotCommunTemp();
			return 0;
		}
	}
	
	public static void updatePotCommun(String word) {
		word=word.toUpperCase();
		int length = word.length();
		int i, j;
		char result;
		
		for(i=0; i<length; i++) {
			result = word.charAt(i);
			for(j=0; j<25; j++) {
				
				try {
					if(potCommun[j] != null && potCommun[j].letter == result) {
						if(potCommun[j].nombre == 1) {
							potCommun[j] = null;
							break;
						}
						else {
							potCommun[j].nombre --;
							break;
						}
					}
				}
				catch (Exception e) {
					System.out.println(e.toString());
				}	
			}
		}

	}
	
	public static void afficherLePotCommun () {
		System.out.println("");
		System.out.println("Voici le pot commun: ");
		
		for(int i=0; i<25; i++) {
			if(potCommun[i] != null) {
				if(potCommun[i].nombre > 1) {
					System.out.print(potCommun[i].letter +"x" + potCommun[i].nombre + " ");
				}
				else{
					System.out.print(potCommun[i].letter +" ");
				}
			}
			else{
				System.out.print(" ");
			}
		}
	}
	
	public void main(int mode) {
		
		Lettre lettre = new Lettre('n',1);
		lettre.tableau();
		DebutDuJeu debutDuJeu = new DebutDuJeu(joueur1, joueur2);
		debutDuJeu.main(mode);
		String fichierPath = "src/main/java/fr/esiea/unique/debout/naudet/dico.txt";
		//Fichier fichier = new Fichier(fichierPath);
		
		while(joueur1.nbMot!=10 && joueur2.nbMot != 10) {
			System.out.println("");
			System.out.println("Joueur 1 ton score:" + joueur1.nbMot);
			System.out.println("Joueur 2 ton score:" + joueur2.nbMot);
			System.out.println("");
			if(joueur1.tour==true && mode==1) {
			
				joueur1.tour = false;
				joueur2.tour = true;
				System.out.println("");
				System.out.println("Joueur IA à toi de jouer");
				System.out.println("");
				
				Piocher2Lettres.piocher2Lettres();
				//ChoixJoueur choixJoueur = new ChoixJoueur(joueur1,joueur2);
				//choixJoueur.choixJoueur();	
				IntelligenceArtificielle ia = new IntelligenceArtificielle(joueur2);
				ia.intelligenceArtificielle(fichierPath);
			
			}
			else if(joueur1.tour==true && mode==2) {
				
				joueur1.tour=false;
				joueur2.tour = true;
				System.out.println("");
				System.out.println("Joueur 2 à toi de jouer");
				System.out.println("");
				Piocher2Lettres.piocher2Lettres();
				ChoixJoueur choixJoueur = new ChoixJoueur(joueur1,joueur2);
				choixJoueur.choixJoueur();
			}
			
			else if(joueur2.tour==true) {
			
				joueur2.tour=false;
				joueur1.tour = true;
				System.out.println("");
				System.out.println("Joueur 1 à toi de jouer");
				System.out.println("");
				Piocher2Lettres.piocher2Lettres();
				ChoixJoueur choixJoueur = new ChoixJoueur(joueur1,joueur2);
				choixJoueur.choixJoueur();
			}
			
			
		}
		if(joueur1.nbMot == 10) {
			System.out.println("");
			System.out.println("");
			System.out.println("Joueur 1 vous avez gagné");
		}
		else {
			System.out.println("");
			System.out.println("");
			System.out.println("Joueur 2 vous avez gagné");
		}
	}
}
