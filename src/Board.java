import Character.Character;
import Ennemies.*;
import Ennemies.Sorcerer;
import Stuff.Consumables.greatPotion;
import Stuff.Consumables.standardPotion;
import Stuff.Items;
import Stuff.OffensiveEquipement.*;
import Character.Warrior;
import Character.Wizard;
import Stuff.OffensiveEquipment;

import java.util.ArrayList;


public class Board {
    private final ArrayList<Box> boxes;

    public Board() {
        boxes = new ArrayList<Box>();
        for (int i = 0; i < 64; i++) {
            Box box = new DefaultBox(i + 1);
            boxes.add(box);
        }
    }

    public void addBox(Box box) {
        boxes.add(box);
    }

    public Box getBox(int index) {
        return this.boxes.get(index);
    }

    public int getBoardSize() {
        return this.boxes.size();
    }
private void placeItemInRandomBox(MysteryBox mysteryBox) {
    int random = (int) (Math.random() * boxes.size());
    boolean boxEmpty = false;
    while (!boxEmpty) {
        if (this.boxes.get(random).getMysteryBox() == null && (this.boxes.get(random).getEnnemies() == null) && ((this.boxes.get(random).getCharacter() == null))) {
            this.boxes.get(random).setMysteryBox(mysteryBox);
            boxEmpty = true;
        } else {
            random = (int) (Math.random() * boxes.size());
        }
    }
}

    public void placeMysteryBox() {
        for (int i = 0; i < 5; i++) {
            MysteryBox mysteryBox = new MysteryBox();
            mysteryBox.items.clear();
            mysteryBox.items.add(new ExcaliburSword());
            placeItemInRandomBox(mysteryBox);
        }
        for (int i = 0; i < 4; i++) {
            MysteryBox mysteryBox = new MysteryBox();
            mysteryBox.items.clear();
            mysteryBox.items.add(new FoamSword());
            placeItemInRandomBox(mysteryBox);
        }
        for (int i = 0; i < 5; i++) {
            MysteryBox mysteryBox = new MysteryBox();
            mysteryBox.items.clear();
            mysteryBox.items.add(new WoodStick());
            placeItemInRandomBox(mysteryBox);
        }
        for (int i = 0; i < 5; i++) {
            MysteryBox mysteryBox = new MysteryBox();
            mysteryBox.items.clear();
            mysteryBox.items.add(new EldritchStaff());
            placeItemInRandomBox(mysteryBox);
        }
        for (int i = 0; i < 2; i++) {
            MysteryBox mysteryBox = new MysteryBox();
            mysteryBox.items.clear();
            mysteryBox.items.add(new greatPotion());
            placeItemInRandomBox(mysteryBox);
        }
        for (int i = 0; i < 6; i++) {
            MysteryBox mysteryBox = new MysteryBox();
            mysteryBox.items.clear();
            mysteryBox.items.add(new standardPotion());
            placeItemInRandomBox(mysteryBox);
        }
    }

