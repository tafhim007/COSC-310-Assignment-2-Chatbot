import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Class1 {
	//global variables
	static Scanner s = new Scanner(System.in);  
	static String userInput;
	static String userName;
	static String happyOrSad;
	static int userAge;
	static String doesSmoke;
	static String userEmotion;
	static String [] greetArray = new String []{"hi", "hi there", "hello", "good morning", "good evening",
				"good afternoon", "good day", "hey", "hey there"};
	static List<String> greetList = Arrays.asList(greetArray);		 
	
	public static void main(String[] args) {
			// Create a Scanner object
		    System.out.println("Hello");
		    // Read user input
		    userInput = s.nextLine();  
		    userInput.toLowerCase();
		    greetResponse(userInput);
		    
		    //1) if valid => greet user 2) else repeat until valid input				   		    		 
//		    String userName = greetResponse(userInput); //function checks if input is valid or not
//		    startConversation(userName);		   		    
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
		
		public static void greetResponse(String input) {			
		    //possible greetings from user
	    
		    while(!greetList.contains(input)) {
		    	defaultResponse();
		    	input = s.nextLine(); 
		    }
			    System.out.println("What's your name?");
		    	userName = s.nextLine();  
		    	startConversation(userName);
		}
		
		public static void startConversation(String name) {
			//main conversation starts here => happy guy
			System.out.println("How do you feel today, " + name + " (Happy/Sad)?");			
			happyOrSad = s.nextLine();
			happyOrSad.toLowerCase();
			checkEmotion(happyOrSad);
			
		}		
		
		public static void checkEmotion(String userInput2) {
			if(happyOrSad.contains("happy")) {
				System.out.println("Glad you are happy");
				ageQuestion();
			}
			else if(userInput.contains("sad")){
				System.out.println("Oh no");
				ageQuestion();
			}
			else {
				defaultResponse();
				startConversation(userName);
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
			System.out.println("Do you smoke?");
			userInput = s.next();
			if(userInput.contains("yes")) {
				System.out.println("Okay.");
				System.out.println("Smoking only aggreviates your depression. But that's no problem.");								
				talkAboutProblem();
			}								
			else {
				System.out.println("That's great to hear.");
				System.out.println("Smoking is not healthy.");
				talkAboutProblem();
				
			}

		}
		
		public static void talkAboutProblem() {			
			
			System.out.println("Is there anything bothering you today?");
			
			
			
		}

		public static void sadConvo() {
			//sid's part
			
		}
		
}