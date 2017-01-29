package studentChat;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Student {
	// create student in the class
	// first name 
	// last name
	// score int?
	// instantiate responses in this class
	private String first;
	private String last;
	private int score;
	private String chat;
	
	Responses responses = new Responses();
	
	
	public Student(String first, String last, int score, String chat) {
		super();
		this.first = first;
		this.last = last;
		this.score = score;
		this.chat = chat;
	}
	
	public Student[] getStudentArray(){
		Student stud1 = new Student("Nathan", "Borup", 1, "chat");
		Student stud2 = new Student("Ethan", "Brown", 2, "chat");
		Student stud3 = new Student("Michael", "Cullimore", 3, "chat");
		Student stud4 = new Student("Kendra", "Koester", 4, "chat");
		Student stud5 = new Student("Cody", "May", 5, "chat");
		Student stud6 = new Student("Brieanna", "Miller", 6, "chat");
		Student stud7 = new Student("Rizwan", "Mohammed", 7, "chat");
		Student stud8 = new Student("Lauren", "Ribeiro", 8, "chat");
		Student stud9 = new Student("Tyler", "Toponce", 9, "chat");
		Student [] studentArray = {stud1, stud2, stud3, stud4, stud5, stud6, stud7, stud8, stud9};
		return studentArray;
	}
	
	public Set<Student> createStudentSet(Student[] studentArray){
		Set<Student> studentSet = new HashSet<Student>();
		for(Student stud : studentArray){
			studentSet.add(stud);
		}
		return studentSet;
	}
	
	public Student getRandomStud(Set<Student> studentSet, int rand){
		Student stud;
		Object[] studArray = studentSet.toArray();
		stud = (Student) studArray[rand];	
		return stud;
	}
	
}
