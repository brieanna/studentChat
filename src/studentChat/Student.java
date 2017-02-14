package studentChat;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student {

	private String first;
	private String last;
	private int score;
	private String chat;

	Responses responses = new Responses(chat, chat, chat, chat, chat);

	public Student(String first, String last, int score, Responses responses) {
		super();
		this.first = first;
		this.last = last;
		this.score = score;
		this.responses = responses;
	}

	public Student[] getStudentArray() {
		Student stud1 = new Student("Nathan", "Borup", 1, responses);
		Student stud2 = new Student("Ethan", "Brown", 2, responses);
		Student stud3 = new Student("Michael", "Cullimore", 3, responses);
		Student stud4 = new Student("Kendra", "Koester", 4, responses);
		Student stud5 = new Student("Cody", "May", 5, responses);
		Student stud6 = new Student("Brieanna", "Miller", 6, responses);
		Student stud7 = new Student("Rizwan", "Mohammed", 7, responses);
		Student stud8 = new Student("Lauren", "Ribeiro", 8, responses);
		Student stud9 = new Student("Tyler", "Toponce", 9, responses);
		Student[] studentArray = { stud1, stud2, stud3, stud4, stud5, stud6, stud7, stud8, stud9 };
		return studentArray;
	}

	public Set<Student> createStudentSet(Student[] studentArray) {
		Set<Student> studentSet = new HashSet<Student>();
		for (Student stud : studentArray) {
			studentSet.add(stud);
		}
		return studentSet;
	}

	public Student getRandomStudent(Set<Student> studentSet) {
		Random rand = new Random();
		int randNum = rand.nextInt(studentSet.size() - 1);
		Student stud;
		Object[] studArray = studentSet.toArray();
		stud = (Student) studArray[randNum];
		return stud;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String[] getResponses() {
		String[] responsesArray = { responses.getHello(), responses.getChatOne(), responses.getChatTwo(),
				responses.getChatThree(), responses.getBye() };
		return responsesArray;
	}

	public void setResponses(Responses responses) {
		this.responses = responses;
	}

	@Override
	public String toString() {
		return "first=" + first + ", last= " + last + ", score= " + score + ", chat= " + chat + ", responses= "
				+ responses.getHello() + ", " + responses.getChatOne() + ", " + responses.getChatTwo() + ", "
				+ responses.getChatThree() + ", " + responses.getBye() + "\n";
	}

}
