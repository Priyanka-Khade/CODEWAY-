import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {
		int numberOfSubject = 4;
		int sumSubject = 0;
		int percentage;
		
		GradeCalculator GradeCalculator = new GradeCalculator();
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<numberOfSubject; i++) {
			System.out.println("Ente marks for subject" + (i+1));
			sumSubject = sumSubject + sc.nextInt();
			
		}
		percentage = sumSubject / numberOfSubject;
		System.out.println("Sum of all subjects:" +sumSubject);
		System.out.println("percentage:" + percentage);
		
		if(percentage <40) {
			System.out.println("Grade: Failed");
		}
		else if 
			(percentage >= 40 && percentage <60){
			  System.out.println("Grade: C");
			}
			else if
			(percentage >= 60 && percentage <80){
				System.out.println("Grade: B");
		}
			else if
			(percentage >= 80 && percentage <=100){
				System.out.println("Grade: A++");
		}
			else {
			System.out.println("Invalid marks.Please enter valid marks.");
		}
		
		
	}

}
