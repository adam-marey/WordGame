import javax.swing.*;

public class Hosts extends Person {
    public Hosts(String firstName, String lastName) {
        super(firstName, lastName);
    }

    //adam:  replaced with randomizeNum() method
    public void setGamePhrase(JFrame frame) {
        String phrase = JOptionPane.showInputDialog(frame, "Please enter a phrase for players to guess:");
        Phrases.setGamePhrase(phrase);
    }
}
