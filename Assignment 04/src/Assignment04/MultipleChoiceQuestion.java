package Assignment04;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class MultipleChoiceQuestion extends Question {

    private final String QUESTION;
    private final String[] ANSWERS;
    private final int CORRECT_ANSWER;
    
    public MultipleChoiceQuestion(String question, String [] answers, int correctAnswer, int score) {
        super.setScore(score);
        this.QUESTION = question;
        this.ANSWERS = answers;
        this.CORRECT_ANSWER = correctAnswer;
    }
    
    public MultipleChoiceQuestion(String question, String [] answers, int correctAnswer) {
        this.QUESTION = question;
        this.ANSWERS = answers;
        this.CORRECT_ANSWER = correctAnswer;
    }
    
    @Override
    public String toString() {
        String output = QUESTION + "\n";
        for (int i = 0; i < this.ANSWERS.length; i++) {
            output += "  " + Character.toChars(i + 65)[0] + ": " + ANSWERS[i] + "\n";
        }
        return output;
    }

    @Override
    public boolean isCorrect(String answer) {
        return (int) (answer.toUpperCase().charAt(0) - 65) == this.CORRECT_ANSWER;
    }

    @Override
    public String correctAnswer() {
        return (char) (CORRECT_ANSWER + 65) +  ": " + this.ANSWERS[CORRECT_ANSWER];
    }

}
