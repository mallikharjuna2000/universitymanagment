package com.codegnan.university.managment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Manages the university's students, professors, and courses
public class UniversityManagement {
	private List<Student> students; // List to hold students
	private List<Professor> professors; // List to hold professors
	private List<Course> courses; // List to hold courses

	// Constructor initializes empty lists for students, professors, and courses
	public UniversityManagement() {
		students = new ArrayList<>();
		professors = new ArrayList<>();
		courses = new ArrayList<>();
	}

	// Method to add a student
	public void addStudent(String name) {
		students.add(new Student(name));
	}

	// Method to add a professor
	public void addProfessor(String name) {
		professors.add(new Professor(name));
	}

	// Method to add a course
	public void addCourse(String title) {
		courses.add(new Course(title));
	}

	// Method to enroll a student in a course
	public void enrollStudentInCourse(String studentName, String courseTitle) {
		Student student = findStudentByName(studentName); // Find the student by name
		Course course = findCourseByTitle(courseTitle); // Find the course by title
		if (student != null && course != null) {
			student.enrollInCourse(course); // Enroll the student in the course
		} else {
			System.out.println("Student or course not found."); // Error message if not found
		}
	}

	// Method to assign a course to a professor
	public void assignCourseToProfessor(String professorName, String courseTitle) {
		Professor professor = findProfessorByName(professorName); // Find the professor by name
		Course course = findCourseByTitle(courseTitle); // Find the course by title
		if (professor != null && course != null) {
			professor.assignCourse(course); // Assign the course to the professor
		} else {
			System.out.println("Professor or course not found."); // Error message if not found
		}
	}

	// Method to list all students
	public void listStudents() {
		System.out.println("Students:");
		for (Student student : students) {
			System.out.println(student); // Print each student's name
		}
	}

	// Method to list all professors
	public void listProfessors() {
		System.out.println("Professors:");
		for (Professor professor : professors) {
			System.out.println(professor); // Print each professor's name
		}
	}

	// Method to list all courses
	public void listCourses() {
		System.out.println("Courses:");
		for (Course course : courses) {
			System.out.println(course); // Print each course's title
		}
	}

	// Method to display the courses a student is enrolled in
	public void displayStudentCourses(String studentName) {
		Student student = findStudentByName(studentName); // Find the student by name
		if (student != null) {
			System.out.println("Courses for student " + studentName + ":");
			for (Course course : student.getEnrolledCourses()) {
				System.out.println(course); // Print each enrolled course
			}
		} else {
			System.out.println("Student not found."); // Error message if student not found
		}
	}

	// Method to display the courses assigned to a professor
	public void displayProfessorCourses(String professorName) {
		Professor professor = findProfessorByName(professorName); // Find the professor by name
		if (professor != null) {
			System.out.println("Courses assigned to professor " + professorName + ":");
			for (Course course : professor.getAssignedCourses()) {
				System.out.println(course); // Print each assigned course
			}
		} else {
			System.out.println("Professor not found."); // Error message if professor not found
		}
	}

	// Helper method to find a student by name
	private Student findStudentByName(String name) {
		for (Student student : students) {
			if (student.getName().equalsIgnoreCase(name)) {
				return student; // Return the student if found
			}
		}
		return null; // Return null if student not found
	}

	// Helper method to find a professor by name
	private Professor findProfessorByName(String name) {
		for (Professor professor : professors) {
			if (professor.getName().equalsIgnoreCase(name)) {
				return professor; // Return the professor if found
			}
		}
		return null; // Return null if professor not found
	}

	// Helper method to find a course by title
	private Course findCourseByTitle(String title) {
		for (Course course : courses) {
			if (course.getTitle().equalsIgnoreCase(title)) {
				return course; // Return the course if found
			}
		}
		return null; // Return null if course not found
	}

	// Main method to interact with the system through a menu
	public static void main(String[] args) {
		UniversityManagement managment = new UniversityManagement();
		Scanner scanner = new Scanner(System.in);// scanner for user input.
		boolean running = true;// flag to controll while loop.
		while (running) {
			System.out.println("\nUniversityManagment");
			System.out.println("1. Add Student");
			System.out.println("2. Add Professor");
			System.out.println("3. Add Course");
			System.out.println("4. Enroll Student in Course");
			System.out.println("5. Assign Course to Professor");
			System.out.println("6. List of Students");
			System.out.println("7. List Of Professors");
			System.out.println("8. List Of Courses");
			System.out.println("9. Display Student Courses");
			System.out.println("10. Display Professor Courses");
			System.out.println("11. Exit");

			System.out.println("Enter your Option ");
			int option = scanner.nextInt();
			scanner.nextLine();// consume the newLine chatcter.

			// switch case to handle user Choice.
			switch (option) {
			case 1:
				System.out.print("Enter Student Name : ");
				String studentName = scanner.nextLine();
				managment.addStudent(studentName);// add the student.
				break;

			case 2:
				System.out.print("Enter Professor Name : ");
				String professorName = scanner.nextLine();
				managment.addProfessor(professorName);// add the professorname
				break;

			case 3:
				System.out.print("Enter Course Title : ");
				String courseTitle = scanner.nextLine();
				managment.addCourse(courseTitle);
				break;

			case 4:

				System.out.print("Enter Student Name : ");
				String enrollStudent = scanner.nextLine();
				System.out.print("Enter Course Title : ");
				String enrollCourse = scanner.nextLine();
				managment.enrollStudentInCourse(enrollStudent, enrollCourse);
				break;
			case 5:
				System.out.print("Enter Professor Name : ");
				String assignProfessor = scanner.nextLine();
				System.out.print("Enter Course Title");
				String assignCourse = scanner.nextLine();
				managment.assignCourseToProfessor(assignProfessor, assignCourse);
			case 6:
				managment.listStudents();
				break;
			case 7:
				managment.listProfessors();
				break;
			case 8:
				managment.listCourses();
				break;
			case 9:
				System.out.print("Enter Student Name : ");
				String displayStudent = scanner.nextLine();
				managment.displayStudentCourses(displayStudent);
				break;
			case 10:
				System.out.print("Enter Professor Name : ");
				String displayProfessor = scanner.nextLine();
				managment.displayProfessorCourses(displayProfessor);
				break;
			case 11:
				running = false;// exit the loop.
				System.out.println("Existing...");
				break;
			default:
				System.out.println("Invalid Choice. Please Enter a Number between 1 to 11");
				break;
			}
		}
		scanner.close();
	}
}