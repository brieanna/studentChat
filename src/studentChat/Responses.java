package studentChat;

import java.util.Random;

public class Responses {
	private String hello;
	private String chatOne;
	private String chatTwo;
	private String chatThree;
	private String bye;
	
	public Responses(String hello, String chatOne, String chatTwo, String chatThree, String bye)
	{
		super();
		this.hello = hello;
		this.chatOne = chatOne;
		this.chatTwo = chatTwo;
		this.chatThree = chatThree;
		this.bye = bye;
	}

	public String getHello()
	{
		Random random = new Random();
		int  num = random.nextInt(10) + 1;
		switch(num)
		{
			case 1: return "Hi"; //case 1 - 5 is all "Hello's"
			case 2: return "Good Morning";
			case 3: return "Hello";
			case 4: return "Hola";
			case 5:	return "Hey";
			case 6: return "Whats up??";	//cases 6 - 15 are filler 
			case 7:	return "Sup?";
			case 8:	return "Howdy";
			case 9:	return "Yo!";
			case 10: return "Greetings";
		}
		return hello;
	}

	public String getChatOne() {
		return chatOne;
	}

	public void setChatOne(String chatOne) {
		this.chatOne = chatOne;
	}

	public String getChatTwo() {
		return chatTwo;
	}

	public void setChatTwo(String chatTwo) {
		this.chatTwo = chatTwo;
	}

	public String getChatThree() {
		return chatThree;
	}

	public void setChatThree(String chatThree) {
		this.chatThree = chatThree;
	}

	public String getBye() {
		return bye;
	}

	public void setBye(String bye) {
		this.bye = bye;
	}

	public void setHello(String hello) {
		this.hello = hello;
	}

	// make an ordered collection of responses
	
//	public String getResponse(int respond){
//		
//		switch(respond){
//		// 0-4 are hellos
//		case 0: 
//			return "Hola";
//		case 1:
//			return "Hi";
//		case 2:
//			return "Hello";
//		case 3:
//			return "S'up";
//		case 4:
//			return "Top of the mornin'";
//		// 5-25 are random convo responses
//		case 5:
//			return "How is your day?";
//		case 6:
//			return "I am super awesome!";
//		case 7:
//			return "That is why I never eat chips in bed.";
//		case 8:
//			return "When pigs fly.";
//		case 9:
//			return "I've got swine-flu";
//		case 10:
//			return "SHUT-UP!";
//		case 11:
//			return "I couldn't hear you over your ego";
//		case 12:
//			return "Babe! C'mon babe. AWW! BABE!";
//		case 13:
//			return "Come back to me Ally, come back to me Ally's sister.";
//		case 14:
//			return "Do you want to build a snowman?";
//		case 15:
//			return "Yes";
//		case 16:
//			return "No way!";
//		case 17:
//			return "How could you say such a thing?";
//		case 18:
//			return "How rude!";
//		case 19:
//			return "I just farted.";
//		case 20:
//			return "I think I am in love with you.";
//		case 21:
//			return "Will you marry me?";
//		case 22:
//			return "You bet";
//		case 23:
//			return "I'd rather not.";
//		case 24:
//			return "You know what I mean?";
//		case 25:
//			return "Oh man, oh man, oh man.";
//		// 26-30 are byes
//		case 26:
//			return "Bye!";
//		case 27:
//			return "Adios";
//		case 28:
//			return "Hell-Bye";
//		case 29:
//			return "Tootles";
//		case 30:
//			return "I'm out";
//		default:
//			break;
//		}
//		return "";
//	}
	
	
	// hell bye
	

}
