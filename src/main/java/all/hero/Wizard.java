package all.hero;

import all.Stuff.DefensiveEquipement.ArcaneShield;
import all.Stuff.OffensiveEquipement.WoodStick;

public class Wizard extends Hero {

    public Wizard(String name, String job, boolean secondaryHand) {
        super(name, secondaryHand,15);
        int baseAttackPower = 15;
        int baseHealth = 600;
        int baseDefense = 0;
        this.setJob(job);
        this.setOffensiveEquipment(new WoodStick());
        if (secondaryHand) {
            this.setDefensiveEquipment(new ArcaneShield());
            this.addToInventory(this.getDefensiveEquipment());
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