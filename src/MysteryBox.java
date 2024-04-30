import Stuff.DefensiveEquipement.ArcaneShield;
import Stuff.DefensiveEquipement.PaperCraftShield;
import Stuff.Items;
import Stuff.OffensiveEquipement.FoamSword;
import Stuff.OffensiveEquipement.WoodStick;
import java.util.*;

public class MysteryBox {
    public List<Items> items;
    public MysteryBox(){
        items=new ArrayList<>();
        items.add(new WoodStick());
        items.add(new PaperCraftShield());
        items.add(new FoamSword());
        items.add(new ArcaneShield());
    }

    public Items getRandomItem(){
        int max = items.size();
        int randomNumber = (int) (Math.random()*max);
        return items.get(randomNumber);
    }
}
