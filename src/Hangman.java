import java.util.Random;

public class Hangman {
    private String usersGuess, secretWord;

    public Hangman() {
        Random myRand = new Random();
        int ranNum = myRand.nextInt(5) +1;
        if (ranNum == 1) {
            secretWord = "ball";
        } else if (ranNum == 2) {
            secretWord = "door";
        } else if (ranNum == 3) {
            secretWord = "down";
        } else if (ranNum == 4) {
            secretWord = "lava";
        } else if (ranNum == 5) {
            secretWord = "base";
        }

        int lengthOfSecretWord = secretWord.length();
        usersGuess = "";
        System.out.print("Your secret word is ");
        for (int i = 1; i <= lengthOfSecretWord; i++) {
            System.out.print("_");
        }
    }

    public String getSecretWord() {
        return secretWord;
    }
    public void setSecretWord(String aSecretWord) {
        this.secretWord = aSecretWord;
    }

    public String getUsersGuess() {
        return usersGuess;
    }

    public void setUsersGuess(String aUsersGuess) {
        this.usersGuess = aUsersGuess;
    }

    public String toString() {
        return "The secret word is " + secretWord + " and your guess was " + usersGuess;
    }
}
