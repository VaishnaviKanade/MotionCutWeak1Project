import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Question {
    private String questionText;
    private String[] options;
    private char correctAnswer;

    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        for (Question question : questions) {
            String userAnswer = JOptionPane.showInputDialog(null, question.getQuestionText() +
                    "\n" + "A. " + question.getOptions()[0] +
                    "\n" + "B. " + question.getOptions()[1] +
                    "\n" + "C. " + question.getOptions()[2]);
            if (userAnswer != null && !userAnswer.isEmpty()) {
                char userChoice = userAnswer.toUpperCase().charAt(0);
                if (userChoice == question.getCorrectAnswer()) {
                    score++;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Quiz completed!\nYour score: " + score);
    }
}

public class App extends JFrame {
    private Quiz quiz;

    public App() {
        this.quiz = new Quiz();
        initialize();
    }

    private void initialize() {
// Question 1
Question q1 = new Question("What is the main purpose of the 'static' keyword in Java?",
        new String[]{"To create an instance of a class", "To define a constant", "To allow access to the class members without creating an object"}, 'C');
quiz.addQuestion(q1);

// Question 2
Question q2 = new Question("Which of the following is not a primitive data type in Java?",
        new String[]{"int", "float", "string"}, 'C');
quiz.addQuestion(q2);

// Question 3
Question q3 = new Question("What does JVM stand for?",
        new String[]{"Java Virtual Machine", "Java Visual Machine", "Java Virtual Memory"}, 'A');
quiz.addQuestion(q3);

// Question 4
Question q4 = new Question("What is the default value of the local variables in Java?",
        new String[]{"0", "null", "Garbage value"}, 'B');
quiz.addQuestion(q4);

// Question 5
Question q5 = new Question("Which of the following is not a Java keyword?",
        new String[]{"static", "final", "virtual"}, 'C');
quiz.addQuestion(q5);

// Question 6
Question q6 = new Question("What is the purpose of the 'super' keyword in Java?",
        new String[]{"To refer to the superclass", "To invoke the superclass constructor", "To create an instance of the superclass"}, 'A');
quiz.addQuestion(q6);

// Question 7
Question q7 = new Question("Which method is used to implement the 'equals' method in Java?",
        new String[]{"Object.equals()", "Object.compare()", "Object.checkEquals()"}, 'A');
quiz.addQuestion(q7);

// Question 8
Question q8 = new Question("What is the output of 'System.out.println(5 / 2)' in Java?",
        new String[]{"2", "2.5", "2.0"}, 'A');
quiz.addQuestion(q8);

// Question 9
Question q9 = new Question("In Java, which collection class does not extend the Collection interface?",
        new String[]{"ArrayList", "HashSet", "HashMap"}, 'C');
quiz.addQuestion(q9);

// Question 10
Question q10 = new Question("What is the purpose of the 'this' keyword in Java?",
        new String[]{"To refer to the current instance of the class", "To invoke a method in the superclass", "To create a new instance of the class"}, 'A');
quiz.addQuestion(q10);

        JButton startButton = new JButton("Start Quiz");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quiz.startQuiz();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(startButton, BorderLayout.CENTER);

        add(panel);

        setTitle("Online Quiz Application");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App());
    }
}
