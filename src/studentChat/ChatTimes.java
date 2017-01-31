package studentChat;

import java.util.HashSet;
import java.util.Set;

public class ChatTimes {

	public static void main(String[] args) {
		Group group = new Group();
	
		// instantiate the responses class
		Responses responses = new Responses("","","","","");
		// instantiate the student class
		Student student = new Student("", "", 0, responses);
		
		Set<Student> studentSet = new HashSet<Student>();
		
		group.beginConvo();
		
		studentSet = student.createStudentSet(student.getStudentArray());
		
		System.out.println(studentSet);
		
		System.out.println(student.getRandomStud(studentSet).getResponses()[0]);
		System.out.println(student.getRandomStud(studentSet).getFirst());
		
	}

}
