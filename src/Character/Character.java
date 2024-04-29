package Character;

import Stuff.DefensiveEquipment;
import Stuff.OffensiveEquipment;

public abstract class Character {


    private final String name;
    private String job;


    private final boolean secondaryHand;
    private int health = 0;
    private int attackPower = 0;
    private int defensePower = 0;
    private Stuff.OffensiveEquipment OffensiveEquipment;
    private Stuff.DefensiveEquipment DefensiveEquipment;

    public Character(String name, boolean secondaryHand) {
        this.name = name;
        this.secondaryHand = secondaryHand;
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
