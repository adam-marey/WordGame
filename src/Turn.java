import java.util.Random;
import java.util.Scanner;

public class Turn {
    public boolean takeTurn(Players player, Hosts host) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Current Phrase: " + Phrases.getPlayingPhrase());
        System.out.print(player.getFirstName() + " " + player.getLastName() +  " enter a letter to guess: ");
        String guess = scanner.nextLine();

        try{
            Phrases.findLetters(guess);
            if (!Phrases.getPlayingPhrase().contains("_")) {
                System.out.println("Well done " + player.getFirstName() + "! You've guessed the phrase!");
                return true;
            }
        } catch (MultipleLettersException e) {
            System.out.println(e.getMessage());
            return false;
        }catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
            return false;
        }

        Random random = new Random();
        int prizeType = random.nextInt(2);

        Award award;
        if (prizeType == 0) {
            award = new Money();
        } else {
            award = new Physical();
        }

        int prize = award.displayWinnings(player, true);
        player.setMoney(player.getMoney() + prize);
        System.out.println(player);
        return false;
    }
}
