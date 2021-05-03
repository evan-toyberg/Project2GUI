import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class WarringNationsGUI extends Thread{
    private JButton rollDiceButton;
    private JButton continueButton;
    private JPanel panel1;
    private JList player1Stats;
    private JList player2Stats;
    private JLabel player1Image;
    private JLabel player2Image;
    private JLabel nation1Text;
    private JLabel nation2Text;
    private JLabel vs;
    private JLabel p1DamageTakenLabel;
    private JLabel p2DamageTakenLabel;


    // simulate PlayerType enum
    public final static String WIZARD = "Wizard";
    public final static String WARRIOR = "Warrior";
    public final static String HEALER = "Healer";
    public final static String SPECIAL = "Special";
    private People player1;
    private People player2;
    private World world;

    public WarringNationsGUI()
    {
        JFrame frame = new JFrame("Warring Nations");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);
        frame.setVisible(true);
    }


    /**
     * Returns the jlabel of player1 damage
     * @return p1DamageTakenLabel : JLabel
     */
    public JLabel getP1DamageTakenLabel()
    {
        return this.p1DamageTakenLabel;
    }

    /**
     * Returns the jlabel of player2 damage
     * @return p2DamageTakenLabel : JLabel
     */
    public JLabel getP2DamageTakenLabel()
    {
        return this.p2DamageTakenLabel;
    }

    /**
     * Returns the jbutton of roll dice
     * @return rollDiceButton : JButton
     */
    public JButton getRollDiceButton()
    {
        return this.rollDiceButton;
    }

    /**
     * Returns the jbutton of continue
     * @return continueButton : JButton
     */
    public JButton getContinueButton()
    {
        return this.continueButton;
    }

    /**
     * This method will update the GUI based on the current encounter.
     * Updates all values to reflect current players and their values.
     *
     * Can be called once at the beginning of the encounter and maybe after the roll to show updated health values??
     * Might also want to use instance of People so we can pass
     */
    public void update(People player1, People player2) throws NullPointerException
    {
        this.player1 = player1;
        this.player2 = player2;
        setPlayerImage(player1Image, player1.getType(), player1);
        setPlayerImage(player2Image, player2.getType(), player2);

        // show player stats in JList
        player1Stats.setListData(player1.getData());
        player2Stats.setListData(player2.getData());

        nation1Text.setText(player1.getNation() + " " + player1.getType());
        nation2Text.setText(player2.getNation() + " " + player2.getType());

        rollDiceButton.addActionListener(e -> {
            postEncounter(player1, player2);
            rollDiceButton.setEnabled(false);
            continueButton.setEnabled(true);
            world.combatantIndex = world.combatantIndex + 2;
        });
        ContinueButton();
    }

    /**
     * After the encounter set the players data to the new data
     * @param player1 in encounter
     * @param player2 in encounter
     */
    public void postEncounter(People player1, People player2)
    {

        player1Stats.setListData(player1.getData());
        player2Stats.setListData(player2.getData());
    }

    /**
     * Cotinue button that changes the permissions of the buttons
     */
    public void ContinueButton()
    {
        continueButton.addActionListener(e -> {
            rollDiceButton.setEnabled(true);
            continueButton.setEnabled(false);
            //world.combatantIndex = world.combatantIndex + 2;
        });
    }


    /**
     * TODO : This needs to be changed from int playerType to a WarringNations.PlayerType when game is imported
     * This will set the player's image. It is set based on the player's class type (Warrior, Wizard, Healer)
     * and this will automatically resize the image to the correct size for the GUI
     * @param playerImage
     * @param playerType
     */
    public void setPlayerImage(JLabel playerImage, PeopleType playerType, People player){
        ImageIcon gif;
        Image image;
        switch(playerType) {
            case wizard:  // simulates a wizard
                gif = new ImageIcon(this.getClass().getResource("Images/wizard.gif"));
                playerImage.setIcon(gif);
                break;
            case warrior:  //simulate warrior
                gif= new ImageIcon(this.getClass().getResource("Images/warrior.gif"));
                playerImage.setIcon(gif);
                break;
            case healer:  //simulate healer
                image = new ImageIcon(this.getClass().getResource("Images/WarringNationsHealer.png"))
                        .getImage().getScaledInstance(400,300, Image.SCALE_SMOOTH);
                playerImage.setIcon(new ImageIcon(image));
                break;
            default: // random encounters
                if (player.myDescription.equals("Merchant"))
                {
                    gif= new ImageIcon(this.getClass().getResource("Images/merchant.gif"));
                    playerImage.setIcon(gif);
                    break;
                }
                if (player.myDescription.equals("\tPack of Snakes"))
                {
                    gif= new ImageIcon(this.getClass().getResource("Images/snake.gif"));
                    playerImage.setIcon(gif);
                    break;
                }
                if (player.myDescription.equals("Wolf"))
                {
                    gif= new ImageIcon(this.getClass().getResource("Images/wolf.gif"));
                    playerImage.setIcon(gif);
                    break;
                }
                if (player.myDescription.equals("Fire Trap"))
                {
                    gif= new ImageIcon(this.getClass().getResource("Images/fire.gif"));
                    playerImage.setIcon(gif);
                    break;
                }
                if (player.myDescription.equals("\tWarchief"))
                {
                    gif= new ImageIcon(this.getClass().getResource("Images/masterchief.gif"));
                    playerImage.setIcon(gif);
                    break;
                }
                if (player.myDescription.equals("\tGandalf"))
                {
                    gif= new ImageIcon(this.getClass().getResource("Images/gandalf.gif"));
                    playerImage.setIcon(gif);
                    break;
                }
                if (player.myDescription.equals("\tBlack Plague"))
                {
                    gif= new ImageIcon(this.getClass().getResource("Images/blackplague.gif"));
                    playerImage.setIcon(gif);
                    break;
                }
                if (player.myDescription.equals("\tFireKeeper"))
                {
                    gif= new ImageIcon(this.getClass().getResource("Images/firekeeper.gif"));
                    playerImage.setIcon(gif);
                    break;
                }
                else
                {
                    image = new ImageIcon(this.getClass().getResource("Images/WarringNationsRandomEncounter.png"))
                            .getImage().getScaledInstance(100,300, Image.SCALE_SMOOTH);
                    playerImage.setIcon(new ImageIcon(image));
                    break;
                }

        }

    }
}
