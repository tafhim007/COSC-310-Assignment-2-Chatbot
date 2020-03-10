import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Class1 {

	public static void main(String[] args) {
		// Create a Scanner object
		Scanner s = new Scanner(System.in);  
	    System.out.println("Hello");
	    // Read user input
	    String answer = s.nextLine();  
	    answer.toLowerCase();
	    
	    //possible greetings from user
	    String [] greetArray = new String []{"hi", "hi there", "hello", "good morning", "good evening",
	    									"good afternoon", "good day"};
	    //convert array to a list
	    List<String> greetList = Arrays.asList(greetArray);	
	    
	    //respond to the user
	    if(greetList.contains(answer)) {
	    	System.out.println("How are you feeling today?");	 
	    	answer = s.nextLine();  
	    }
	    else {
	    	System.out.println("Hi");
	    }
	    }
	    
	}

