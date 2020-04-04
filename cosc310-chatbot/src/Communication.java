import java.util.Scanner;

public class Communication {
	static String optionInput;
	static Scanner sc = new Scanner(System.in);
	String a1;
	String a2;
	String a3;
	String a4;
	String a5;
	String a6;
	String a7;
	String a8;
	String a9;
	
	public void definition() {
		System.out.println("Welcome! You are at the right place if you are looking for help with their relationships (individual, couples or family therapy).");
		System.out.println("If you would like to switch to the mental health option press 'y' else 'n'. ");
		optionInput = sc.next();
		
		if(optionInput.contains("y")) {
			System.out.println("You are now being transferred to mental health bot.");
			mentalHealth mh = new mentalHealth();
			mh.definition();
		}
		else {
			System.out.println("Glad you are at the correct place.");
			goalOriented();
		}
	}
	
	public void goalOriented() {		
		System.out.println("What are your best hopes for our talk today?");
		a1 = sc.next();
		System.out.println("Great. What would you like to be different when you walk out of here today?");
		a2 = sc.next();
		System.out.println("What is your main concern today?");		
		a3 = sc.next();
		relationshipOriented();
	}
	
	public void relationshipOriented() {
		System.out.println("Whose idea was it for you to be here today?");
		a4 = sc.next();
		System.out.println("Who is with you in this room today?");
		a5 = sc.next();
		evaluationOriented();
	}
	
	public void evaluationOriented() {
		System.out.println("So, what's been going well?");
		a7 = sc.next();
		System.out.println("Is this your first time here? (yes/no)");
		a8 = sc.next();
		if(a8.equalsIgnoreCase("yes")) {
			System.out.println("Your answers hve been recorded and will be presented to our therapist who will give you a good analysis.");
			System.out.println("Until then have a good day!");
		}
		else {
			System.out.println("What is different today from the last time you were here?");
			a8 = sc.next();
			System.out.println("What, from last session, impacted you this week?");
			a9 = sc.next();
			System.out.println("Your answers hve been recorded and will be presented to our therapist who will give you a good analysis.");
			System.out.println("Until then have a good day!");
		}
	
	}
	
}
