import java.util.Scanner;
class Java_project
{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game menu! Please select a game to play:");
        System.out.println("1. Tic Tac Toe");
        System.out.println("2. Hangman");
        System.out.println("3. Rock Paper Scissors");
        System.out.print("Enter the number of the game you want to play: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                TicTacToe ob1 = new TicTacToe();
                ob1.PlayTicTacToe();
                break;
            case 2:
                Hangman ob2= new Hangman();
                ob2.PlayHangman();
                break;
            case 3:
                RockPaperScissors ob3 =new RockPaperScissors();
                ob3.PlayRockPaperScissors();
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }
    }
}