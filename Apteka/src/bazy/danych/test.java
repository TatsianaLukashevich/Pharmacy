package bazy.danych;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class test {

	/**
	 * @param args
	 */
	
	final static String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	final static String number = "1234567890";

	final static java.util.Random rand = new java.util.Random();

	// consider using a Map<String,Boolean> to say whether the identifier is being used or not 
	final static Set<String> identifiers = new HashSet<String>();

	public static String randomIdentifier() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = rand.nextInt(5)+5;
	        for(int i = 0; i < length; i++)
	            builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
	        if(identifiers.contains(builder.toString()) )
	            builder = new StringBuilder();
	    }
	    return builder.toString();
	}
	
	public static String random_number() {
	    StringBuilder builder = new StringBuilder();
	    while(builder.toString().length() == 0) {
	        int length = 9;
	        for(int i = 0; i < length; i++)
	            builder.append(number.charAt(rand.nextInt(number.length())));
	        if(identifiers.contains(builder.toString()) )
	            builder = new StringBuilder();
	    }
	    return builder.toString();
	}
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		DataBase db = new DataBase();
		ArrayList<String> list = new ArrayList<String>();
		
		
	
			//String str = Integer.toString(i);
			//String nazwa = new String();
			// nazwa = randomIdentifier();
			//String id_szpital = new String();
			//id_szpital = random_number();
	list.add("2");	
		list.add("8");
		list.add("narutow");
		db.sampleInsertExecution(list);
		//db.sampledropExecution();
		//list.clear();
		/*list.add("2");	
		list.add("3");
		list.add("warynskiego");

		db.sampleInsertExecution(list);
		//list.clear();
		db.sampleSelectExecution();
		/*list.add("21");	
		list.add("1");
		db.sampleUpdateExecution(list);
		list.clear();*/
		/*list.add("5");
		db.sampleDeleteExecution(list);*/
		//list.clear();
		//db.sampleSelectExecution();
		//db.sampleGroupExecution();
		//db.sampleSelectExecution();
		
	}

}
