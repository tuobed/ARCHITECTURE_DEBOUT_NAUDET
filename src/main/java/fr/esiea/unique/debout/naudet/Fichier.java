package fr.esiea.unique.debout.naudet;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fichier {
//Cette classe va permettre de vérifier dans le dictionnaire si un mot existe ou non
	public String fileName;
	
	
	public Fichier(String fileName) {
		this.fileName = fileName;
	}
	
	public int checkIfWordCorrect(String fichier, String mot) {
		String line = null;
		int flag=0;
		mot = mot.toLowerCase();
			
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			
			while((line=br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(line);
				while(st.hasMoreElements()) {
					if(st.nextToken().equals(mot)) {
						flag = 1;
						System.out.println("");
						//System.out.println("Votre mot est correct");
						
					}
					
				}
			}
			if(flag != 1) {
				System.out.println("");
				//System.out.println("Votre mot n'existe pas");
				flag =0;
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		return flag;
	}
	
	
}
