import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Class1 {
	//global vars
	static Scanner s = new Scanner(System.in);  
	static String userInput;
	
	public static void main(String[] args) {
			// Create a Scanner object
		    System.out.println("Hello");
		    // Read user input
		    userInput = s.nextLine();  
		    userInput.toLowerCase();
		    //1) if valid => greet user 2) else repeat				   		    		 
		    greetResponse(userInput); //func checks if input is valid
		    
		    //respond to the user
		   
		    
		}		
	
		public static void defaultResponse() {
			//defaults
		    String [] defaultMessage = new String [] {"Uh, what?", "Try be more accurate", "I'm sorry", 
		    											"Would you mind repeating?", "I don't get you",
		    											"I'm programmed to answer few questions. Please be more accurate",
		    											"Say something...", "I'm giving up on you", "My knowledge is very limited.",
		    											"Let's try that again"};
		    int randomNum = (int) (Math.random()*10);
		    System.out.println(defaultMessage[randomNum]);
	    
		}
		
		public static void greetResponse(String input) {			
		    //possible greetings from user
		    String [] greetArray = new String []{"hi", "hi there", "hello", "good morning", "good evening",
		    									"good afternoon", "good day", "hey", "hey there"};

		    List<String> greetList = Arrays.asList(greetArray);		   
		    
		    while(!greetList.contains(input)) {
		    	defaultResponse();
		    	input = s.nextLine(); 
		    }
			    System.out.println("How are you feeling today?");
		    	userInput = s.nextLine();  
		}
		
		
}