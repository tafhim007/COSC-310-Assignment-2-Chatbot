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
		static int numCigarettes;
		static String userEmotion;
		static int numExcercise;
		static String excerciseFeels;
		static int sleepHours;
		static String continueChat;
		static String userRecommendation; //final
		static String userRecommendationTwo;
		static String userRecommendationThree;
		static String userRecommendationFour;
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
			    System.out.println("Let me get to know you better. What's your name?");
		    	userName = s.nextLine();  
		    	startConversation(userName);
		    	
		    	
		}
		
		public static void startConversation(String name) {
			//main conversation starts here => happy guy
			System.out.println("It's so nice to meet you " + name + "! I'm Richard Hendricks.");
			ageQuestion();
		}
		
		public static void ageQuestion() {
			System.out.println("What's your age?");
			userAge = s.nextInt();	
			
			if(isBetween(userAge, 0,18)) {
				System.out.println("Hey there! I'm assuming you don't smoke.");				
			}
			else if(isBetween(userAge, 18,26)){
				System.out.println("Oh cool!");
				checkEmotion();
			}
			else if(isBetween(userAge, 27,40)){
				System.out.println("Good to know.");
				checkEmotion();
			}
			else {
				System.out.println("Great!");
				checkEmotion();
			}
		}
		
		public static void checkEmotion() {
			System.out.println(
					"I'm only 20 days old. Now that we know each other a bit better, how are you doing today? Are you feeling happy or sad? ");
			happyOrSad = s.next();
			happyOrSad.toLowerCase();
			if(happyOrSad.contains("happy")) {
				System.out.println("That's great! I'm so glad you're having a great day.");
				smoke();				
			}
			else if(happyOrSad.contains("sad")){
				System.out.println("Oh no I'm so sorry. :/ Let me see if I can help you in any way by asking you a few questions.");
				System.out.println("Please bear with me.");
				smoke();
			}
			else {
				defaultResponse();
				startConversation(userName);
			}			
			
		}
		
		public static boolean isBetween(int userAge2, int lowerBound, int upperBound) {
			return lowerBound <=userAge2 && userAge2 <= upperBound;
		}
		
		public static void smoke() {
			System.out.println("Let me get to know about your habits a little better. Do you smoke?");
			userInput = s.next();
			if(userInput.contains("yes")) {
				System.out.println("How many cigarettes do you smoke in a day?");
				numCigarettes = s.nextInt();
				if(numCigarettes > 5) {
					System.out.println("Uhm alright. I would recommend you to try and stop smoking as it is very bad for health.");
					smokingHazards();
					drink();
				}								
				else {
					System.out.println("Try nicotine patches if you want to give up smoking.");		
					smokingHazards();
					drink();
				}
				
			}
			else {
				System.out.println("That's great to hear! I'm really happy because smoking has some very bad effects on your health.");
				System.out.println("I'm glad you are avoiding it.");
				drink();
			}
		}
		
		private static void smokingHazards(){
			System.out.println("Smoking is not healthy at all. It's a major cause of lung cancer. Furthermore it increases your blood pressure making your health much worse than a non smoker.");
		}

			public static void drink() {
			System.out.println("Do you drink?");
			userInput = s.next();
			if(userInput.contains("yes")) {
				System.out.println("Okay.");
				System.out.println("Drinking only aggreviates your depression.");								
				getExcercise();
			}								
			else {
				System.out.println("That's great to hear.");
				System.out.println("Alcohol is the leading cause of depression.");
				getExcercise();
				
			}

		}	
		
		public static void getExcercise() {		
			System.out.println("How do you feel about excercising?");
			excerciseFeels = s.next();
			System.out.println("Now how many times a week do you get excercise? Enter a number");			
			numExcercise = s.nextInt();
			
			if(numExcercise< 3) {
				System.out.println("Well I would suggest you to try excercising at least 3 times a week. " + exBenefits());
				sleepHours();
			}
			else {
				System.out.println("Good job! " + exBenefits());
				sleepHours();
			}
		}
		
		private static String exBenefits() {
			return "It is great for your health body and mind therefore may result you to be generally happier.";
		}
		
		public static void sleepHours() {						
			System.out.println("How many hours a week do you sleep? Enter a number");			
			sleepHours = s.nextInt();
			
			if(sleepHours > 6) {
				System.out.println("Great! You are getting good amount of sleep then.");
				sleepBenefits();				
			}
			else{
				System.out.println("You need to sleep more. Atleast 6 hours of sleep is benificial to you in various ways.");
				sleepBenefits();
			}
		}
		
		private static void sleepBenefits() {
			System.out.println("Good amount of sleep keeps your heart healthy. It reduces stress, reduces inflamation, makes you more alert, improves your memory and has many more benefits.");
		}
		
		
		//add this later
		public static void recommendation() {
			System.out.println("I have a few questions for you.");
			System.out.println("Do you think I have been helpful?");
			userRecommendation = s.next();
			System.out.println("Sure");
			System.out.println("I am still in training, is there any recommendation you have for me?");
			userRecommendationTwo = s.next();
			System.out.println("Would you recommend this chatbot to a friend?");
			userRecommendationThree = s.next();
			System.out.println("How do you feel now? (Happy/Sad)");
			userRecommendationFour = s.next();
			System.out.println("Thanks for your review. Appreciate your feedback.");
		}
}	