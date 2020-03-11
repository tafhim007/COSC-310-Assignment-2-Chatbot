import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Class1 {
	//global variables
	static Scanner s = new Scanner(System.in);  
	static String userInput;
	static int userAge;
	static String doesSmoke;
	
	public static void main(String[] args) {
			// Create a Scanner object
		    System.out.println("Hello");
		    // Read user input
		    userInput = s.nextLine();  
		    userInput.toLowerCase();
		    
		    //1) if valid => greet user 2) else repeat until valid input				   		    		 
		    String userName = greetResponse(userInput); //function checks if input is valid or not
		    startConversation(userName);		   		    
		}		
	
		public static void defaultResponse() {
			//default messages
		    String [] defaultMessage = new String [] {"Uh, what?", "Try be more accurate", "I'm sorry", 
		    											"Would you mind repeating?", "I don't get you",
		    											"I'm programmed to answer few questions. Please be more accurate",
		    											"Say something...", 
		    											"I'm giving up on you",
		    											"My knowledge is very limited.",
		    											"Let's try that again"
		    											};
		    int randomNum = (int) (Math.random()*10);
		    System.out.println(defaultMessage[randomNum]);
	    
		}
		
		public static String greetResponse(String input) {			
		    //possible greetings from user
		    String [] greetArray = new String []{"hi", "hi there", "hello", "good morning", "good evening",
		    									"good afternoon", "good day", "hey", "hey there"};

		    List<String> greetList = Arrays.asList(greetArray);		   
		    
		    while(!greetList.contains(input)) {
		    	defaultResponse();
		    	input = s.nextLine(); 
		    }
			    System.out.println("What's your name?");
		    	return userInput = s.nextLine();  
		}
		
		public static void startConversation(String name) {
			//main conversation starts here => happy guy
			System.out.println("Do you feel happy today, " + name + " (Y/N)?");
			userInput = s.nextLine();
			userInput.toLowerCase();
			if(userInput.contains("yes")) {
				ageQuestion();
			}								
			else {
				//call the sad function
				sadConvo();
			}
				
		}		
		
		public static void ageQuestion() {
			System.out.println("Glad you are here. What's your age?");
			userAge = s.nextInt();	
			
			if(isBetween(userAge, 0,18)) {
				System.out.println("Hey there! I'm assuming you don't smoke.");				
			}
			else if(isBetween(userAge, 18,26)){
				System.out.println("Oh cool!");
				smoke();
			}
			else if(isBetween(userAge, 27,40)){
				System.out.println("Good to know.");
				smoke();
			}
			else {
				System.out.println("Great!");
				smoke();
			}
		}
		
		public static boolean isBetween(int userAge2, int lowerBound, int upperBound) {
			return lowerBound <=userAge2 && userAge2 <= upperBound;
		}
		
		public static void smoke() {
			System.out.println("Smoke?");
			userInput = s.next();
			if(userInput.contains("yes")) {
				System.out.println("Just say no.");
			}								
			else {
				System.out.println("Good job!");
			}

		}
		
		
		
		public static void sadConvo() {
			//sid's part
			
		}
		
}