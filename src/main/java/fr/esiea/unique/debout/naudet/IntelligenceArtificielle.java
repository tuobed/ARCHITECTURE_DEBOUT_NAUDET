package fr.esiea.unique.debout.naudet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IntelligenceArtificielle {
	
	Player joueurIA = new Player(false);
	
	public IntelligenceArtificielle(Player joueurIA) {
		this.joueurIA = joueurIA;
	}
	
	public void intelligenceArtificielle(String fichier) {
		Lettre nouvelleLettre = new Lettre('n',1);
		Lettre lettre = new Lettre('n',1);
		lettre.tableau();
		String line = null;
		int flag=0;
		String mot;
		
			
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			while((line=br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreElements()) {
						mot = st.nextToken();
						mot = mot.toLowerCase();
						int resultPotCommun = Game.checkTheWordPotCommun(mot);		
						if(resultPotCommun == 1) {
							System.out.println("");
							System.out.println("L'IA a trouvé le mot: " + mot);
							joueurIA.nbMot++;
							Mots.remplirLeTableauDeMot(mot);
							Mots.afficherLeTableauDeMot();
							Game.updatePotCommun(mot);
							nouvelleLettre.letter=lettre.getLetter();
							System.out.println("");
							System.out.println("Repiocher une carte");
							Game.remplirLePotCommun(nouvelleLettre);
							System.out.println("Vous avez pioché: " + nouvelleLettre.letter);
							Game.afficherLePotCommun();
							IntelligenceArtificielle ia = new IntelligenceArtificielle(joueurIA);
							ia.intelligenceArtificielle(fichier);
							flag = 1;
						}
						if(flag==1) {
							break;
						}
				}
				if(flag==1) {
					break;
				}
			}
			if(flag==0) {
				System.out.println("");
				System.out.println("IA passe son tour");
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
}


