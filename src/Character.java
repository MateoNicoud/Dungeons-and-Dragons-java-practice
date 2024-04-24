public class Character {


    private final String name;
    private final String job;
    private boolean secondaryHand;
    public int health;
    public int attackPower;
    public OffensiveEquipment OffensiveEquipment;
    public DefensiveEquipment DefensiveEquipment;

    public Character(String name, String job, boolean secondaryHand) {
        this.name = name;
        this.job = job;
        if (job.equals("guerrier")) {
            this.health = 10;
            this.attackPower = 10;
            this.OffensiveEquipment = new FoamSword();
            if (secondaryHand) {
                this.DefensiveEquipment = new PaperCraftShield();
            }
        } else if (job.equals("magicien")) {
            this.health = 6;
            this.attackPower = 15;
            this.OffensiveEquipment = new WoodStick();
            if (secondaryHand) {
                this.DefensiveEquipment = new BottleOfWater();
            }
        }
        this.secondaryHand = secondaryHand;
    }


    public void displayCharacter() {
        System.out.println("Voici un résumé de votre personnage:");
        System.out.println("Nom: " + name);
        System.out.println("Job: " + job);
        System.out.println("Santé: " + health);
        System.out.println("Puissance d'attaque: " + attackPower);
        System.out.println("Equipement offensif: " + OffensiveEquipment);
        System.out.println("Equipement défensif: " + DefensiveEquipment);
    }
}
