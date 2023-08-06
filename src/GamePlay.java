import java.util.Scanner;

public class GamePlay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Players[] currentPlayers = new Players[3];
        for(int i=0; i<3; i++) {
            System.out.print("Please enter player "+ (i+1) +"'s first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Would you like to enter a last name for player "+ (i+1) +"? (yes/no): ");

            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                System.out.print("Please enter your last name: ");
                String lastName = scanner.nextLine();
                currentPlayers[i] = new Players(firstName, lastName);

            } else {
                currentPlayers[i] = new Players(firstName, "");
            }
        }
        Hosts host = new Hosts("Adam", "Marey");
        Turn turnHandler = new Turn();

        System.out.println(host.getFirstName() + " " +  host.getLastName() + " " + "is hosting the game."); // Adam: for testing purposes

        boolean keepPlaying = true;
        while (keepPlaying) {
            host.randomizeNum();
            for(Players player : currentPlayers) {
                boolean correctGuess = false;
                while (!correctGuess) {
                    correctGuess = turnHandler.takeTurn(player, host);
                }
            }
            System.out.print("Do you want to keep playing? (yes/no): ");
            String continueResponse = scanner.next();
            keepPlaying = continueResponse.equalsIgnoreCase("yes");
        }
        System.out.println("Thanks for playing!");

    }
}
