package Utilities;

import java.util.Date;

public class Utils {
	
	public static final int IMPLICIT_WAIT = 10;
	public static final int PAGE_LOAD_TIMEOUT = 10;
	public static final int SCRIPT_TIMEOUT = 1000;
	
	public static void main(String[] args) {
		emailWithDateStamp();
	}
	
	public static String emailWithDateStamp() {

		Date date = new Date();
		
		System.out.println(date); 
		String emailTimeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "galka1" + emailTimeStamp + "@gmail.com";
	}

}
