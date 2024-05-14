package all.Stuff;

public abstract class OffensiveEquipment extends Items {
    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    private int attackPower;

    public OffensiveEquipment(String type, String name, int attackPower) {
        super(type,name,attackPower);
        this.attackPower = attackPower;
    }

}