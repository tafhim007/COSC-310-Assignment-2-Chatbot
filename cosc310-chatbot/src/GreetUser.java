import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GreetUser {
	static Scanner s = new Scanner(System.in);  
	static String [] greetArray = new String []{"hi", "hi there", "hello", "good morning", "good evening",
			"good afternoon", "good day", "hey", "hey there"};
	static List<String> greetList = Arrays.asList(greetArray);	
	static String userName;
	
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
	
	public void startGreetings() {
		String greetInput;		
		System.out.println("Hi there! My name is TheraTalk and I am a therapy chat bot.");
		System.out.println("How is your day going?");
		greetInput = s.next();

	    if(greetInput.isEmpty()) {
	    	System.out.println("Let's try again. How is your day going?");
			greetInput = s.next();
	    }
	    else {
	    	System.out.println("Okay, let me get to know you better. What's your name?");
	    	userName = s.next();
	    	chooseTopic(userName);
	    }
	    }
	
	 public String getName() {
		    return userName;
	}
		   
	
	public void chooseTopic(String name) {
		String topicString;
		String mentalHealth = "mental health";
		String communication = "communication";
		System.out.println(name+ ", what do you need help with today? Choose one topic from the following: mental health or communication");
		topicString = s.next();
		//evaluate the input
		while(!(topicString.equalsIgnoreCase(mentalHealth)||topicString.equalsIgnoreCase(communication))) {			
			System.out.println("Please choose between mental health or communication");
			topicString = s.next();	
		}
			System.out.println("Thanks for choosing. Your request will now be proccessed.");	
			if(topicString.equalsIgnoreCase(mentalHealth)) {
				mentalHealth mh = new mentalHealth();
				mh.definition();
			}
			else {
				Communication c = new Communication();
				c.definition();
			}
			
	}
}
