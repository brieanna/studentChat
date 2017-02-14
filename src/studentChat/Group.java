package studentChat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Group {

	private Student s1;
	private Student s2;

	public Group(Student s1, Student s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	Responses responses = new Responses("", "", "", "", "");
	Student student = new Student("", "", 0, responses);
	ArrayList<Student> groupedStudents = new ArrayList<>();
	Set<Group> groupSet = new HashSet<Group>();
	Set<Student> studentSet = new HashSet<Student>();

	public String groupChat(Group group) {
		Student s1 = group.getS1();
		Student s2 = group.getS2();
		String chat = "";
		for (int x = 0; x < 5; x++) {
			chat = chat + s1.getFirst() + " " + s1.getLast() + " says: " + s1.getResponses()[x] + "\n" + 
		s2.getFirst() + " " + s2.getLast() + " says: " + s2.getResponses()[x] + "\n";
		}
		return chat;
	}

	public Student getStudent() {
		studentSet = student.createStudentSet(student.getStudentArray());
		Student s = student.getRandomStudent(studentSet);
		if (!groupedStudents.contains(s)) {
			groupedStudents.add(s);
			return s;
		} else {
			getStudent();
			return s;
		}
	}

	public Set<Group> createGroupSet() {
		studentSet = student.createStudentSet(student.getStudentArray());
		if (studentSet.size() % 2 == 0) {
			for (int x = 0; x < studentSet.size(); x += 2) {
				Group group = new Group(getStudent(), getStudent());
				groupSet.add(group);
			}
		} else {
			for (int x = 0; x < studentSet.size() - 1; x += 2) {
				Group group = new Group(getStudent(), getStudent());
				groupSet.add(group);
			}
			Student s = getStudent();
			Group group = new Group(s, s);
			groupSet.add(group);
		}
		return groupSet;
	}

	public Group getRandomGroup() {
		Set<Group> groupSet = createGroupSet();
		Random rand = new Random();
		int randNum = rand.nextInt(groupSet.size() - 1);
		Group group;
		Object[] groupArray = groupSet.toArray();
		group = (Group) groupArray[randNum];
		return group;
	}

	public Student getS1() {
		return s1;
	}

	public void setS1(Student s1) {
		this.s1 = s1;
	}

	public Student getS2() {

		return s2;
	}

	public void setS2(Student s2) {
		this.s2 = s2;
	}

	public static void sortGroups(Set<Group> groupSet) {
		Group [] groupArray = (Group[]) groupSet.toArray();
		ArrayList <Group> groupList = new ArrayList<>();
		for(Group g : groupArray){
			groupList.add(g);
		}
		for (int i = 0; i < groupList.size(); i++) {
			for (int j = 0; j < groupList.size(); j++) {
				Collections.sort(groupList, new Comparator<Group>() {
					public int compare(Group g1, Group g2) {
						Group group1 = (Group) g1;
						Group group2 = (Group) g2;
						int res = group1.getS1().getLast()
								.compareToIgnoreCase(group2.getS1().getLast());
						if (res != 0) {
							return res;
						}
						return group1.getS1().getFirst()
								.compareToIgnoreCase(group2.getS1().getFirst());
					}
				});
			}

		}
	}

	@Override
	public String toString() {
		return "Group [s1=" + s1 + ", s2=" + s2 + ", responses=" + responses + ", student=" + student
				+ ", groupedStudents=" + groupedStudents + ", groupSet=" + groupSet + ", studentSet=" + studentSet
				+ "]\n";
	}

}
