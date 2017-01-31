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
		case 1: 
			return "Hola";
		case 2:
			return "Hi";
		case 3:
			return "Hello";
		case 4:
			return "S'up";
		case 5:
			return "Top of the mornin'";
		case 6:
			return "Greetings";
		case 7:
			return "Good Evening";
		case 8:
			return "Good Afternoon";
		case 9:
			return "wuz up dawg";
		case 10:
			return "What is up?";
		}
		return hello;
		
	}
	
	public void setHello(String hello) {
		this.hello = hello;
	}

	public String getChatOne() {
		Random random = new Random();
		int  num = random.nextInt(10) + 1;
		switch(num)
		{
		case 1:
			return "Oh man, oh man, oh man.";
		case 2:
			return "I forgot";
		case 3:
			return "I wasted time";
		case 4:
			return "I'm not as think you drunk I am";
		case 5:
			return "Want to meet up?";
		case 6:
			return "You know what I mean?";
		case 7:
			return "Did you see that ludicrus display last night?";
		case 8:
			return "How are you?";
		case 9:
			return "What's going on?";
		case 10:
			return "Why is the rum gone?";
		}
		return chatOne;
	}

	public void setChatOne(String chatOne) {
		this.chatOne = chatOne;
	}

	public String getChatTwo() {
		Random random = new Random();
		int  num = random.nextInt(10) + 1;
		switch(num)
		{
		case 1:
			return "How is your day?";
		case 2:
			return "I am super awesome!";
		case 3:
			return "That is why I never eat chips in bed.";
		case 4:
			return "When pigs fly.";
		case 5:
			return "I've got swine-flu";
		case 6:
			return "SHUT-UP!";
		case 7:
			return "I couldn't hear you over your ego";
		case 8:
			return "Babe! C'mon babe. AWW! BABE!";
		case 9:
			return "Come back to me Ally, come back to me Ally's sister.";
		case 10:
			return "Do you want to build a snowman?";
		}
		return chatTwo;
	}

	public void setChatTwo(String chatTwo) {
		this.chatTwo = chatTwo;
	}

	public String getChatThree() {
		Random random = new Random();
		int  num = random.nextInt(10) + 1;
		switch(num)
		{
		case 1:
			return "Yes";
		case 2:
			return "No way!";
		case 3:
			return "How could you say such a thing?";
		case 4:
			return "How rude!";
		case 5:
			return "I just farted.";
		case 6:
			return "I think I am in love with you.";
		case 7:
			return "Will you marry me?";
		case 8:
			return "You bet";
		case 9:
			return "I'd rather not.";
		case 10:
			return "Purple";
		}
		return chatThree;
	}

	public void setChatThree(String chatThree) {
		this.chatThree = chatThree;
	}

	public String getBye() {
		Random random = new Random();
		int  num = random.nextInt(10) + 1;
		switch(num)
		{
		case 1:
			return "Bye!";
		case 2:
			return "Adios";
		case 3:
			return "Hell-Bye";
		case 4:
			return "Tootles";
		case 5:
			return "I'm out";
		case 6:
			return "ttyl";
		case 7:
			return "Bubbye now";
		case 8:
			return "c u l8r";
		case 9:
			return "Peace out";
		case 10:
			return "Time to leave";
		}
		return bye;
	}

	public void setBye(String bye) {
		this.bye = bye;
	}
	

}
