public class SwissTime {

    public static void main(String[] args) {
        // Die Beispiele vom Übungsblatt:
        System.out.println("00:00 -> " + toSwissGerman("00:00"));
        System.out.println("01:45 -> " + toSwissGerman("01:45"));
        System.out.println("09:25 -> " + toSwissGerman("09:25"));
        System.out.println("12:01 -> " + toSwissGerman("12:01"));
        System.out.println("16:46 -> " + toSwissGerman("16:46"));
        System.out.println("21:51 -> " + toSwissGerman("21:51"));
        System.out.println("22:37 -> " + toSwissGerman("22:37"));
    }

    public static String toSwissGerman(String time) {
        
    	// teil vom resultat
    	String prefix;
    	String swissHour;
    	String postfix;
    	
    	// züg speichere
    	int hour = Integer.valueOf(time.substring(0, 2));
    	int minutes = Integer.valueOf(time.substring(3, 5));
    	
    	// korrektur
    	if (minutes >= 25) {
    		++hour;
    	}
    	
    	// postfix
    	if (hour >= 5 && hour <= 11) {
    		postfix = " am morge";
    	} else if (hour == 12) {
    		postfix = " am mettag";
    	} else if (hour >= 13 && hour <= 17) {
    		postfix = " am nomittag";
    	} else if (hour >= 18 && hour <= 22) {
    		postfix = " am obe";
    	} else {
    		postfix = " znacht";
    	}
    	
    	// spezialfäll
    	if (minutes == 0) {
    		prefix = "";
    	} else if (minutes == 15) {
    		prefix = "viertel ab ";
    	} else if (minutes == 30) {
    		prefix = "halbi ";
    	} else if (minutes == 45) {
    		prefix = "viertel vor ";
    	// normal
    	} else {
    		if (minutes < 25) {
    			prefix = minutes + " ab ";
    		} else if (minutes < 30) {
    			prefix = (30 - minutes) + " vor halbi ";
    		} else if (minutes < 40) {
    			prefix = (minutes - 30) + " ab halbi ";
    		} else {
    			prefix = (60 - minutes) + " vor ";
    		}
    		
    		
    	}
    	
    	// stond aapasse
    	hour %= 12;
    	if (hour == 0) {
    		hour = 12;
    	}
    	
    	// i oder ohni
    	if (hour >= 4) {
    		swissHour = hour + "i";
    	} else {
    		swissHour = hour + "";
    	}
    	
    	// zäme meche
        return prefix + swissHour + postfix;
    }
}
