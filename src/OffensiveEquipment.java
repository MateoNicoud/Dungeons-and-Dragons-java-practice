public abstract class OffensiveEquipment {
    private final String name;
    private final int attackPower;

    public OffensiveEquipment(String name, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
    }

    @Override
    public String toString() {
        return name;
    }


    public int getAttackPower(){
        return attackPower;
    }

}