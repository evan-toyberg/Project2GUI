/**
 * Special character Warchief
 */
public class Warchief extends People {

    /**
     * Constructor
     * @param nation name
     * @param tribe name
     * @param lifePoints of nation
     */
    Warchief(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.SpecialEncounter, lifePoints);
        myDescription = "\tWarchief";
    }

    /**
     * Encounter strategy for Warchief
     * @param otherPerson Reference to opponent
     * @return life points
     */
    public int encounterStrategy(People otherPerson) {

        if (otherPerson.getNation() != this.getNation()) // if the otherPerson isn't another special encounter
        {
            if (otherPerson.getType().equals(PeopleType.warrior)) // if otherPerson is a warrior
            {

                return -10;
            }
        }

        return 0; // if otherPerson is another special encounter, do nothing
    }
}
