
public class OhneSieben {

	public static void main(String[] args) {
		int zahl; int[] resultat;
		
		// Sie koennen den Inhalt dieser Methode ergaenzen
		
		// Test 1
		zahl = 173;
		resultat = ohneSieben(zahl);
		if (richtigesResultat(resultat, zahl)) {
			System.out.println("Richtiges Ergebnis");
		} else {
			System.out.println("Falsches Ergebnis");
		}
		
		// Test 2
		zahl = 986;
		resultat = ohneSieben(zahl);
		if (richtigesResultat(resultat, zahl)) {
			System.out.println("Richtiges Ergebnis");
		} else {
			System.out.println("Falsches Ergebnis");
		}
		
		// Test 3
		zahl = 73974;
		resultat = ohneSieben(zahl);
		if (richtigesResultat(resultat, zahl)) {
			System.out.println("Richtiges Ergebnis");
		} else {
			System.out.println("Falsches Ergebnis");
		}
	}
	
	public static int[] ohneSieben(int zahl) {
		int[] resultat = new int[2];
		
		int s1 = zahl;
		int s2 = 0;
		
		// condition only for good measure
		while (s1 >= s2) {
			// concatenation does not contains 7
			if (!("" + s1 + s2).contains("" + 7)) {
				break;
			}
			// adjust
			--s1;
			++s2;
			
		}
		
		resultat[0] = s1;
		resultat[1] = s2;
		
		return resultat;
	}
	
	/** Ueberprueft ob resultat eine korrekte Zerlegung von zahl enthaelt, wobei es nicht prueft, dass die Summanden keine 7 enthalten. */
	public static boolean richtigesResultat(int[] resultat, int zahl) {
		// Sie koennen den Inhalt dieser Methode ergaenzen
		boolean richtigesResultatFormat = resultat != null && resultat.length == 2 && resultat[0] >= resultat[1];
		return  richtigesResultatFormat && resultat[0] + resultat[1] == zahl && !("" + resultat[0] + resultat[1]).contains("" + 7);
	}

}

