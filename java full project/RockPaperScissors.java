import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    public static void PlayRockPaperScissors() {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int userScore = 0;
        int computerScore = 0;
        int numRounds = 0;
        boolean playAgain = true;

        while (playAgain) {
            System.out.print("Enter your move (rock, paper, or scissors): ");
            String userMove = input.next().toLowerCase();

            int computerMove = rand.nextInt(3); // 0 = rock, 1 = paper, 2 = scissors

            System.out.println("Computer chooses " + getMove(computerMove));

            String result = getResult(userMove, computerMove);

            if (result.equals("win")) {
                System.out.println("You win!");
                userScore++;
            } else if (result.equals("lose")) {
                System.out.println("You lose!");
                computerScore++;
            } else {
                System.out.println("It's a tie!");
            }

            numRounds++;
            System.out.println("Current score: You " + userScore + ", Computer " + computerScore);

            System.out.print("Do you want to play again? (y/n): ");
            String playAgainStr = input.next().toLowerCase();
            if (playAgainStr.equals("n")) {
                playAgain = false;
            }
        }

        System.out.println("Thanks for playing! Final score: You " + userScore + ", Computer " + computerScore);
        System.out.println("Total number of rounds played: " + numRounds);
    }

    // Returns the string representation of a move
    public static String getMove(int move) {
        if (move == 0) {
            return "rock";
        } else if (move == 1) {
            return "paper";
        } else {
            return "scissors";
        }
    }

    // Determines the result of the game
    public static String getResult(String userMove, int computerMove) {
        if (userMove.equals("rock")) {
            if (computerMove == 0) {
                return "tie";
            } else if (computerMove == 1) {
                return "lose";
            } else {
                return "win";
            }
        } else if (userMove.equals("paper")) {
            if (computerMove == 0) {
                return "win";
            } else if (computerMove == 1) {
                return "tie";
            } else {
                return "lose";
            }
        } else {
            if (computerMove == 0) {
                return "lose";
            } else if (computerMove == 1) {
                return "win";
            } else {
                return "tie";
            }
        }
    }
}