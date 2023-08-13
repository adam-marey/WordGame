import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Turn {
    public boolean takeTurn(Players player, Hosts host) {
        String guess = JOptionPane.showInputDialog(null,
                "Current Phrase: " + Phrases.getPlayingPhrase() + "\n" +
                        player.getFirstName() + " " + player.getLastName() + ", enter a letter to guess:");

        if (guess == null || guess.isEmpty()) {
            return false;
        }

        try {
            boolean correctGuess = Phrases.findLetters(guess);
            if (Phrases.getPlayingPhrase().indexOf('_') == -1) {
                JOptionPane.showMessageDialog(null, "Well done " + player.getFirstName() + "! You've guessed the phrase!");
                return true;
            }
            if (correctGuess) {
                int prizeType = new Random().nextInt(2);
                Award award = (prizeType == 0) ? new Money() : new Physical();
                int prize = award.displayWinnings(player, true);
                player.setMoney(player.getMoney() + prize);
                JOptionPane.showMessageDialog(null, player);
            }
            return correctGuess;
        } catch (MultipleLettersException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
