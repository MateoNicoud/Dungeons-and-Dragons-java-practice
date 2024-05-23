package all.Stuff;

public abstract class DefensiveEquipment extends Items {
    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    private int defensePower;
    public DefensiveEquipment(String type, String name, int defensePower) {
        super(type,name,defensePower);
        this.defensePower = defensePower;
    }

}

