import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameGUI {
    private JFrame mainFrame;
    private JLabel currentHostLabel;
    private JTextArea messageArea;
    private JCheckBox saveMessagesCheckbox;
    private Hosts currentHost;

    public GameGUI() {
        mainFrame = new JFrame("Word Game");
        mainFrame.setSize(400, 300);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        mainFrame.setJMenuBar(menuBar);

        // Game Menu
        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(KeyEvent.VK_G);
        menuBar.add(gameMenu);

        JMenuItem addPlayerItem = new JMenuItem("Add Player");
        addPlayerItem.addActionListener(e -> createPlayer());
        gameMenu.add(addPlayerItem);

        JMenuItem addHostItem = new JMenuItem("Add Host");
        addHostItem.addActionListener(e -> createHost());
        gameMenu.add(addHostItem);

        // About Menu
        JMenu aboutMenu = new JMenu("About");
        aboutMenu.setMnemonic(KeyEvent.VK_A);
        JMenuItem layoutItem = new JMenuItem("Layout");
        layoutItem.addActionListener(e -> JOptionPane.showMessageDialog(mainFrame, "I chose this layout because it is simple and easy to use."));
        aboutMenu.add(layoutItem);
        menuBar.add(aboutMenu);

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainFrame.add(mainPanel);

        currentHostLabel = new JLabel("Current Host: None");
        mainPanel.add(currentHostLabel, BorderLayout.NORTH);

        messageArea = new JTextArea(5, 20);
        messageArea.setEditable(false);
        JScrollPane messageScrollPane = new JScrollPane(messageArea);
        mainPanel.add(messageScrollPane, BorderLayout.CENTER);

        saveMessagesCheckbox = new JCheckBox("Save Messages");
        saveMessagesCheckbox.setToolTipText("Keep previous messages when checked, otherwise show only the latest message.");
        saveMessagesCheckbox.addActionListener(e -> {
            if (!saveMessagesCheckbox.isSelected()) {
                messageArea.setText(""); //adam: Clear messages when unchecked
            }
        });
        mainPanel.add(saveMessagesCheckbox, BorderLayout.SOUTH);

        mainFrame.setVisible(true);
    }

    private void createPlayer() {
        String firstName = JOptionPane.showInputDialog("Enter player's first name:");
        String lastName = JOptionPane.showInputDialog("Enter player's last name:");
        if (firstName != null && lastName != null && !firstName.trim().isEmpty() && !lastName.trim().isEmpty()) {
            Players player = new Players(firstName, lastName);
            displayMessage("Player " + firstName + " " + lastName + " added!");
        }
    }

    private void createHost() {
        String firstName = JOptionPane.showInputDialog("Enter host's first name:");
        String lastName = JOptionPane.showInputDialog("Enter host's last name:");
        if (firstName != null && lastName != null && !firstName.trim().isEmpty() && !lastName.trim().isEmpty()) {
            currentHost = new Hosts(firstName, lastName);
            currentHostLabel.setText("Current Host: " + firstName + " " + lastName);
            displayMessage("Host " + firstName + " " + lastName + " added!");
        }
    }

    private void displayMessage(String message) {
        if (saveMessagesCheckbox.isSelected()) {
            messageArea.append(message + "\n");
        } else {
            messageArea.setText(message);
        }
    }

    public static void main(String[] args) {
        new GameGUI();
    }
}
