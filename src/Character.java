public abstract class Character {


    private final String name;
    public String job;
    public final boolean secondaryHand;
    public int health=0;
    public int attackPower =0;
    public int defensePower =0;
    public OffensiveEquipment OffensiveEquipment;
    public DefensiveEquipment DefensiveEquipment;

    public Character(String name,String job, boolean secondaryHand) {
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
        if(DefensiveEquipment!=null) {
            System.out.println("Equipement défensif: " + DefensiveEquipment);
        }
    }

    public boolean isSecondaryHand() {
        return secondaryHand;
    }
}
