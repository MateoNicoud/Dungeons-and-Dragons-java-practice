public class FoamSword extends OffensiveEquipment {
    private final int attackPower;

    public FoamSword(){
        super("FoamSword");
        this.attackPower = 5;
    }
    public int getAttackPower(){
        return attackPower;
    }
}
