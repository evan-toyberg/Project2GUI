public class Warchief extends People {

    Warchief(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.SpecialEncounter, lifePoints);
        myDescription = "\tWarchief";
    }

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
