public class SmilonsHealer2 extends People{
    SmilonsHealer2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tSmilons Wizard2";
    }
    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation())
        {
            if (otherPerson.getLifePoints() < this.getLifePoints())
            {
                if (otherPerson.getType() == PeopleType.warrior) // run away
                {
                    lifePoints = -this.getLifePoints();
                }
                else // attack a wizard or healer but not with a lot of lifepoints
                {
                    lifePoints = (int) (this.getLifePoints()/4);
                }
            }
        }
        else
        {
            if (otherPerson.getLifePoints() < this.getLifePoints()) // heal a friend
            {
                lifePoints = (int) -(this.getLifePoints() / 3);
            }
            else
            {
                lifePoints = 0;
            }
        }
        return lifePoints;
    }

}


