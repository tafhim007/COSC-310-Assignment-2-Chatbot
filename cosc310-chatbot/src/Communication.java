import java.util.Scanner;

public class Communication {
	static String optionInput;
	static Scanner sc = new Scanner(System.in);  
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
		}
	}
}
