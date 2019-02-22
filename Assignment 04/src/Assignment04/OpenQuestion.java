package Assignment04;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class OpenQuestion extends Question {

    private String question;
    private String answer;
    private int points;
    
    public OpenQuestion (String question, String answer, int points) {
        this.question = question;
        this.answer = answer;
        this.points = points;
    }
    
    public OpenQuestion (String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    
    @Override
    public String toString() {
        return "Question: " + this.question + "\n";
    }

    @Override
    public boolean isCorrect(String answer) {
        return this.answer.equalsIgnoreCase(answer);
    }

    @Override
    public String correctAnswer() {
        return this.answer;
    }
    
    @Override
    public void setScore(int s) {
        this.points = (s < 1 || s > 5) ? 3 : s;
    }

}
