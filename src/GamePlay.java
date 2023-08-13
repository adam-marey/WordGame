import javax.swing.*;
import java.awt.*;

public class GamePlay {
    private final JFrame frame;
    private final JPanel playerInputPanel;
    private final Players[] currentPlayers;
    private final Turn turnHandler;
    private static final int MAX_PLAYERS = 3;

    public GamePlay() {
        frame = new JFrame("Word Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        playerInputPanel = new JPanel(new GridLayout(MAX_PLAYERS, 2));

        currentPlayers = new Players[MAX_PLAYERS];
        turnHandler = new Turn();

        for (int i = 0; i < MAX_PLAYERS; i++) {
            addPlayerInput(i);
        }

        JButton startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(e -> startGame());

        frame.add(playerInputPanel, BorderLayout.CENTER);
        frame.add(startGameButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void addPlayerInput(int playerIndex) {
        JTextField firstNameField = new JTextField(10);
        JTextField lastNameField = new JTextField(10);
        JLabel nameLabel = new JLabel("Player " + (playerIndex + 1) + " Name:");
        JLabel lastNameLabel = new JLabel("Last Name (optional):");

        playerInputPanel.add(nameLabel);
        playerInputPanel.add(firstNameField);
        playerInputPanel.add(lastNameLabel);
        playerInputPanel.add(lastNameField);
    }

    private void startGame() {
        for (int i = 0; i < MAX_PLAYERS; i++) {
            JTextField firstNameField = (JTextField) playerInputPanel.getComponent(i * 2 + 1);
            JTextField lastNameField = (JTextField) playerInputPanel.getComponent(i * 2 + 3);

            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();

            if (!firstName.isEmpty()) {
                currentPlayers[i] = new Players(firstName, lastName);
            }
        }

        Hosts host = new Hosts("Adam", "Marey");

        JOptionPane.showMessageDialog(frame, host.getFirstName() + " " + host.getLastName() + " is hosting the game.");

        boolean keepPlaying = true;
        while (keepPlaying) {
            host.setGamePhrase(frame);

            for (Players player : currentPlayers) {
                if (player != null) {
                    boolean correctGuess = false;
                    while (!correctGuess) {
                        correctGuess = turnHandler.takeTurn(player, host);
                    }
                    host.setGamePhrase(frame);
                }
            }

            int option = JOptionPane.showConfirmDialog(frame, "Do you want to keep playing?", "Continue Playing?", JOptionPane.YES_NO_OPTION);
            keepPlaying = (option == JOptionPane.YES_OPTION);

            if (keepPlaying) {
                resetGame();
            }
        }

        JOptionPane.showMessageDialog(frame, "Thanks for playing!");
        frame.dispose();
    }

    private void resetGame() {
        for (Players player : currentPlayers) {
            if (player != null) {
                player.setMoney(1000);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GamePlay::new);
    }
}
