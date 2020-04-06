import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GreetUser {
	static Scanner s = new Scanner(System.in);  
	static String [] greetArray = new String []{"hi", "hi there", "hello", "good morning", "good evening",
			"good afternoon", "good day", "hey", "hey there"};
	static List<String> greetList = Arrays.asList(greetArray);	
	static String userName;
	
	public static String defaultResponse() {
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
	    return defaultMessage[randomNum];
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
		String mentalHealth = "mh";
		String communication = "c";
		System.out.println(name+ ", what do you need help with today? Type mh for mental health or c for communication");
		topicString = s.next();
		//evaluate the input
		while(!(topicString.equalsIgnoreCase(mentalHealth)||topicString.equalsIgnoreCase(communication))) {			
			//Add a feature that enables your agent to give at least 5 different reasonable responses when the user enters something outside the two topics.
			String [] differentResponses = {"Choose between mental health (type mh) or communication (type c)",
											"I am currently only trained for help with mental health (type mh) or communication (type c)",
											"I wish I could answer other topics but currently I can help you with mental health (type mh) or communication (type c)",
											"More topics coming soon but for now you can only choose between mental health (type mh) or communication (type c)",
											"I have been only trained for mental health (type mh) or communication (type c)"};
			int random = (int) (Math.random()*5);
			System.out.println(differentResponses[random]);
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
