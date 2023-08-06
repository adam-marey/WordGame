public class Money implements Award {
    private static final int correctGuessAmount = 200;
    private static final int incorrectGuessAmount = 100;

    @Override
    public int displayWinnings(Players player, boolean won) {
        if (won) {
            System.out.println(player.getFirstName() + ", you won!");
            return correctGuessAmount;
        } else {
            System.out.println(player.getFirstName() + ", you lost!");
            return -incorrectGuessAmount;
        }
    }
}
