package Character;

import Stuff.DefensiveEquipement.ArcaneShield;
import Stuff.OffensiveEquipement.WoodStick;

public class Wizard extends Character {

    public Wizard(String name, String job, boolean secondaryHand) {
        int baseAttackPower = 15;
        super(name, secondaryHand,baseAttackPower);
        int baseHealth = 600;
        int baseDefense = 0;
        this.setJob(job);
        this.setOffensiveEquipment(new WoodStick());
        if (secondaryHand) {
            this.setDefensiveEquipment(new ArcaneShield());
        }
        assert this.getOffensiveEquipment() != null : "L'équipement offensif ne doit pas être null";
        this.setHealth(baseHealth);
        this.setAttackPower(baseAttackPower + this.getOffensiveEquipment().getAttackPower());
        if (secondaryHand) {
            this.setDefensePower(baseDefense + this.getDefensiveEquipment().getDefensePower());
        }
        this.displayInventory();
    }
}