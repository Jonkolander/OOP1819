package Assignment04;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class MultipleChoiceQuestion extends Question {

    private String question;
    private String[] answers;
    private int correctAnswer;
    private int score;
    
    public MultipleChoiceQuestion(String question, String [] answers, int correctAnswer, int score) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.score = score;
    }
    
    public MultipleChoiceQuestion(String question, String [] answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
    
    @Override
    public String toString() {
        String output = "Question:  " + question + "\n";
        for (int i = 0; i < this.answers.length; i++) {
            output += "  " + Character.toChars(i + 65)[0] + ": " + answers[i] + "\n";
        }
        return output + "\n";
    }

    @Override
    public boolean isCorrect(String answer) {
        return (int) (answer.toUpperCase().charAt(0) - 65) == this.correctAnswer;
    }

    @Override
    public String correctAnswer() {
        return (char) (correctAnswer + 65) +  ": " + this.answers[correctAnswer];
    }

    @Override
    public void setScore(int s) {

    }

}
