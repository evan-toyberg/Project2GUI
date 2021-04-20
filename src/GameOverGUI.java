import javax.swing.*;

public class GameOverGUI {

    private JPanel gameOverPanel;
    private JLabel gameOverText;

    public GameOverGUI() {
        JFrame frame = new JFrame("GameOver");
        frame.setContentPane(gameOverPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
        gameOverText.setText("Game Over");
        gameOverText.setSize(200, 300);
    }
}
