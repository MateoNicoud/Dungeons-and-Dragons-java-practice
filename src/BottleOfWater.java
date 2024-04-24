public class BottleOfWater extends DefensiveEquipment {
    private int healthRestored;

    public BottleOfWater() {
        super("BottleOfWater");
        this.healthRestored = 1;
    }

    public int getHealthRestored() {
        return healthRestored;
    }
}
