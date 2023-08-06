import java.util.Scanner;

public class Hosts extends Person {
    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
    }

    //adam:  replaced with randomizeNum() method
    public void setNewGamePhrase() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a phrase for players to guess: ");
        String phrase = scanner.nextLine();
        Phrases.setGamePhrase(phrase);
    }
}
