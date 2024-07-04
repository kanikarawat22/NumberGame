import java.util.Random;
import java.util.Scanner;

public class NumberG {
    private int number;
    private int inputNumber;
    private int noOfAttempts;
    private static final int MAX_ATTEMPTS = 10; // Maximum attempts per round

    public NumberG() {
        Random ran = new Random();
        this.number = ran.nextInt(100); // Generate a random number between 0 and 99
        this.noOfAttempts = 0;
    }

    public void playGame() {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        int totalAttempts = 0;
        int gamesPlayed = 0;

        while (playAgain) {
            System.out.println("Let's Play Guess the Number Game.");
            noOfAttempts = 0;
            gamesPlayed++;

            while (noOfAttempts < MAX_ATTEMPTS) {
                display();
                if (isCorrectNumber()) {
                    totalAttempts += noOfAttempts;
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String choice = sc.next();
            playAgain = choice.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! You played " + gamesPlayed + " rounds.");
        System.out.println("Your average score (attempts per game) is: " + (totalAttempts / gamesPlayed));
        sc.close();
    }

    private void display() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your guess (between 0 and 99): ");
        inputNumber = sc.nextInt();
        noOfAttempts++;
    }

    private boolean isCorrectNumber() {
        if (inputNumber == number) {
            System.out.println("Congratulations! You guessed it right.");
            System.out.println("You guessed it in " + noOfAttempts + " attempts.");
            return true;
        } else if (inputNumber > number) {
            System.out.println("Too high! Try again.");
        } else {
            System.out.println("Too low! Try again.");
        }

        if (noOfAttempts == MAX_ATTEMPTS) {
            System.out.println("Sorry, you've reached the maximum number of attempts.");
        }
        return false;
    }

    
    public static void main(String[] args) {
        NumberG game = new NumberG();
        game.playGame();
    }
}
