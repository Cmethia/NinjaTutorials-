package Tutorials.Utilities;

import java.util.Date;

public class Utilities {

	//we create a method in which we declare our date stamp (very used in negative testing)
		public static String generateDateTimeStamp() {
			Date date=new Date();
			String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
			return "Seleniumpanda1" + timeStamp + "@gmail.com";
			

	}

public static final int IMPLICT_WAIT_TIME=10;		
public static final int PAGELOAD_TIME=10;	


}
