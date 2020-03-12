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
	static int numCigarettes;
	static String doesSmoke;
	static String userEmotion;
	static int numExcercise;
	static int sleepHours;
	static String foodHabit;
	static int mealsPerDay;
	static String nutritionistYesNo;
	static String vegetables;
	static String counsellerYesNo;
	static String counseller;
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
		
		//Siddesh's part
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
			System.out.println("Do you drink " + userName + "?");
			userInput = s.next();
			if(userInput.contains("yes")) {
				System.out.println("Okay. I would suggest you against it.");
				System.out.println("Drinking only aggreviates your depression. But that's no problem.");								
				getExcercise();
			}								
			else {
				System.out.println("That's great to hear! :)");
				System.out.println("Alcohol is the leading cause of depression.");
				getExcercise();
				
			}

		}	
		
			//Tafhim's part
		public static void getExcercise() {						
			System.out.println("Moving on. Now how many times a week do you get excercise? Please enter a number for me  " + userName + ".");			
			numExcercise = s.nextInt();
			
			if(numExcercise< 3) {
				System.out.println("Well I would suggest you to try excercising at least 3 times a week. " + exBenefits());
				sleepHours();
			}
			else {
				System.out.println("Good job " + userName + "! " + exBenefits());
				sleepHours();
			}
		}
		
		private static String exBenefits() {
			return "It is great for your health body and mind therefore may result you to be generally happier.";
		}
		
		public static void sleepHours() {						
			System.out.println("How many hours a week do you sleep? Please enter a number for me " + userName + ".");			
			sleepHours = s.nextInt();
			
			if(sleepHours > 6) {
				System.out.println("Great! You are getting good amount of sleep then.");
				sleepBenefits();
				food();
				
			}
			else{
				System.out.println("Son you need to sleep more. Atleast 6 hours of sleep is benificial to you in various ways.");
				sleepBenefits();
				food();
			}
		}
		
		private static void sleepBenefits() {
			System.out.println("Good amount of sleep keeps your heart healthy. It reduces stress, reduces inflamation, makes you more alert, improves your memory and has many more benefits.");
		}
		
		public static void food() {						
			System.out.println("Moving on, food and nutrition is also another reason that can effect your health physically and mentally. In one word describe your food habit.");			
			foodHabit = s.next();
			System.out.println("How many meals do you have per day " + userName + "?");
			mealsPerDay = s.nextInt();
			if(mealsPerDay >=3) {
				System.out.println("That's great! I would recomend you have atleast 3 meals per day to lead a healthy life.");
				//foodBenefits();
				System.out.println("Do you think you eat your greens " + userName + "?");
				vegetables = s.next();
				vegetables.toLowerCase();
				if (vegetables.contains("yes")) {
					System.out.println("That's really good. I guess you have your nutrionions all covered you don't need my help with that.");
					counselling();
				}
				else {
					System.out.println("Oh no that's not good. It's important to have vegetables and fruits as it effects your health if you don't");
					System.out.println("Would you like for me to recommend you to some nutritionists to help with you maintain a balanced nutritional diet?");
					nutritionistYesNo = s.next(); 
					nutritionistInfo();
					counselling();
				}
			}
			else{
				System.out.println("This is not good " + userName + ". You should be having atleast 3 meals per day in order to be healthier. I recomend you see a nutritionist who can help you keep your meals in track.");
				System.out.println("Do you want me to link you names of some good nutritionists?");
				nutritionistYesNo = s.next();
				nutritionistInfo();
				counselling();
			}
		}
		
		public static void counselling() {
			System.out.println("Thank you for all of that. I hope I was able to give you valuable advice. Now that I know all that about you, I need to ask you, in one word describe what do you think about counselling?");
			String counselling = s.next();
			System.out.println("Have you seeked counselling before?");
			String seekedCounselling = s.next();
			seekedCounselling.toLowerCase();
			if(seekedCounselling.contains("yes")) {
				System.out.println("That's good. Well how do you think they're doing? Is that counseller a good fit for you?");
				String goodCounseller = s.next();
				goodCounseller.toLowerCase();
				if(goodCounseller.contains("yes")) {
					System.out.println("Alright " + userName + " that's perfect then. I guess you won't be needing my help with that then.");
					recommendation();
				}
				else {
					System.out.println("Alright " + userName + ", would you like me to suggest you some new counsellers?");
					counsellerYesNo = s.next();
					counsellerYesNo.toLowerCase();
					if(counsellerYesNo.contains("yes")) {
						counsellerList();
						recommendation();
					}
					else {
						System.out.println("Oh alright then " + userName + ". I hope I was helpful.");
						recommendation();
					}
				}
			}
			else {
				System.out.println("Alright " + userName + ", would you like me to suggest you some new counsellers?");
				counsellerYesNo = s.next();
				counsellerYesNo.toLowerCase();
				if(counsellerYesNo.contains("yes")) {
					counsellerList();
					recommendation();
				}
				else {
					System.out.println("Oh alright then " + userName + ". I hope I was helpful.");
					recommendation();
				}
			}
		}
		
		private static void counsellerList() {
			System.out.println("What kind of counselling would you like between \"individual\" and \"couples\"  counselling " + userName + "?");
			counseller = s.next();
			counseller.toLowerCase();
			if(counseller.contains("individual")) {
				System.out.println("I recommend you see Gavin Belson. He is really good with people with fine analogy. His phone number is 438-000-9898");
			}
			else if(counseller.contains("couples")) {
				System.out.println("I recommend you see Donald 'Jared' Dunn. He is really good with couples counselling. They say this guy is amazing. His phone number is 438-333-9898");
			}
			else {
				System.out.println("I'm sorry I did not understand, let me try that again");
				counsellerList();
			}
		}
		
		private static void nutritionistInfo() {
			System.out.println("Here are some Phone names and Phone numbers you can consider talking to:");
			System.out.println("Bertram Gilfoyle - 778-123-4567");
			System.out.println("Dinesh Chugtai - 778-765-4321");
		}
		
		public static void recommendation() {
			System.out.println("I have a few questions for you " + userName + ".");
			System.out.println("Do you think I have been helpful?");
			userRecommendation = s.next();
			System.out.println("Sure noted. I will be sure to further improve on that, thank you for your feedback.");
			System.out.println("I am still in training though, so is there any recommendation you have for me?");
			userRecommendationTwo = s.next();
			System.out.println("Noted. Would you recommend this chatbot to a friend?");
			userRecommendationThree = s.next();
			System.out.println("Alright " + userName + ". Lastly, checking back on you I wanna know how do you feel right now? (Happy/Sad)");
			userRecommendationFour = s.next();
			System.out.println("Thanks for your review! I really appreciate your feedback.");
			}
}
