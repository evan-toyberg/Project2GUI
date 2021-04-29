public class PerezWarrior extends People
{
    PerezWarrior(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tPerez Warrior";
    }

    /**
     *
     * @param otherPerson
     * Reference to opponent
     * @return
     * Small heal for allies from the same tribe, else ignores them
     *
     * Does more damage when at lower health then opponent
     */
    public int encounterStrategy(People otherPerson)
    {
        int lifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation())) // from the same nation
        {
            if (otherPerson.getTribe().equals(this.getTribe())) // small heal for other tribe members, else ignore them
            {
                if (otherPerson.getLifePoints() < this.getLifePoints())
                    lifePoints = -(this.getLifePoints() / 6);
            }
        }

        else
        {
            int points;
            points = this.getLifePoints() - otherPerson.getLifePoints();
            if (points > 0) // more health then opponent, normal damage
            {
                lifePoints = (this.getLifePoints()/4);
            }
            else // less health then opponent, do more damage
            {
                lifePoints = (int) (this.getLifePoints() /3);
            }
        }
        return lifePoints;
    }

}
