import java.util.Scanner;

public class GamePlay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String firstName = scanner.nextLine();

        System.out.print("Would you like to enter a last name? (yes/no): ");
        String response = scanner.nextLine();

        Person player;

        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Please enter your last name: ");
            String lastName = scanner.nextLine();
            player = new Person(firstName, lastName);
        } else {
            player = new Person(firstName);
        }

        Numbers game = new Numbers();
        game.generateNumber();
        boolean correctGuess = false;
        while (!correctGuess) {
            System.out.print(player.getFirstName() + ", enter your guess: ");
            int guess = scanner.nextInt();
            correctGuess = game.compareNumber(guess);
        }
    }
}
