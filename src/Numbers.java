import java.util.Random;

public class Numbers {
    private int randomNum;

    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }

    public void generateNumber() {
        Random random = new Random();
        this.randomNum = random.nextInt(101);

        // ADAM: for testing purposes
        // System.out.println("Generated random number for testing: " + this.randomNum); // Print the random number
    }

    //ADAM:  boolean logic
    public boolean compareNumber(int guess) {
        if (guess == this.randomNum) {
            System.out.println("Congratulations, you guessed the number!");
            return true;
        }
        else if (guess > this.randomNum) {
            System.out.println("I'm sorry. That guess was too high.");
            return false;
        }
        else {
            System.out.println("I'm sorry, That guess was too low.");
            return false;
        }
    }
}
