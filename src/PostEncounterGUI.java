import javax.swing.*;
import java.util.Random;

public class PostEncounterGUI {

    private JPanel outcomePanel;
    private JButton exitButton;
    private JList<String> player1Stats;
    private JList<String> player2Stats;
    private JLabel p1DamageTaken;
    private JLabel p2DamageTaken;

    private People player2;
    private People player1;

    public PostEncounterGUI(People player1, People player2) {
        JFrame frame = new JFrame("Outcome");
        frame.setContentPane(outcomePanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true);

        this.player1 = player1;
        this.player2 = player2;

        exitButton.addActionListener(e -> frame.dispose());

        // this manually sets lifepoints for players FOR THE PURPOSE OF THE DEMO
        // TODO before implementing into project, this will need to be changed
        int p1DamageTaken = random(player1) / 2;
        int p2DamageTaken = random(player2) / 2;

        player1.setLifePoints(player1.getLifePoints() - p1DamageTaken);
        player2.setLifePoints(player2.getLifePoints() - p2DamageTaken);

        player1Stats.setListData(player1.getData());
        player2Stats.setListData(player2.getData());

        this.p1DamageTaken.setText(player1.getNation() + " " + player1.getType() + " Took " + p1DamageTaken + " Damage");
        this.p2DamageTaken.setText(player2.getNation() + " " +  player2.getType() + " Took " + p2DamageTaken + " Damage");

    }

    Random rand = new Random();
    public int random(People player) {
        return rand.nextInt(player.getLifePoints());
    }


}
