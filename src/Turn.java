import java.util.Random;
import javax.swing.*;

public class Turn {
    public boolean takeTurn(Players player, Hosts host) {
        String guess = JOptionPane.showInputDialog(null, "Enter a letter to guess:");

        if (guess == null || guess.isEmpty()) {
            return false;
        }

        try {
            Phrases.findLetters(guess);
            if (!Phrases.getPlayingPhrase().contains("_")) {
                JOptionPane.showMessageDialog(null, "Well done " + player.getFirstName() + "! You've guessed the phrase!");
                return true;
            }
        } catch (MultipleLettersException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        Random random = new Random();
        int prizeType = random.nextInt(2);

        Award award = (prizeType == 0) ? new Money() : new Physical();

        int prize = award.displayWinnings(player, true);
        player.setMoney(player.getMoney() + prize);
        JOptionPane.showMessageDialog(null, player.getFirstName() + ", your updated money: $" + player.getMoney());
        return false;
    }
}
