import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Word Guessing Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            JButton startButton = new JButton("Start Game");
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new GamePlay();
                    frame.dispose();
                }
            });
            frame.add(startButton, BorderLayout.CENTER);

            frame.pack();
            frame.setVisible(true);
        });
    }
}
