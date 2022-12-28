import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        playGame();
    }

    static void playGame() {
        Random rnd = new Random();

        int hiddenNumber = rnd.nextInt(100);
        int numberOfAttempts = 0;
        int numberOfLives = 7;
        int trapNumber = rnd.nextInt(40, 61);
        int bonusNumber = rnd.nextInt(10, 21);

        Scanner sc = new Scanner(System.in);

        if (hiddenNumber != trapNumber && hiddenNumber != bonusNumber) {

            while (true) {
                System.out.print("Guess the number: ");
                int numberGuessed = sc.nextInt();
                numberOfAttempts++;

                if (numberGuessed == trapNumber) {
                    if (numberOfLives > 3) {
                        System.out.println("You hit the trap number " + trapNumber + " You lost 3 lives!");
                        numberOfLives -= 3;
                        System.out.printf("You have %d lives left\n", numberOfLives);
                    } else {
                        System.out.println("You hit the trap number " + trapNumber + ". You lost 3 lives!");
                        numberOfLives -= 3;
                    }
                } else if (numberGuessed == bonusNumber) {
                    System.out.println("You got the bonus number " + bonusNumber + ". You won 3 lives!");
                    numberOfLives += 3;
                } else {
                    if (numberGuessed > hiddenNumber) {
                        System.out.println("Less!");
                        numberOfLives--;
                        System.out.printf("You have %d lives left\n", numberOfLives);
                    } else if (numberGuessed < hiddenNumber) {
                        System.out.println("More!");
                        numberOfLives--;
                        System.out.printf("You have %d lives left\n", numberOfLives);
                    } else {
                        System.out.printf("Well done, you guessed it! You have used %d attempts!\n", numberOfAttempts);
                        break;
                    }
                }

                if (numberOfLives <= 0) {
                    System.out.println("Game Over Noob!");
                    break;
                }
            }
        } else {
            System.out.println("System error. Try again!");
        }
    }
}
