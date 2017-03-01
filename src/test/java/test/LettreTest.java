package test;
import static org.junit.Assert.*;
import org.junit.Test;

import fr.esiea.unique.debout.naudet.Lettre;

public class LettreTest {
	
	public Lettre letterTab[] = new Lettre[26];
	
	@Test
	public final void testCompareLetter() {
		Lettre letter = new Lettre('n', 1);
		char a = 'A';
		char b = 'B';
		letter.tableau();
		int result;
		int resultAttendu=1;
		result = letter.compareLetter(a, b);
		if(result == resultAttendu) {
			 System.out.println("C'est bon");// TODO
		}
		else {
			fail("Raté");
		}
	}
	
	//@Test
	
	
}
