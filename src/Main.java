import java.util.ArrayList;

public class Main {
    private static ArrayList<People> combatants;
    private static int combatantIndex = 0;
    private static WarringNationsGUI gui = new WarringNationsGUI();


    public static void main(String[] args) {
        combatants = new ArrayList<>();
        // adding pairs of combatants
        combatants.add(new People("Nation1", "Tribe1", WarringNationsGUI.HEALER));
        combatants.add(new People("Nation2", "Tribe3", WarringNationsGUI.WARRIOR));

        combatants.add(new People("Nation2", "Tribe4", WarringNationsGUI.WIZARD));
        combatants.add(new People("Nation3", "Tribe1", WarringNationsGUI.HEALER));

        combatants.add(new People("Nation3", "Tribe2", WarringNationsGUI.SPECIAL));
        combatants.add(new People("Nation5", "Tribe3", WarringNationsGUI.WARRIOR));

        combatants.add(new People("Nation1", "Tribe4", WarringNationsGUI.WARRIOR));
        combatants.add(new People("Nation4", "Tribe2", WarringNationsGUI.WARRIOR));

        combatants.add(new People("Nation2", "Tribe2", WarringNationsGUI.SPECIAL));
        combatants.add(new People("Nation3", "Tribe2", WarringNationsGUI.SPECIAL));

        nextPlayers();
    }

    public static void nextPlayers() {
        if(combatantIndex < combatants.size() -1){ // should be if (!isGameOver)
            gui.update(combatants.get(combatantIndex), combatants.get(combatantIndex + 1));
            combatantIndex = combatantIndex + 2;

        } else{
            new GameOverGUI();
        }
    }

}
