public abstract class OffensiveEquipment {
    private final String name;
    private final int attackPower;
    private final String type;

    public OffensiveEquipment(String type, String name, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }


    public int getAttackPower() {
        return attackPower;
    }

    public String getType() {
        return type;
    }

}