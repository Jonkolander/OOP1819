package Assignment04;

/**
 * @author Dennis den Hollander
 */
public abstract class Question {
    
    private int score = 0;
    
    @Override
    abstract public String toString();
    
    abstract public boolean isCorrect(String answer);
    
    abstract public String correctAnswer();
    
    abstract public void setScore(int s);
    
}
