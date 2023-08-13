import javax.swing.*;
public class Money implements Award {
    private static final int correctGuessAmount = 200;
    private static final int incorrectGuessAmount = 100;

    @Override
    public int displayWinnings(Players player, boolean won) {
        if (won) {
            JOptionPane.showMessageDialog(null, player.getFirstName() + ", you won " + correctGuessAmount + "!");
            return correctGuessAmount;
        } else {
            JOptionPane.showMessageDialog(null, player.getFirstName() + ", you lost " + incorrectGuessAmount + "!");
            return -incorrectGuessAmount;
        }
    }
}
