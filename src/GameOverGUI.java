import javax.swing.*;
import java.util.Set;

public class GameOverGUI {

    private JPanel gameOverPanel;
    private JLabel gameOverText;

    public GameOverGUI(Set<String> nations) {
        JFrame frame = new JFrame("GameOver");
        frame.setContentPane(gameOverPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);
        //gameOverText.setText("Game Over");
        gameOverText.setSize(200, 300);

        if(nations.size() == 0)
        {
            gameOverText.setText("Game Over: No surviving nation");
        }
        else
        {
            for(String nation : nations)
            {
                gameOverText.setText("Game Over: " + nation + " won");
            }
        }

    }
}
