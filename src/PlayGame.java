import java.util.Scanner;

public class PlayGame {

    static int gamesWon = 0;
    static int gamesLost = 0;

    public static void main(String[] args) {
        String playAgain = "";
        Scanner sc = new Scanner(System.in);
        do {
           Hangman aGame = new Hangman();
           processGuesses(aGame);
           determineWinner(aGame);
           System.out.println("Do you want to play again?");
           playAgain = sc.nextLine();

        } while(playAgain.equalsIgnoreCase("yes"));

        summarize();
    }

    public static void processGuesses(Hangman aGame) {
        String partA = "", partB = "";
        Scanner  sc = new Scanner(System.in);
        int secretWordLength = aGame.getSecretWord().length();
        int chances = 3 * secretWordLength;
        int usedChances = 0;
        int loc = -1;
        String letter = "";
        System.out.println("\nYou have " + chances + " chances to guess the word.");
        while (usedChances < chances && !aGame.getUsersGuess().equalsIgnoreCase(aGame.getSecretWord())) {
            usedChances++;
            System.out.println("Chance #" + usedChances + " out of " + chances + ": ");
            System.out.println("What is the letter of your next guess?");
            letter = sc.nextLine();

            for (int i = 0; i < secretWordLength; i++) {
                if (letter.equals(aGame.getSecretWord().indexOf(letter))) {
                    System.out.println("Your guess so far is: " + aGame.getSecretWord().substring(0,aGame.getSecretWord().indexOf(letter)) + letter + aGame.getSecretWord().substring(aGame.getSecretWord().indexOf(letter + 1)));
                }
            }
        }
    }

    public static void determineWinner(Hangman aGame) {
        if (aGame.getUsersGuess().equalsIgnoreCase(aGame.getSecretWord())) {
            System.out.println("Congrats! You guessed the secret word!");
            gamesWon++;
        } else {
            System.out.println("Sorry, better luck next time!");
            gamesLost++;
        }
        System.out.println(aGame);
    }

    public static void summarize() {
        System.out.println("Total wins: " + gamesWon);
        System.out.println("Total losses: " + gamesLost);
    }
}
