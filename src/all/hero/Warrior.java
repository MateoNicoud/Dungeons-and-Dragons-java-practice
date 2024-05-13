package all.hero;

import all.Stuff.OffensiveEquipement.FoamSword;
import all.Stuff.DefensiveEquipement.PaperCraftShield;

public class Warrior extends Hero {


    public Warrior(String name, String job, boolean secondaryHand) {
        int baseAttackPower = 10;
        super(name, secondaryHand,baseAttackPower);
        int baseHealth = 1000;
        int baseDefensePower = 10;
        this.setJob(job);
        this.setOffensiveEquipment(new FoamSword());
        this.addToInventory(this.getOffensiveEquipment());
        if (secondaryHand) {
            this.setDefensiveEquipment(new PaperCraftShield());
            this.addToInventory(this.getDefensiveEquipment());
        }
        assert this.getOffensiveEquipment() != null : "L'équipement offensif ne doit pas être null";
        this.setAttackPower(baseAttackPower + this.getOffensiveEquipment().getAttackPower());
        this.setHealth(baseHealth);
        if (secondaryHand) {
            this.setDefensePower(baseDefensePower + this.getDefensiveEquipment().getDefensePower());
        }

        this.displayInventory();
    }
}
