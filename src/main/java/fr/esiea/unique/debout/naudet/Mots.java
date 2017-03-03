package fr.esiea.unique.debout.naudet;


public class Mots {
//Cette classe va traiter la partie "vole de mot". On stock les mots dans un tableau "motsCommuns"
//On regarde si la chaine de caractère du mot saisit contient un des mots du tableau "motsCommuns"
	
	//19 mots maximum dans une partie
	private static String motsCommuns[] = new String [20];
	public String mot;
	
	public static void remplirLeTableauDeMot(String mot) {
		
		int i;
		int flag =0;
		try {
			for(i=0;i<motsCommuns.length;i++) {
				if(motsCommuns[i] == null && flag == 0) {
					motsCommuns[i] = mot;
					flag = 1;	
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}	
	}
	
	public static int verifierSiMotDansMotsCommuns(String word) {
		
		boolean reponse;
		int flag=0;
		try {
			for(int i=0;i<motsCommuns.length;i++) {	
				if(motsCommuns[i] != null ) {
					reponse=word.contains(motsCommuns[i]);
					if(reponse == true) {
						flag=1;
						break;
					}
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}	
		
		return flag;
	}
	
	public static void afficherLeTableauDeMot() {
		
		System.out.println("");
		System.out.println("Voici les mots trouvés que vous pouvez réutiliser:");
		System.out.println("");
		try {
			for(int i=0; i<motsCommuns.length; i++) {
				if(motsCommuns[i] == null) {
					System.out.print(", ");
				}
				else {
					System.out.print(motsCommuns[i] +", ");
				}
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}	
	}
	
}
