import java.util.Random;
import java.util.Scanner;

public class Turn {
    public boolean takeTurn(Players player, Hosts host) {

        Scanner scanner = new Scanner(System.in);
        System.out.print(player.getFirstName() + " " + player.getLastName() +  " enter your guess (between 0 and 100): ");
        int guess = scanner.nextInt();
        boolean correctGuess = Numbers.compareNumber(guess);

        Random random = new Random();
        int prizeType = random.nextInt(2);

        Award award;
        if (prizeType == 0) {
            award = new Money();
        } else {
            award = new Physical();
        }

        int prize = award.displayWinnings(player, correctGuess);
        player.setMoney(player.getMoney() + prize);
        System.out.println(player);
        return correctGuess;
    }
}
