import java.util.Random;

public class Physical implements Award {
    private String[] prizes = {"Iphone8", "Iphone9", "Iphone10", "Iphone11", "Iphone12"};

    private int getRandomPrizeIndex() {
        Random random = new Random();
        return random.nextInt(prizes.length);
    }

    @Override
    public int displayWinnings(Players player, boolean won) {
        String prize = prizes[getRandomPrizeIndex()];
        if (won) {
            System.out.println(player.getFirstName() + ", you won a " + prize + "!");
        } else {
            System.out.println(player.getFirstName() + ", you lost! You could have won a " + prize);
        }
        return 0;
    }
}
