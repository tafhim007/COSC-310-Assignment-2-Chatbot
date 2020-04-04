
public class DefaultResponse {
	public  void defaultResponse() {
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
}
