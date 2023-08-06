import java.util.Random;

public class Physical implements Award {
    private String[] prizes = {"Iphone8", "Iphone9", "Iphone10", "Iphone11", "Iphone12"};

    private int getRandomPrizeIndex() {
        Random random = new Random();
        return random.nextInt(prizes.length);
    }

    @Override
    public int displayWinnings(Players player, boolean isCorrectGuess) {
        int prizeIndex = getRandomPrizeIndex();
        if (isCorrectGuess) {
            System.out.println(player.getFirstName() + ", Congratulations! You won a " + prizes[prizeIndex]);
        } else {
            System.out.println(player.getFirstName() + ", Sorry! You could have won a " + prizes[prizeIndex]);
        }
        return 0;
    }
}
