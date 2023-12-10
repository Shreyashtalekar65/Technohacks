import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    boolean flag = true;

    public static void main(String[] args) {
        NumberGuessingGame n = new NumberGuessingGame();

        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        do {
            int randNum = rand.nextInt(100) + 1;
            System.out.println(randNum);

            System.out.println("You have 5 attempts for guessing right");
            System.out.println("Enter Your Guess (1 to 100) -->");

            int num = 5;
            do {
                int playerGuess = scan.nextInt();
                if (randNum == playerGuess) {
                    System.out.println("You Won!!!!");
                    break;
                } else if (randNum > playerGuess) {
                    System.out.println("Smaller");
                    num--;
                } else if (randNum < playerGuess) {
                    System.out.println("Greater");
                    num--;
                }
                if (num == 0) {
                    System.out.println("You Lost");
                    break;
                }
            } while (num >= 1);

            System.out.println("Do you want to play the game again (Y/N)");
            char input = scan.next().charAt(0);
            if (input == 'N' || input == 'n') {
                n.flag = false;
            }
        } while (n.flag);

        System.out.println("Thank you for playing with us!!!");
    }
}
