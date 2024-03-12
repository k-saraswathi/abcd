import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String questionText;
    private List<String> options;
    private int correctAnswerIndex;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
    private List<Question> questions;

    public Quiz() {
        questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public int getNumQuestions() {
        return questions.size();
    }
}

public class OnlineQuizApplication {
    public static void main(String[] args) {
        // Create Quiz
        Quiz quiz = new Quiz();

        // Add Questions
        Question question1 = new Question("What is the capital of France?",
                List.of("A. London", "B. Paris", "C. Rome", "D. Berlin"), 1);
        quiz.addQuestion(question1);

        Question question2 = new Question("Which planet is known as the Red Planet?",
                List.of("A. Mars", "B. Venus", "C. Jupiter", "D. Saturn"), 0);
        quiz.addQuestion(question2);

        // Take Quiz
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (int i = 0; i < quiz.getNumQuestions(); i++) {
            Question currentQuestion = quiz.getQuestion(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestionText());
            for (String option : currentQuestion.getOptions()) {
                System.out.println(option);
            }
            System.out.print("Enter your answer (A, B, C, or D): ");
            String userAnswer = scanner.nextLine().toUpperCase();
            int userAnswerIndex = userAnswer.charAt(0) - 'A'; // Convert A, B, C, D to 0, 1, 2, 3

            if (userAnswerIndex == currentQuestion.getCorrectAnswerIndex()) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + currentQuestion.getOptions().get(currentQuestion.getCorrectAnswerIndex()));
            }
            System.out.println();
        }

        // Display Score
        System.out.println("Quiz completed! Your score is: " + score + "/" + quiz.getNumQuestions());
    }
}
