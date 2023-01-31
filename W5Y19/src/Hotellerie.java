import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Hotellerie {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Sie koennen den Inhalt von main aendern
		
		Scanner scanner = new Scanner(new File("hotelDaten1.txt"));
		PrintStream output = new PrintStream(System.out);
		
		analyse(scanner, output);
	}
	
	public static void analyse(Scanner input, PrintStream output) throws FileNotFoundException {
		// don't need number of bookings
		input.next();
		
		// rooms
		int[] numBookings = new int[256];
		int[] numDays = new int[256];
		double[] profit = new double[256];
		
		while (input.hasNext()) {
			// get info
			int room = input.nextInt() - 1;
			++numBookings[room];
			
			int duration = -input.nextInt() + input.nextInt() + 1;
			numDays[room] += duration;
			
			profit[room] += (duration * input.nextDouble()) * (1 - 0.01 * input.nextInt());
		}
		
		// get max whole profit
		int maxBookings = 0;
		int maxDays = 0;
		int maxProfit = 0;
		double cash = profit[0];
		
		for (int i = 1; i < profit.length; ++i) {
			
			if (numBookings[i] > numBookings[maxBookings]) {
				maxBookings = i;
			}
			
			if (numDays[i] > numDays[maxDays]) {
				maxDays = i;
			}
			
			if (profit[i] > profit[maxProfit]) {
				maxProfit = i;
			}
			
			cash += profit[i];
		}
		
		// +1 since we started at 0
		output.println("Am haeufigsten gebucht: " + (maxBookings + 1));
		output.println("Am meisten besetzt: " + (maxDays + 1));
		output.println("Groessten Betrag eingebracht: " + (maxProfit + 1));
		output.println("Gesamteinnahmen des Hotels: " + cash); 
	}
	
	

}
