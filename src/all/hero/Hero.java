package all.hero;

import all.Stuff.DefensiveEquipment;
import all.Stuff.Items;
import all.Stuff.OffensiveEquipment;

public abstract class Hero {


    private final String name;
    private String job;
    private final Inventory inventory;


    private final boolean secondaryHand;
    private int health = 0;
    private int attackPower = 0;
    private int defensePower = 0;
    private all.Stuff.OffensiveEquipment OffensiveEquipment;
    private all.Stuff.DefensiveEquipment DefensiveEquipment;

    public int getBaseAttackPower() {
        return baseAttackPower;
    }


    private final int baseAttackPower;

    public Hero(String name, boolean secondaryHand, int baseAttackPower) {
        this.name = name;
        this.secondaryHand = secondaryHand;
        this.inventory = new Inventory();
        this.baseAttackPower=baseAttackPower;
    }
    public void addToInventory(Items item){
        this.inventory.addItems(item);
    }
    public void displayInventory(){
        this.inventory.displayInventory();
    }


    public void displayCharacter() {
        System.out.println("Voici un résumé de votre personnage:");
        System.out.println("Nom: " + name);
        System.out.println("Job: " + job);
        System.out.println("Santé: " + health);
        System.out.println("Défense: " + defensePower);
        System.out.println("Puissance d'attaque: " + attackPower);
        System.out.println("Equipement offensif: " + OffensiveEquipment);
        if (DefensiveEquipment != null) {
            System.out.println("Equipement défensif: " + DefensiveEquipment);
        }
    }

    public boolean getIsSecondaryHand() {
        return secondaryHand;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean isSecondaryHand() {
        return secondaryHand;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return OffensiveEquipment;
    }

    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        OffensiveEquipment = offensiveEquipment;
    }

    public DefensiveEquipment getDefensiveEquipment() {
        return DefensiveEquipment;
    }

    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        DefensiveEquipment = defensiveEquipment;
    }
}
