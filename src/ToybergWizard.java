public class ToybergWizard extends People {

    ToybergWizard(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tToyberg Wizard";
    }

    /**
     * This wizard has offensive abilities as well as healing abilities
     * Can very effectively heal warriors or wizards
     *
     * Will not fight a warrior if the warrior has greater health
     *
     */
    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()){
            if (otherPerson.getLifePoints() < this.getLifePoints()){
                if (otherPerson.getType() == PeopleType.warrior){ // run away
                    lifePoints = -this.getLifePoints();
                }
                else{ // attack a wizard or healer
                    lifePoints = this.getLifePoints();
                }
            }
        }
        else
        {
            if(otherPerson.getType().equals(PeopleType.wizard) || otherPerson.getType().equals(PeopleType.warrior)){
                lifePoints = -this.MAX_LIFEPOINTS;
            }
            else{
                lifePoints = 0;
            }
        }
        return lifePoints;
    }

}
