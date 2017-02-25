package fr.esiea.unique.debout.naudet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	//private static Scanner sc;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int x; int rep=0;
		Scanner sc = null;
		
		while(rep==0){
			try {
					System.out.println("Bonjour et bienvenue dans notre jeu letterGame");
					System.out.println("Pour jouer tout seul taper 1, pour jouer à deux taper 2");
					sc = new Scanner(System.in);
					x = sc.nextInt();
		
					if(x==1){
						Game jeu = new Game();
						jeu.main(1);
						rep=1;
					}
					else if(x==2) {
						Game jeu = new Game();
						jeu.main(2);
						rep=1;
					}
			}
			catch(InputMismatchException e){
	             System.out.println("vous n'avez pas entré 1 ou 2 !");
				}
		}
		
		//System.out.println(easy);
		sc.close();

	}

}
