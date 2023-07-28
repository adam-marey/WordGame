import java.util.Scanner;

public class GamePlay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String firstName = scanner.nextLine();

        System.out.print("Would you like to enter a last name? (yes/no): ");

        String response = scanner.nextLine();

        Players player;

        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Please enter your last name: ");
            String lastName = scanner.nextLine();
            player = new Players(firstName, lastName);

        } else {
            player = new Players(firstName, "");
        }
        Hosts host = new Hosts("Adam", "Marey");
        Turn turnHandler = new Turn();

        System.out.println(host.getFirstName() + " " +  host.getLastName() + " " + "is hosting the game."); // Adam: for testing purposes

        boolean keepPlaying = true;
        while (keepPlaying) {
            host.randomizeNum();
            boolean correctGuess = false;
            while (!correctGuess) {
                correctGuess = turnHandler.takeTurn(player, host);
            }
            System.out.print("Do you want to keep playing? (yes/no): ");
            String continueResponse = scanner.next();
            keepPlaying = continueResponse.equalsIgnoreCase("yes");
        }
        System.out.println("Thanks for playing!");

    }
}
