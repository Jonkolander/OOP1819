package Assignment02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The view
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class View {

    private final Scanner SCANNER;
    private final StringBuilder BUILDER;
    private String word;

    public View() {
        this.SCANNER = new Scanner(System.in);
        this.BUILDER = new StringBuilder();
    }

    public String askWord() {
        System.out.println("\nPlease enter a word or press Enter to randomly pick");
        System.out.print("> ");
        return SCANNER.nextLine();
    }

    public char askLetter() {
        System.out.println("\nEnter the letter you want to guess.");
        System.out.print("> ");
        return SCANNER.next().charAt(0);
    }

    public void fillDots(String word) {
        this.word = word;
        
        for (int i = 0; i < word.length(); i++) {
            BUILDER.append(".");
        }
    }

    public void update() {
        System.out.println("Word: " + this.BUILDER);
    }
    
    public StringBuilder getBuilder() {
        return this.BUILDER;
    }

    public void changeBuilder(int index, char c) {
        this.BUILDER.setCharAt(index, c);
    }

    public void showGuessesAndLives(ArrayList<Character> c, int i) {
        System.out.println("Remaining mistakes: " + i);
        System.out.println("Guessed letters: " + c);
    }
    
    public void announceRandomWord() {
        System.out.println("Randomly picking a word.");
    }
    
    public void showWelcomeMessage() {
        System.out.println("Welcome to Hangman!");
    }

    public void showLossMessage() {
        System.out.println("\nYou have lost!");
        System.out.println("The word to be guessed was: " + word);
    }

    public void showWinMessage() {
        System.out.println("\nYou have won!");
    }

    public void showErrorMessage() {
        System.out.println("\nYou have already guessed this letter");
    }
    
    public void inWord(char letter) {
        System.out.println(letter + " is in the word");
    }
    
    public void notInWord(char letter) {
        System.out.println(letter + " is not in the word");
    }
}
