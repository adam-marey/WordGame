import java.util.Random;

public class Numbers {
    private static int randomNum;

    public static int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int number) {
        randomNum = number;
    }

    public static void generateNumber() {
        Random random = new Random();
        randomNum = random.nextInt(101);

        // ADAM: for testing purposes
        // System.out.println("Generated random number for testing: " + this.randomNum); // Print the random number
    }

    //ADAM:  boolean logic
    public static boolean compareNumber(int guess) {
        if (guess == randomNum) {
            System.out.println("Congratulations, you guessed the number!");
            return true;
        }
        else if (guess > randomNum) {
            System.out.println("I'm sorry. That guess was too high.");
            return false;
        }
        else {
            System.out.println("I'm sorry, That guess was too low.");
            return false;
        }
    }
}
