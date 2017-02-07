package studentChat;

import java.util.HashSet;
import java.util.Set;

public class Group {

	public Group() {

	}

		Responses responses = new Responses("", "", "", "", "");
		Student student = new Student("", "", 0, responses);

	Set<Student> studentSet = new HashSet<Student>();

	// groups need to be in a collection of groups
	public void groupChat(Student s1, Student s2) {
		studentSet = student.createStudentSet(student.getStudentArray());
		for (int x = 0; x < 5; x++) {
			System.out.println(s1.getFirst() + " " + s1.getLast() + " says: " + s1.getResponses()[x]);
			System.out.println(s2.getFirst() + " " + s2.getLast() + " says: " + s2.getResponses()[x]);
		}
	}

	public void beginConvo() {
		studentSet = student.createStudentSet(student.getStudentArray());
		Student s1 = student.getRandomStudent(studentSet);
		Student s2 = student.getRandomStudent(studentSet);
		if (!sameStudents(s1, s2)) {
			groupChat(sortStudents(s1, s2)[0], sortStudents(s1, s2)[1]);
		} else
			beginConvo();

	}

	public boolean sameStudents(Student s1, Student s2) {
		if (s1.equals(s2)) {
			return true;
		} else {
			return false;
		}
	}

	// use a collection .sort
	public Student[] sortStudents(Student s1, Student s2) {
		Student[] studentList = new Student [2];
		if(s1.getScore() < s2.getScore()){
			studentList[0] = s1;
			studentList[1] = s2;
		}else{
			studentList[0] = s2;
			studentList[1] = s1;
		}
		return studentList;
	}

}
