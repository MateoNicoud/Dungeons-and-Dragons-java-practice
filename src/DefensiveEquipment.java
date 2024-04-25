public abstract class DefensiveEquipment {
    private final String name;
    private final int defensePower;

    public DefensiveEquipment(String name, int defensePower) {
        this.name = name;
        this.defensePower = defensePower;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getDefensePower(){
        return defensePower;
    }

}

