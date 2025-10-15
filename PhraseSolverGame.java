import java.util.Scanner;
import java.util.Random;

public class PhraseSolverGame {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Phrase phrase;
    private int pointValue;
    private boolean solved;
    private Scanner input = new Scanner(System.in);
    private Random rand = new Random();

    public PhraseSolverGame() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        currentPlayer = player1;
        phrase = new Phrase("HELLO WORLD");
        pointValue = rand.nextInt(100) + 1;
        solved = false;
    }

    // Mutators
    public void setPointValue(int points) {
        pointValue = points;
    }

    public void setCurrentPlayer(Player p) {
        currentPlayer = p;
    }

    // Game Logic
    public void play() {
        System.out.println("Let's play Phrase Solver!");
        while (!solved) {
            System.out.println("\nCurrent phrase: " + phrase.getSolvedPhrase());
            System.out.println(currentPlayer.getName() + ", your score: " + currentPlayer.getScore());
            System.out.println("Point value this round: " + pointValue);

            System.out.print("Enter a letter or try to solve the phrase: ");
            String guess = input.nextLine().toUpperCase();

            if (guess.length() == 1) { // guessing a letter
                char letter = guess.charAt(0);
                if (phrase.checkLetter(letter)) {
                    System.out.println("Correct! You earned " + pointValue + " points!");
                    currentPlayer.addToScore(pointValue);
                } else {
                    System.out.println("Sorry, that letter is not in the phrase.");
                    switchPlayer();
                }
            } else { // solving attempt
                if (guess.equals(phrase.getSolvedPhrase()) || guess.equals(phrase.getSolvedPhrase().replace("_", ""))) {
                    System.out.println("Correct! The phrase was: " + phrase.getSolvedPhrase());
                    solved = true;
                } else {
                    System.out.println("Incorrect solution!");
                    switchPlayer();
                }
            }

            if (phrase.isSolved()) {
                solved = true;
            }

            pointValue = rand.nextInt(100) + 1;
        }

        endGame();
    }

    private void switchPlayer() {
        if (currentPlayer == player1)
            currentPlayer = player2;
        else
            currentPlayer = player1;
    }

    private void endGame() {
        System.out.println("\nGame over!");
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());

        if (player1.getScore() > player2.getScore())
            System.out.println(player1.getName() + " wins!");
        else if (player2.getScore() > player1.getScore())
            System.out.println(player2.getName() + " wins!");
        else
            System.out.println("It's a tie!");
    }
}
