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
    private Hero character;
    public List<Items> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id = System.identityHashCode(this);
    public MysteryBox(){
        items=new ArrayList<>();
    }
    public void addItems(Items item){
        this.items.add(item);
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
        character.addToInventory(randomItem);

        Menu menu = new Menu();
        menu.printMysteryBox(randomItem);
        randomItem.equipHero(character);
        menu.printEquipHero(character, randomItem);
        character.setAttackPower(character.getBaseAttackPower() + character.getOffensiveEquipment().getAttackPower());

    }

    @Override
    public Hero getCharacter() {
        return this.character;
    }

    @Override public void setCharacter(Hero character){
        this.character = character;
    }
}