    public void placeEnnemies() {
        for (int i = 0; i < 4; i++) {
            Ennemies ennemie = new Dragon();
            int random = (int) (Math.random() * boxes.size());
            boolean boxEmpty = false;
            while (!boxEmpty) {
                if (this.boxes.get(random).getMysteryBox() == null && (this.boxes.get(random).getEnnemies() == null) && ((this.boxes.get(random).getCharacter() == null))) {
                    this.boxes.get(random).setEnnemies(ennemie);
                    boxEmpty = true;
                } else {
                    random = (int) (Math.random() * boxes.size());
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            Ennemies ennemie = new Sorcerer();
            int random = (int) (Math.random() * boxes.size());
            boolean boxEmpty = false;
            while (!boxEmpty) {
                if (this.boxes.get(random).getMysteryBox() == null && (this.boxes.get(random).getEnnemies() == null) && ((this.boxes.get(random).getCharacter() == null))) {
                    this.boxes.get(random).setEnnemies(ennemie);
                    boxEmpty = true;
                } else {
                    random = (int) (Math.random() * boxes.size());
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            Ennemies ennemie = new Goblin();
            int random = (int) (Math.random() * boxes.size());
            boolean boxEmpty = false;
            while (!boxEmpty) {
                if (this.boxes.get(random).getMysteryBox() == null && (this.boxes.get(random).getEnnemies() == null) && ((this.boxes.get(random).getCharacter() == null))) {
                    this.boxes.get(random).setEnnemies(ennemie);
                    boxEmpty = true;
                } else {
                    random = (int) (Math.random() * boxes.size());
                }
            }
        }
    }


    public int getBoxOfCharacter(Character character) {
        for (int i = 0; i < this.boxes.size(); i++) {
            if (this.boxes.get(i).getCharacter() == character) {
                return i;
            }
        }
        return -1;
    }

    public void moveCharacter(Character character, int steps) {
        int currentBoxIndex = getBoxOfCharacter(character);
        if (currentBoxIndex != -1) {
            int newBoxIndex = currentBoxIndex + steps;
            if (newBoxIndex >=boxes.size()){
                newBoxIndex=boxes.size()-1;
            }
            if (newBoxIndex == this.boxes.size() - 1) {
                System.out.println(character.getName() + " a terminé le donjon");
            }
            if (currentBoxIndex <= this.boxes.size()) {
                boxes.get(currentBoxIndex).setCharacter(null);
                boxes.get(newBoxIndex).setCharacter(character);
                if (boxes.get(currentBoxIndex).getMysteryBox() != null) {
                    Items Item = boxes.get(currentBoxIndex).getMysteryBox().getRandomItem();
                    character.addToInventory(Item);
                    System.out.println("Il y a une boite mystère contenant :" + Item);
                    if(Item.getType().equals("Épée") && character instanceof Warrior && character.getOffensiveEquipment().getAttackPower()<Item.getPower()){
                     character.setOffensiveEquipment((OffensiveEquipment) Item);
                     character.setAttackPower(character.getBaseAttackPower()+character.getOffensiveEquipment().getAttackPower());
                     System.out.println("Vous aves maintenat "+Item+" équipée");
                    }
                    if(Item.getType().equals("Catalyseur") && character instanceof Wizard && character.getOffensiveEquipment().getAttackPower()<Item.getPower()){
                        character.setOffensiveEquipment((OffensiveEquipment) Item);
                        character.setAttackPower(character.getBaseAttackPower()+character.getOffensiveEquipment().getAttackPower());

                        System.out.println("Vous aves maintenat "+Item+" équipée");
                    }
                    if (Item.getType().equals("Potion")){
                        character.setHealth(character.getHealth()+Item.getPower());
                        System.out.println("Votre personnage à gagné "+Item.getPower()+"hp");
                    }
//                    character.displayInventory();
                }
                if (boxes.get(currentBoxIndex).getEnnemies() != null) {
                    Menu menu = new Menu();
                    System.out.println("Il y a un " + boxes.get(currentBoxIndex).getEnnemies().getName() + " Sur cette case");
                    boolean userChoice = menu.fightOrFlee();
                    if (!userChoice){
                        System.out.println("Le "+boxes.get(currentBoxIndex).getEnnemies().getName()+" vas vous attaquer pendant votre fuite");
                        int damage = boxes.get(currentBoxIndex).getEnnemies().getAttackPower() - character.getDefensePower();
                        if (damage < 0) {
                            damage = 0;
                        }
                        character.setHealth(character.getHealth() - damage);
                        System.out.println("il vous reste "+character.getHealth()+" HP");
                        if (character.getHealth() <=0){
                            System.out.println("Il vous as tuer, Game Over");
                            System.exit(0);
                        }else {
                            System.out.println("Vous avez fuis comme un lâche");
                            int random = (int)(Math.random()*6);
                            System.out.println("Vous reculer de "+random+" case(s)");
                            newBoxIndex=currentBoxIndex-(random);
                            boxes.get(currentBoxIndex).setCharacter(null);
                            boxes.get(newBoxIndex).setCharacter(character);
                        }
                    } else {
                        while (character.getHealth() > 0 && boxes.get(currentBoxIndex).getEnnemies().getHealth() >0){
                            System.out.println(character.getName()+" attaque et inflige "+character.getAttackPower()+ "de dégats à "
                                    +boxes.get(currentBoxIndex).getEnnemies().getName() );
                            boxes.get(currentBoxIndex).getEnnemies().setHealth(boxes.get(currentBoxIndex).getEnnemies().getHealth() - character.getAttackPower());
                            if (boxes.get(currentBoxIndex).getEnnemies().getHealth() <= 0){
                                System.out.println("Le "+boxes.get(currentBoxIndex).getEnnemies().getName()+" est mort");
                            } else {
                                System.out.println("Le "+boxes.get(currentBoxIndex).getEnnemies().getName()+" vous attaque");
                                int damage = boxes.get(currentBoxIndex).getEnnemies().getAttackPower() - character.getDefensePower();
                                if (damage < 0) {
                                    damage = 0;
                                }
                                character.setHealth(character.getHealth() - damage);                                System.out.println("il vous reste "+character.getHealth()+" HP");
                                if (character.getHealth() <=0) {
                                    System.out.println("Il vous as tuer, Game Over");
                                    System.exit(0);
                                }

                            }
                        }
                    }
                }
                if (this.boxes.size() < currentBoxIndex) {
                    System.out.println("avancement :" + (currentBoxIndex + 1));
                }
            }

        }

    }
}