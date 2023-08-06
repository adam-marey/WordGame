import java.util.Scanner;

public class GamePlay {
    private static final int MAX_PLAYERS = 3;
    final Players[] currentPlayers = new Players[MAX_PLAYERS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GamePlay game = new GamePlay();

        for (int i = 0; i < MAX_PLAYERS; i++) {
            System.out.print("Please enter your name for Player " + (i+1) + ": ");
            String firstName = scanner.nextLine();

            System.out.print("Would you like to enter a last name for Player " + (i+1) + "? (yes/no): ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                System.out.print("Please enter your last name: ");
                String lastName = scanner.nextLine();
                game.currentPlayers[i] = new Players(firstName, lastName);
            } else {
                game.currentPlayers[i] = new Players(firstName, "");
            }
        }

        Hosts host = new Hosts("Adam", "Marey");
        Turn turnHandler = new Turn();

        System.out.println(host.getFirstName() + " " +  host.getLastName() + " " + "is hosting the game.");

        boolean keepPlaying = true;
        while (keepPlaying) {
            host.randomizeNum();

            for (Players player : game.currentPlayers) {
                boolean correctGuess = false;
                while (!correctGuess) {
                    correctGuess = turnHandler.takeTurn(player, host);
                }
            }

            System.out.print("Do you want to keep playing? (yes/no): ");
            String continueResponse = scanner.nextLine();
            keepPlaying = continueResponse.equalsIgnoreCase("yes");
        }
        System.out.println("Thanks for playing!");
    }
}
