package studentChat;

import java.util.HashSet;
import java.util.Set;

public class ChatTimes {

	public static void main(String[] args) {
		
		Student student = new Student(null, null, 0, null);
		
		Set<Student> studentSet = new HashSet<Student>();
		
		studentSet = student.createStudentSet(student.getStudentArray());
		// printing students out to make sure they made it into the hash
		System.out.println(studentSet);
		
	}

}
