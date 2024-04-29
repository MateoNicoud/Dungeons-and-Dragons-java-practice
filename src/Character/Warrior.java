package Character;

import Stuff.OffensiveEquipement.FoamSword;
import Stuff.DefensiveEquipement.PaperCraftShield;

public class Warrior extends Character {


    public Warrior(String name, String job, boolean secondaryHand) {
        super(name, secondaryHand);
        int baseHealth = 10;
        int baseAttackPower = 10;
        int baseDefensePower = 10;
        this.setJob(job);
        this.setOffensiveEquipment(new FoamSword());
        this.addToInventory(this.getOffensiveEquipment());
        if (secondaryHand) {
            this.setDefensiveEquipment(new PaperCraftShield());
        }
        this.addToInventory(this.getDefensiveEquipment());
        assert this.getOffensiveEquipment() != null : "L'équipement offensif ne doit pas être null";
        this.setAttackPower(baseAttackPower + this.getOffensiveEquipment().getAttackPower());
        this.setHealth(baseHealth);
        if (secondaryHand) {
            this.setDefensePower(baseDefensePower + this.getDefensiveEquipment().getDefensePower());
        }

        this.displayInventory();
    }
}
