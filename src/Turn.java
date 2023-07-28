import java.util.Scanner;

public class Turn {
    private static final int correctGuessAmount = 200;
    private static final int incorrectGuessAmount = 100;
    public boolean takeTurn(Players player, Hosts host) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(player.getFirstName() + " " + player.getLastName() +  "enter your guess (between 0 and 100): ");
        int guess = scanner.nextInt();

        // ADAM:  boolean logic - correctGuess
        boolean correctGuess = Numbers.compareNumber(guess);
        if (correctGuess) {
            player.setMoney(player.getMoney() + correctGuessAmount);
            System.out.println("Congratulations, you guessed the number!");
            System.out.println(player);
        } else {
            player.setMoney(player.getMoney() - incorrectGuessAmount);
            System.out.println("I'm sorry. That guess was " + (guess > Numbers.getRandomNum() ? "too high." : "too low."));
            System.out.println(player);
        }
        return correctGuess;
    }
}
