package Character;

import Stuff.BottleOfWater;
import Stuff.WoodStick;

public class Wizard extends Character {

    public Wizard(String name, String job, boolean secondaryHand) {
        super(name, secondaryHand);
        int baseHealth = 6;
        int baseAttackPower = 15;
        int baseDefense = 0;
        this.setJob(job);
        this.setOffensiveEquipment(new WoodStick());
        if (secondaryHand) {
            this.setDefensiveEquipment(new BottleOfWater());
        }
        assert this.getOffensiveEquipment() != null : "L'équipement offensif ne doit pas être null";
        this.setHealth(baseHealth);
        this.setAttackPower(baseAttackPower + this.getOffensiveEquipment().getAttackPower());
        if (secondaryHand) {
            this.setDefensePower(baseDefense + this.getDefensiveEquipment().getDefensePower());
        }
    }
}