public class Wizard extends Character {

    public Wizard(String name, String job, boolean secondaryHand) {
        super(name,job, secondaryHand);
        int baseHealth = 6;
        int baseAttackPower = 15;
        int baseDefense = 0;
        this.job = job;
        this.OffensiveEquipment = new WoodStick();
        if (secondaryHand) {
            this.DefensiveEquipment = new BottleOfWater();
        }
        assert this.OffensiveEquipment != null : "L'équipement offensif ne doit pas être null";
        this.health = baseHealth;
        this.attackPower = baseAttackPower+this.OffensiveEquipment.getAttackPower();
        if (secondaryHand) {
            this.defensePower = baseDefense + this.DefensiveEquipment.getDefensePower();
        }
    }
}