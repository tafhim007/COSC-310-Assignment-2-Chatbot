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
	    String [] greetArray = new String []{"hi", "hi there", "hello"};
	    //convert array to a list
	    	
	    if(answer.equals("hi")) {
	    	System.out.println("Is this ongoing?");	 
	    	answer = s.nextLine();  
	    }
	    else if(answer.equals("happy")){
	    	System.out.println("That's great!");
	    }
	    else {
	    	//base case
	    	System.out.println("I am not sure what you said?");
	    }
	    
	}

}
