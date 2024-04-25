public class Warrior extends Character {



    public Warrior(String name, String job, boolean secondaryHand){
        super(name,job,secondaryHand);
        int baseHealth = 10;
        int baseAttackPower = 10;
        int baseDefensePower = 10;
        this.job = job;
        this.OffensiveEquipment = new FoamSword();
        if (secondaryHand) {
            this.DefensiveEquipment = new PaperCraftShield();
        }
        assert this.OffensiveEquipment != null : "L'équipement offensif ne doit pas être null";
        this.attackPower = baseAttackPower+this.OffensiveEquipment.getAttackPower();
        this.defensePower = baseDefensePower+this.DefensiveEquipment.getDefensePower();
    }
}
