import java.util.ArrayList;

/**
 * Add the different types of special characters into 3 tribes.
 */

public class BuildSpecialEncounters implements AddPlayers {
    /**
     * Adds the different types of characters
     * @param members array list of members
     * @param nationName nation name
     * @param tribeName tribe name
     * @param tribeLifePoints tribes life points
     */
    @Override
    public void add(ArrayList<People> members, String nationName, String tribeName, int tribeLifePoints)
    {
        if(tribeName.equals("Animals"))
        {
            members.add(new Snakes(nationName, tribeName, 2));
            members.add(new Wolf(nationName,tribeName,2));
        }
        if(tribeName.equals("Traps"))
        {
            members.add(new Plague(nationName, tribeName, 2));
            members.add(new FireTrap(nationName,tribeName,2));
        }
        if(tribeName.equals("Character"))
        {
            members.add(new Warchief(nationName, tribeName, 2));
            members.add(new Merchant(nationName,tribeName,2));
            members.add(new Gandalf(nationName, tribeName, 2));
            members.add(new FireKeeper(nationName, tribeName, 2));

        }
    }
}
