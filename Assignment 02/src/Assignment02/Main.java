package Assignment02;

import java.util.ArrayList;

/**
 * The main class, implemented with a hangman game 
 * with rules according to the MVC pattern 
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Main {

    public static View view = new View();
    public static final int AMOUNT_OF_LIVES = 10;
    
    public static void main(String[] args) {
        playHangman();
    }

    public static void playHangman() {
        view.showWelcomeMessage();
        
        String promptedWord = view.askWord().trim();
        Gallows gallows = promptedWord.isEmpty() ? new Gallows() : new Gallows(promptedWord);
        gallows.setLives(AMOUNT_OF_LIVES);
        
        String word = gallows.getWord();
        view.fillDots(word);
        
        while (true) {
            String builder = view.getBuilder().toString();
            if (!builder.contains(Character.toString('.'))) {
                view.update();
                view.showWinMessage();
                return;
            } else {
                ArrayList<Character> guessedLetters = gallows.getGuessedLetters();
                view.showGuessesAndLives(guessedLetters, gallows.getLives());
                view.update();
                
                if (gallows.getLives() < 1) {
                    view.showLossMessage();
                    return;
                }
                
                char guessedLetter = view.askLetter();
                
                if (guessedLetters.contains(guessedLetter)) {
                    view.showErrorMessage();
                } else {
                    gallows.addGuessedLetter(guessedLetter);
                }
                
                if (!word.contains(Character.toString(guessedLetter))) {
                    view.notInWord(guessedLetter);
                    gallows.setLives(gallows.getLives() - 1);
                } else {
                    view.inWord(guessedLetter);
                }
                
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guessedLetter) {
                        view.changeBuilder(i, guessedLetter);
                    }
                }
            }
        }
    }
}
