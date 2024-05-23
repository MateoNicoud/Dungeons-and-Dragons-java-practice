package all.Stuff.OffensiveEquipement;
import all.Stuff.OffensiveEquipment;
import all.hero.Hero;
import all.hero.Warrior;

public class ExcaliburSword extends OffensiveEquipment {
    public ExcaliburSword(){
        super("Épée","Excalibur",20);
    }

    @Override
    public void equipHero(Hero character) {
        if (character instanceof Warrior) {
            character.setOffensiveEquipment(this);
        }
    }
}
