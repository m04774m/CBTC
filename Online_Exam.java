import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    } //here1

    public void updatePassword(String newPassword) {
        this.password = newPassword;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }//here2
}

class Question {
    private String questionText;
    public String[] options;
    public int correctOption;

    public Question(String questionText, String[] options, int correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean isCorrect(int selectedOption) {
        return selectedOption == correctOption;
    }
}

class Exam {
    public Question[] questions;
    public int score;
    private User user;

    public Exam(User user, Question[] questions) {
        this.user = user;
        this.questions = questions;
        this.score = 0;
    }

    public void startExam() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < questions.length; i++) {
            Question question = questions[i];

            System.out.println("Question " + (i + 1) + ":");
            question.displayQuestion();

            System.out.print("Enter your answer (1-" + question.options.length + "): ");
            int selectedOption = scanner.nextInt();

            if (question.isCorrect(selectedOption)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect.");
            }
        }

        System.out.println("Exam completed. Your score: " + score + " out of " + questions.length);
    }
}

class OnlineExaminationSystem {
    public static void main(String[] args) {
        User user = new User("MM2001", "1234", "Moazzam Majid");
        Question[] questions = {
                new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Rome"}, 1),
                new Question("Which planet is known as the Red Planet?", new String[]{"Venus", "Mars", "Jupiter", "Saturn"}, 2),
                // Add more questions
        };
        Exam exam = new Exam(user, questions);

        Scanner scanner = new Scanner(System.in);

        boolean isLoggedIn = false;

        while (!isLoggedIn) {
            System.out.print("Username: ");
            String usernameInput = scanner.nextLine();
            System.out.print("Password: ");
            String passwordInput = scanner.nextLine();

            if (user.validatePassword(passwordInput) && user.getUsername().equals(usernameInput)) {
                System.out.println("Welcome, " + user.getName() + "!");
                isLoggedIn = true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        exam.startExam();

        System.out.println("Exam session closed. Logging out...");
    }
}