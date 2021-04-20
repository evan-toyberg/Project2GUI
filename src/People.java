public class People {
    private String nation, type, tribe;
    private int lifePoints;

    public People(String nation, String tribe, String playerType) {
        this.lifePoints = 100;
        this.nation = nation;
        this.type = playerType;
        this.tribe = tribe;
        getData();
    }

    public String[] getData() {
        String[] data;
        return data = new String[]{String.valueOf(lifePoints), nation, tribe, type};
    }


    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNation() {
        return nation;
    }

    public String getType() {
        return type;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }
}
