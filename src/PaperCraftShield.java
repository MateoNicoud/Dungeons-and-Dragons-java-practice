public class PaperCraftShield extends DefensiveEquipment {
    private final int defensePower;

    public PaperCraftShield() {
        super("PaperCraftShield");
        this.defensePower = 1;
    }

    public int getDefensePower() {
        return defensePower;
    }

}