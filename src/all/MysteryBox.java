package all;

import all.Stuff.DefensiveEquipement.ArcaneShield;
import all.Stuff.DefensiveEquipement.PaperCraftShield;
import all.Stuff.Items;
import all.Stuff.OffensiveEquipement.FoamSword;
import all.Stuff.OffensiveEquipement.WoodStick;
import all.board.Box;
import all.hero.Hero;

import java.util.*;

public class MysteryBox implements Box {
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
    public Items getItem(Items item){
        return items.get(items.indexOf(item));
    }

    @Override
    public void interaction(Hero character, Board board) {
        Items randomItem = getRandomItem();
        randomItem.equipHero(character);
    }
}
