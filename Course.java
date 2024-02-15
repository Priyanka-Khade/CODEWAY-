package StudentCourseRegistrationSystem;

import java.util.ArrayList;
import java.util.List;

class Course{
	private String courseCode;
	private String title;
	private String description;
	private int capacity;
	private int availableSlots;
	private String schedule;
	
	public Course(String courseCode, String title, String description, int capacity, String schedule) {
		this.courseCode = courseCode;
		this.title = title;
		this.description = description;
		this.capacity = capacity;
		this.availableSlots = availableSlots;
		this.schedule = schedule;
		
	}
	public String getcourseCode() {
		return courseCode;
		
	}
	
	public String getTitle() {
		return title;
		
	}
	public String getDescription() {
		return description;
	}
	public int getAvailableSlots() {
		return availableSlots;
	}
	public String getSchedule() {
		return schedule;
	}
	public void decrementAvailableSlots() {
		if (availableSlots > 0) {
			availableSlots--;
		}
	}

	public void incrementAvailableSlots() {
		if(availableSlots < capacity) {
			availableSlots++;
			
		}
	}
}
	/**public String getCourseCode() {
		// TODO Auto-generated method stub
		return null;
	}
}
	**/	
		class CourseDatabase{
			private List<Course> courses;
			
			public CourseDatabase() {
				this.courses =  new ArrayList<>();
				
				}
			public void addCourse(Course course) {
				courses.add(course);
				
			}
			public void removeCourse(Course course) {
				courses.remove(course);
			}
			public List<Course> getAllCourses(){
				return courses;
			}
		}
		
		class Student{
			private String studentID;
			private String studentName;
			private List<Course> registeredCourses;
			
			public Student(String studentID, String studentName) {
				this.studentID = studentID;
				this.studentName = studentName;
				this.registeredCourses = new ArrayList<>();
				
			}
			public String getStudentID() {
				return studentID;
			}
			public String getStudentName() {
				return studentName;
			}
			public List<Course> getRegisteredCourses(){
				return registeredCourses;
			}
			
			public void registerCourse(Course course) {
				if(course.getAvailableSlots() > 0) {
					registeredCourses.add(course);
					course.decrementAvailableSlots();
				}
				else {
					System.out.println("Course" + course.getcourseCode() + "is full.Registration failed.");
				}
			}
			public void dropCourse(Course course) {
				if(registeredCourses.contains(course)) {
					registeredCourses.remove(course);
					course.incrementAvailableSlots();
					System.out.println("Course" + course.getcourseCode() + "dropped successfully.");
				}
				else {
					System.out.println("Course" + course.getcourseCode() + "not found in registered courses.");
				}
			}
		}
		 class Form {
			public static void main(String[] args) {
				CourseDatabase courseDatabase = new CourseDatabase();
				
				// adding courses
				//courseDatabase.addCourse(new Course(courseCode:"C01",title:"java programming",decription:"Introduction to java programming",capacity:30,schedule:"Mon,Wed 10:00"));
				//courseDatabase.addCourse(new Course(courseCode:"C02",title:"data structure",decription:"Advance data structure concepts",capacity:25,schedule:"Tue,Thu 2:00"));
				
				// Displaying available courses
				System.out.println("Available Courses:");
				List<Course> allCourses = courseDatabase.getAllCourses();
				for (Course course : allCourses) {
					System.out.println("Course Code:" + course.getcourseCode());
					System.out.println("Title:" + course.getTitle());
					System.out.println("Description:" + course.getDescription());
					System.out.println("Available Slots:" + course.getAvailableSlots());
					System.out.println("Schedule:" + course.getSchedule());
					System.out.println("---------");
					
					
				}
				//student registration and course removal (sample operation)
				String studentID;
				String studentName;
				Student student1 = new Student(studentID="01", studentName="Ayan");
				Student student2 = new Student(studentID="02", studentName="Piyush");
			
				student1.registerCourse(allCourses.get(0));
				student1.registerCourse(allCourses.get(1));
				
				student2.registerCourse(allCourses.get(0));
				
				System.out.println("\nRegistered COurses for Ayan:");
				for (Course course : student1.getRegisteredCourses()) {
					System.out.println("Course Code:" + course.getcourseCode());
					System.out.println("Title:" + course.getTitle());
					System.out.println("--------");
					
				}
				student1.dropCourse(allCourses.get(0));
				
				System.out.println("\nRegistered Courses for Ayan after dropping a course:");
				for(Course course : student1.getRegisteredCourses()) {
					System.out.println("Course Code:" + course.getcourseCode());
					System.out.println("Title:" + course.getTitle());
					System.out.println("--------");
				}
			
			}
			
		}
	

