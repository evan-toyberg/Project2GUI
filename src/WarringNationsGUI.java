import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WarringNationsGUI extends Thread {
    private JButton button;
    private JPanel panel1;
    private JList player1Stats;
    private JList player2Stats;
    private JLabel player1Image;
    private JLabel player2Image;
    private JLabel nation1Text;
    private JLabel nation2Text;
    private JLabel vs;

    // simulate PlayerType enum
    public final static String WIZARD = "Wizard";
    public final static String WARRIOR = "Warrior";
    public final static String HEALER = "Healer";
    public final static String SPECIAL = "Special";
    private People player1;
    private People player2;
    private World world;
    private ArrayList <People> survivors;


    public WarringNationsGUI()
    {
        JFrame frame = new JFrame("Warring Nations");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setVisible(true);
    }

    public JButton getButton()
    {
        return this.button;
    }

    /**
     * This method will update the GUI based on the current encounter.
     * Updates all values to reflect current players and their values.
     *
     * Can be called once at the beginning of the encounter and maybe after the roll to show updated health values??
     * Might also want to use instance of People so we can pass
     */


    public void update(People player1, People player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        setPlayerImage(player1Image, String.valueOf(player1.getType()));
        setPlayerImage(player2Image, String.valueOf(player2.getType()));

        // show player stats in JList
        player1Stats.setListData(player1.getData());
        player2Stats.setListData(player2.getData());


        nation1Text.setText(player1.getNation() + " " + player1.getType());
        nation2Text.setText(player2.getNation() + " " + player2.getType());
        button.addActionListener(e ->
        {
            new PostEncounterGUI(player1, player2);
            world.war();
        });
    }



    /**
     * TODO : This needs to be changed from int playerType to a WarringNations.PlayerType when game is imported
     * This will set the player's image. It is set based on the player's class type (Warrior, Wizard, Healer)
     * and this will automatically resize the image to the correct size for the GUI
     * @param playerImage
     * @param playerType
     */
    public void setPlayerImage(JLabel playerImage, String playerType){
        Image image;
        switch(playerType) {
            case WIZARD:  // simulates a wizard
                image = new ImageIcon(this.getClass().getResource("Images/WarringNationsWizard.jpg"))
                        .getImage().getScaledInstance(200,300, Image.SCALE_SMOOTH);
                break;
            case WARRIOR:  //simulate warrior
                image = new ImageIcon(this.getClass().getResource("Images/WarringNationsWarrior.jpg"))
                        .getImage().getScaledInstance(350,300, Image.SCALE_SMOOTH);
                break;
            case HEALER:  //simulate healer
                image = new ImageIcon(this.getClass().getResource("Images/WarringNationsHealer.png"))
                        .getImage().getScaledInstance(400,300, Image.SCALE_SMOOTH);
                break;
            default: // random encounters
                image = new ImageIcon(this.getClass().getResource("Images/WarringNationsRandomEncounter.png"))
                        .getImage().getScaledInstance(100,300, Image.SCALE_SMOOTH);
                break;
        }
        playerImage.setIcon(new ImageIcon(image));
    }
}
