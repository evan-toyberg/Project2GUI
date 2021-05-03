/**
 * Special character snake pack
 */

public class Snakes extends People {

    /**
     * Constructor
     * @param nation name
     * @param tribe name
     * @param lifePoints of nation
     */
    Snakes(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.SpecialEncounter, lifePoints);
        myDescription = "\tPack of Snakes";
    }

    /**
     * Encounter strategy for snake
     * @param otherPerson
     * Reference to opponent
     * @return life points
     */
    public int encounterStrategy(People otherPerson) {

        if (otherPerson.getNation() != this.getNation()) // if the otherPerson isn't another special encounter
        {

            return 5;
        }

        return 0; // if otherPerson is another special encounter, do nothing
    }
}
