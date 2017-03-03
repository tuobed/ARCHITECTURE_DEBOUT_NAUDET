package fr.esiea.unique.debout.naudet;


public class Game {
// Cette classe est la plus importante, elle va traiter toutes les fonctions li�es � mon potCommun.
//Elle va �galement lancer toute la structure du jeu dans la fonction Main()
	
private static Lettre potCommun[] = new Lettre [26];
private static Lettre potCommunTemp[] = new Lettre [26];

Player joueur1 = new Player(false);
Player joueur2 = new Player(false);

	
	public static int remplirLePotCommun (Lettre lettre) {
		int flag=0;
		int flag2=0;
		for(int i = 0; i<potCommun.length; i++) {
			if(potCommun[i] != null && potCommun[i].letter == lettre.letter && flag==0) {
				potCommun[i].nombre = potCommun[i].nombre +1; 
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
	
		for(int i=0; i<potCommunTemp.length; i++) {
			if(potCommun[i] != null) {
				potCommunTemp[i] =  new Lettre(potCommun[i].letter,potCommun[i].nombre);
				//potCommunTemp[i].nombre = potCommun[i].nombre;
				//potCommunTemp[i].letter = potCommun[i].letter;
			}
		}
	
	}
	
	public static void viderLePotCommunTemp() {
		
		for(int i=0; i<potCommunTemp.length; i++) {
			if(potCommunTemp[i] != null) {
				potCommunTemp[i] = null;
			}
		}
	
	}
	
	public static int checkTheWordPotCommun(String word) {
		word=word.toUpperCase();
		int length = word.length();
		int i, j;
		char result;
		int count = 0;
		
		remplirLePotCommunTemp();
		
		for(i=0; i<length; i++) {
			result = word.charAt(i);
			for(j=0; j<25; j++) {
				
					if(potCommunTemp[j] != null && potCommunTemp[j].letter == result) {
						if(potCommunTemp[j].nombre>1)  {
							potCommunTemp[j].nombre --;	
						}
						else  {
							potCommunTemp[j] = null;	
						}
						count ++;
						break;
					}								
			}
		}
		if(count == length) {
			viderLePotCommunTemp();
			return 1;
		}
		else {
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
						if(potCommun[j].nombre>1) {
							potCommun[j].nombre --;
							break;
						}
						else if(potCommun[j].nombre == 1) {
							potCommun[j] = null;
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
		
		while(joueur1.nbMot<10 && joueur2.nbMot < 10) {
			System.out.println("");
			System.out.println("Joueur 1 ton score:" + joueur1.nbMot);
			System.out.println("Joueur 2 ton score:" + joueur2.nbMot);
			System.out.println("");
			if(joueur1.tour==true && mode==1) {
			
				joueur1.tour = false;
				joueur2.tour = true;
				System.out.println("");
				System.out.println("Joueur IA � toi de jouer");
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
				System.out.println("Joueur 2 � toi de jouer");
				System.out.println("");
				Piocher2Lettres.piocher2Lettres();
				ChoixJoueur choixJoueur = new ChoixJoueur(joueur1,joueur2);
				choixJoueur.choixJoueur();
			}
			
			else if(joueur2.tour==true) {
			
				joueur2.tour=false;
				joueur1.tour = true;
				System.out.println("");
				System.out.println("Joueur 1 � toi de jouer");
				System.out.println("");
				Piocher2Lettres.piocher2Lettres();
				ChoixJoueur choixJoueur = new ChoixJoueur(joueur1,joueur2);
				choixJoueur.choixJoueur();
			}
			
			
		}
		if(joueur1.nbMot < 10) {
			System.out.println("");
			System.out.println("");
			System.out.println("Joueur 2 vous avez gagn�");
		}
		else {
			System.out.println("");
			System.out.println("");
			System.out.println("Joueur 1 vous avez gagn�");
		}
	}
}
