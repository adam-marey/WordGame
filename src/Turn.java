import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Turn {
    public boolean takeTurn(Players player, Hosts host) {
        String guess = JOptionPane.showInputDialog(
                null,
                "Current Phrase: " + Phrases.getPlayingPhrase() + "\n" +
                        player.getFirstName() + " " + player.getLastName() + ", enter a letter to guess:"
        );

        if (guess == null || guess.isEmpty()) {
            return false;
        }

        try {
            boolean correctGuess = Phrases.findLetters(guess);
            if (!Phrases.getPlayingPhrase().contains("_")) {
                JOptionPane.showMessageDialog(null, "Well done " + player.getFirstName() + "! You've guessed the phrase!");
                return true;
            }
        } catch (MultipleLettersException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
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
        JOptionPane.showMessageDialog(null, player.getFirstName() + ", your updated money: $" + player.getMoney());
        return false;
    }
}
