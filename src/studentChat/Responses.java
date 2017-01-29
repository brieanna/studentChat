package studentChat;

public class Responses {
	// make an ordered collection of responses
	
	public String getResponse(int respond){
		
		switch(respond){
		// 0-4 are hellos
		case 0: 
			return "Hola";
		case 1:
			return "Hi";
		case 2:
			return "Hello";
		case 3:
			return "S'up";
		case 4:
			return "Top of the mornin'";
		// 5-25 are random convo responses
		case 5:
			return "How is your day?";
		case 6:
			return "I am super awesome!";
		case 7:
			return "That is why I never eat chips in bed.";
		case 8:
			return "When pigs fly.";
		case 9:
			return "I've got swine-flu";
		case 10:
			return "SHUT-UP!";
		case 11:
			return "I couldn't hear you over your ego";
		case 12:
			return "Babe! C'mon babe. AWW! BABE!";
		case 13:
			return "Come back to me Ally, come back to me Ally's sister.";
		case 14:
			return "Do you want to build a snowman?";
		case 15:
			return "Yes";
		case 16:
			return "No way!";
		case 17:
			return "How could you say such a thing?";
		case 18:
			return "How rude!";
		case 19:
			return "I just farted.";
		case 20:
			return "I think I am in love with you.";
		case 21:
			return "Will you marry me?";
		case 22:
			return "You bet";
		case 23:
			return "I'd rather not.";
		case 24:
			return "You know what I mean?";
		case 25:
			return "Oh man, oh man, oh man.";
		// 26-30 are byes
		case 26:
			return "Bye!";
		case 27:
			return "Adios";
		case 28:
			return "Hell-Bye";
		case 29:
			return "Tootles";
		case 30:
			return "I'm out";
		default:
			break;
		}
		return "";
	}
	
	
	// hell bye
	

}
