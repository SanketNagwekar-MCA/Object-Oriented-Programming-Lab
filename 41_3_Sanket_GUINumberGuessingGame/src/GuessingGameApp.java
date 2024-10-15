import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

// Entry point of the guessing game application
public class GuessingGameApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameSession().begin());
    }
}

// Manages the game flow and logic with a GUI
class GameSession {
    private int targetNumber;
    private int maxAttempts;
    private int attemptsMade;
    private boolean numberGuessed;
    private User currentUser;
    private JFrame frame;
    private JTextField guessField;
    private JLabel feedbackLabel, attemptsLabel;
    private JProgressBar progressBar;
    private CustomButton guessButton, restartButton, startButton, helpButton, exitButton;
    private JComboBox<String> difficultyComboBox;
    private final int EASY_MAX = 50, MEDIUM_MAX = 100, HARD_MAX = 200;

    // Constructor to set up the game session
    public GameSession() {
        this.attemptsMade = 0;
        this.numberGuessed = false;
        this.currentUser = new User();
    }

    // Starts the game session and sets up the GUI
    public void begin() {
        frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full-screen mode
        frame.setUndecorated(true); // Remove the window frame for a cleaner look

        // Set up main panel with GridBagLayout for centering components
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.anchor = GridBagConstraints.CENTER;

        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255)); // Light background

        // Set up a modern font
        Font labelFont = new Font("Verdana", Font.PLAIN, 16);
        Font buttonFont = new Font("Verdana", Font.BOLD, 14);

        // Welcome label with increased padding and bold font
        JLabel welcomeLabel = new JLabel("Welcome to the Number Guessing Challenge!");
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 18));
        welcomeLabel.setForeground(new Color(70, 130, 180)); // Steel blue color

        JLabel nameLabel = new JLabel("Enter your name:");
        nameLabel.setFont(labelFont);
        nameLabel.setForeground(Color.DARK_GRAY);

        JTextField nameField = new JTextField(10);
        nameField.setMaximumSize(new Dimension(250, 30));
        nameField.setBorder(BorderFactory.createLineBorder(new Color(135, 206, 250), 2)); // Light blue border
        nameField.setFont(labelFont);

        JLabel difficultyLabel = new JLabel("Select difficulty level:");
        difficultyLabel.setFont(labelFont);
        difficultyLabel.setForeground(Color.DARK_GRAY);

        String[] difficulties = { "Easy", "Medium", "Hard" };
        difficultyComboBox = new JComboBox<>(difficulties);
        difficultyComboBox.setMaximumSize(new Dimension(150, 30));
        difficultyComboBox.setFont(labelFont);
        difficultyComboBox.setBackground(Color.WHITE);
        difficultyComboBox.setForeground(new Color(70, 130, 180)); // Steel blue text

        // Custom styled buttons
        startButton = new CustomButton("Start Game", buttonFont);
        guessButton = new CustomButton("Submit Guess", buttonFont);
        restartButton = new CustomButton("Restart Game", buttonFont);
        helpButton = new CustomButton("Game Rules", buttonFont);
        exitButton = new CustomButton("Exit Game", buttonFont); // New Exit Game button

        guessButton.setEnabled(false);
        restartButton.setEnabled(false);

        feedbackLabel = new JLabel("Guess the number based on the difficulty selected!");
        feedbackLabel.setFont(labelFont);
        feedbackLabel.setForeground(Color.DARK_GRAY);

        guessField = new JTextField(5);
        guessField.setMaximumSize(new Dimension(100, 30));
        guessField.setBorder(BorderFactory.createLineBorder(new Color(135, 206, 250), 2)); // Light blue border
        guessField.setFont(labelFont);
        guessField.setEnabled(false);

        attemptsLabel = new JLabel("Attempts: 0/10");
        attemptsLabel.setFont(labelFont);
        attemptsLabel.setForeground(Color.DARK_GRAY);

        progressBar = new JProgressBar(0, 10);
        progressBar.setMaximumSize(new Dimension(200, 30));
        progressBar.setForeground(new Color(70, 130, 180)); // Steel blue progress bar

        // Add components to panel using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(welcomeLabel, gbc);

        gbc.gridy++;
        panel.add(nameLabel, gbc);

        gbc.gridy++;
        panel.add(nameField, gbc);

        gbc.gridy++;
        panel.add(difficultyLabel, gbc);  // Difficulty label on its own line

        gbc.gridy++;  // Move combo box to the next row
        panel.add(difficultyComboBox, gbc); // ComboBox on its own line

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER; // Center the Start Game button
        panel.add(startButton, gbc);

        gbc.gridy++;
        gbc.gridwidth = 2; // Reset the grid width for the remaining components
        panel.add(feedbackLabel, gbc);

        gbc.gridy++;
        panel.add(guessField, gbc);

        gbc.gridy++;
        panel.add(guessButton, gbc);

        gbc.gridy++;
        panel.add(restartButton, gbc);

        gbc.gridy++;
        panel.add(helpButton, gbc);

        gbc.gridy++;
        panel.add(exitButton, gbc); // Add Exit Game button below Help button

        gbc.gridy++;
        panel.add(attemptsLabel, gbc);

        gbc.gridy++;
        panel.add(progressBar, gbc);

        // Set action listeners for buttons
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentUser.setUsername(nameField.getText());
                nameField.setEnabled(false);
                startButton.setEnabled(false);
                guessField.setEnabled(true);
                guessButton.setEnabled(true);
                restartButton.setEnabled(true);
                difficultyComboBox.setEnabled(false);
                setDifficulty(difficultyComboBox.getSelectedItem().toString());
                generateTargetNumber();
                feedbackLabel.setText("Guess the number!");
                progressBar.setMaximum(maxAttempts);
                progressBar.setValue(0);
                attemptsLabel.setText("Attempts: 0/" + maxAttempts);
            }
        });

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int userGuess = Integer.parseInt(guessField.getText());
                    evaluateGuess(userGuess);
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Please enter a valid number.");
                }
            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame(nameField);
            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Rules of the Game:\n"
                                + "1. Select a difficulty level (Easy, Medium, Hard).\n"
                                + "2. You will have a limited number of attempts to guess a random number.\n"
                                + "3. Enter a number and click 'Submit Guess' to check your guess.\n"
                                + "4. You will get feedback if your guess is too high or too low.\n"
                                + "5. The game ends when you guess the number or exhaust all attempts.",
                        "Game Rules", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        exitButton.addActionListener(new ActionListener() { // Exit game action listener
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?",
                        "Exit Game", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    frame.dispose(); // Close the application
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    // Set the difficulty level based on user selection
    private void setDifficulty(String difficulty) {
        switch (difficulty) {
            case "Easy":
                maxAttempts = 10;
                targetNumber = EASY_MAX;
                break;
            case "Medium":
                maxAttempts = 8;
                targetNumber = MEDIUM_MAX;
                break;
            case "Hard":
                maxAttempts = 5;
                targetNumber = HARD_MAX;
                break;
        }
    }

    // Generates a random number to be guessed
    private void generateTargetNumber() {
        Random random = new Random();
        this.targetNumber = random.nextInt(targetNumber) + 1;
    }

    // Checks the user's guess and provides feedback
    private void evaluateGuess(int guess) {
        attemptsMade++;
        progressBar.setValue(attemptsMade);

        if (guess == targetNumber) {
            feedbackLabel.setText("Congratulations, you guessed the correct number!");
            numberGuessed = true;
            guessField.setEnabled(false);
            guessButton.setEnabled(false);
        } else if (guess < targetNumber) {
            feedbackLabel.setText("Too low, try again!");
        } else {
            feedbackLabel.setText("Too high, try again!");
        }

        attemptsLabel.setText("Attempts: " + attemptsMade + "/" + maxAttempts);

        if (attemptsMade >= maxAttempts && !numberGuessed) {
            feedbackLabel.setText("Game Over! The number was " + targetNumber + ".");
            guessField.setEnabled(false);
            guessButton.setEnabled(false);
        }
    }

    // Resets the game state for a new session
    private void resetGame(JTextField nameField) {
        nameField.setEnabled(true);
        startButton.setEnabled(true);
        guessField.setEnabled(false);
        guessButton.setEnabled(false);
        restartButton.setEnabled(false);
        difficultyComboBox.setEnabled(true);
        attemptsMade = 0;
        progressBar.setValue(0);
        feedbackLabel.setText("Guess the number based on the difficulty selected!");
        attemptsLabel.setText("Attempts: 0/" + maxAttempts);
        guessField.setText("");
        nameField.setText("");
    }

    // Creates a custom styled JButton with rounded edges and modern appearance
    private CustomButton createStyledButton(String text, Font font) {
        return new CustomButton(text, font);
    }
}

// Custom button class for styling and hover effects
class CustomButton extends JButton {
    private final Color normalColor = new Color(70, 130, 180);
    private final Color hoverColor = new Color(100, 149, 237); // Slightly lighter blue

    public CustomButton(String text, Font font) {
        super(text);
        setFont(font);
        setFocusPainted(false); // Remove focus painting for a cleaner look
        setContentAreaFilled(false); // Remove default button background
        setBorderPainted(false); // Remove button border
        setOpaque(false); // Make the button transparent
        setBackground(normalColor); // Set default background color

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(normalColor);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Button background color
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        // Text color
        g2.setColor(Color.WHITE);
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(getText());
        int textHeight = fm.getAscent();
        g2.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - 4);

        g2.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(150, 40);  // Set the same preferred size for all buttons
    }
}

// Represents a user in the game
class User {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
