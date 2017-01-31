package studentChat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Group {

	public Group(){
		
	}
			// instantiate the responses class
			Responses responses = new Responses("","","","","");
			// instantiate the student class
			Student student = new Student("", "", 0, responses);
			
			Set<Student> studentSet = new HashSet<Student>();
		
	public void groupChat(Student s1, Student s2){
		studentSet = student.createStudentSet(student.getStudentArray());
			for(int x = 0; x <= 5; x++){
				System.out.println(s1.getFirst() + " says: " + s1.getResponses()[x]);
				System.out.println(s2.getFirst() + " says: " + s2.getResponses()[x]);
			}
	}
	
	
	public void beginConvo(){
		studentSet = student.createStudentSet(student.getStudentArray());
		Student s1 = student.getRandomStud(studentSet);
		Student s2 = student.getRandomStud(studentSet);
		if(!sameStudents(s1, s2)){
//			TODO: order students
			groupChat(s1, s2); 
		}else
			beginConvo();
		
	}
	
	public boolean sameStudents(Student s1, Student s2){
		if(s1 == s2){
			return true;
		}
		else{
			return false;
		}
	}
		
	
	public static void sortStudents(Student s1, Student s2) 
	 {
		ArrayList <Student> studentList = new ArrayList<>();
		studentList.add(s1);
		studentList.add(s2);
		    for (int i = 0; i < studentList.size(); i++)
		    {
		        for (int j = 0; j < studentList.size(); j++) 
		        {
		            Collections.sort(studentList, new Comparator<Student>(){
						public int compare(Student s1, Student s2) {
							Student student1 = (Student) s1;
		                    Student student2 = (Student) s2;
		                    int res =  student1.getLast().compareToIgnoreCase(student2.getLast());
		                    if (res != 0)
		                    {
		                        return res;
		                    }
		                    return student1.getFirst().compareToIgnoreCase(student2.getFirst());
						}
		            });
		        }

		    }
		}
}
