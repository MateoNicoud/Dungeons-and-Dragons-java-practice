public class WoodStick extends OffensiveEquipment{
    private final int attackPower;
    public WoodStick(){
        super("WoodStick");
        this.attackPower = 3;
    }
    public int getAttackPower(){
        return attackPower;
    }
}
