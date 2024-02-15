import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz{
	private String question;
	private List<String> options;
	private int correctOption;
	
	public Quiz(String question,List<String> options,int correctOption) {
		this.question = question;
		this.options = options;
		this.correctOption = correctOption;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public List<String> getOptions(){
		return options;
	}
	
	public int getCorrectOption() {
		return correctOption;
	}
		
	}
public class Test{
	private List<Quiz> questions;
	private int currentQuestionIndex;
	private int score;
	private Timer timer;
	private Scanner scanner;
	
	public Test(){
		questions = new ArrayList<>();
		currentQuestionIndex = 0;
		score = 0;
		timer = new Timer();
		scanner = new Scanner(System.in);
	}
	
	public void addQuestion(Quiz question) {
		questions.add(question);
	}
	
	public void startQuiz() {
		System.out.println("Welcome to the Quiz!");
		timer.schedule(new QuizTimerTask(),3,700000);
	
	while(currentQuestionIndex < questions.size()) {
		Quiz currentQuestion = questions.get(currentQuestionIndex);
		displayQuestion(currentQuestion);
		
		int userChoice = getUserChoice();
		if(userChoice == currentQuestion.getCorrectOption()) {
			System.out.println("Correct!");
			score++;
			
		}
		
		else {
			System.out.println("Incorrect.");
			
		}
		currentQuestionIndex++;
	}
	displayResult();
	
	
	}
	private void displayQuestion (Quiz question) {
		System.out.println(question.getQuestion());
		List<String> options = question.getOptions();
		for(int i=0;i<options.size();i++) {
			System.out.println((i + 1) + "." + options.get(i));
		}
	}
	private int getUserChoice() {
		System.out.println("Enter Your Choice(1-" + questions.get(currentQuestionIndex).getOptions().size() + "):");
		return scanner.nextInt();
	}
	private void displayResult() {
		System.out.println("Quiz Completed!");
		System.out.println("Your score:" + score + "/" + questions.size());
	}
	
	private class QuizTimerTask extends TimerTask{
		private int secondsLeft = 10;
		
		@Override
		public void run() {
			if(secondsLeft > 0) {
				System.out.println("Time left:" + secondsLeft + "seconds");
				secondsLeft--;
				
			}
			else {
				System.out.println("Time's up!");
				currentQuestionIndex++;
				
			}
		}
	}
public static void main(String[] args) {
	Test quizApp = new Test();
	
	quizApp.addQuestion(new Quiz("1.what is 5+3?",List.of("3","8","5"),2));
	quizApp.addQuestion(new Quiz("2.what is the capital of France?",List.of("Berlin","Madrid","Paris"),3));
	quizApp.addQuestion(new Quiz("3.who painted the Mona Lisa?",List.of("Leonardo da vinci","Vincent van Gogh","Pablo Picasso"),1));
	quizApp.addQuestion(new Quiz("4.what gas do plants absorb from the atmosphere?",List.of("oxygen","carbon Dioxide","Nitrogen"),2));
	quizApp.addQuestion(new Quiz("5.which planet is known as the Red Planet?",List.of("Venus","Mars","Jupiter"),2));
	quizApp.addQuestion(new Quiz("6.which country is known as the land of Rising Sun?",List.of("China","Japan","Korea"),2));
	quizApp.addQuestion(new Quiz("7.what is the chemical symbol for gold?",List.of("Au","Ag","Fe"),1));
	quizApp.addQuestion(new Quiz("8.what is who wrote the play 'Romeo and Juliet'?",List.of("Charles Dickens","William Shakespeare","Jane Austen"),2));
	quizApp.addQuestion(new Quiz("9.what is the national flower of Japan?",List.of("tulip","Rose","Cherry Blossom"),3));
	quizApp.addQuestion(new Quiz("10.what is the largest planet in our solar system?",List.of("Earth","Mars","Jupitar"),3));
	
	
	quizApp.startQuiz();
	}

}
