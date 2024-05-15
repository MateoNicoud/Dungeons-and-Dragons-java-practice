package all;

import all.Ennemies.Dragon;
import all.Ennemies.Ennemies;
import all.Ennemies.Goblin;
import all.Stuff.OffensiveEquipement.EldritchStaff;
import all.Stuff.OffensiveEquipement.ExcaliburSword;
import all.Stuff.OffensiveEquipement.FoamSword;
import all.Stuff.OffensiveEquipement.WoodStick;
import all.board.Box;
import all.board.EmptyBox;
import all.hero.Hero;
import all.Ennemies.Sorcerer;
import all.Stuff.Consumables.GreatPotion;
import all.Stuff.Consumables.StandardPotion;
import all.Stuff.Items;
import all.hero.Warrior;
import all.hero.Wizard;
import all.Stuff.OffensiveEquipment;

import java.util.ArrayList;


public class Board {
    public int getNewBoxIndex() {
        return newBoxIndex;
    }

    public void setNewBoxIndex(int newBoxIndex) {
        this.newBoxIndex = newBoxIndex;
    }

    private int newBoxIndex;

    public int getCurrentBoxIndex() {
        return currentBoxIndex;
    }

    public void setCurrentBoxIndex(int currentBoxIndex) {
        this.currentBoxIndex = currentBoxIndex;
    }

    private int currentBoxIndex;

    private ArrayList<Box> boxes;

    public Board() {
        boardInit();
        placeEnnemies();
        placeMysteryBox();
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

    private void boardInit(){
        boxes = new ArrayList<Box>();
        for (int i = 0; i < 64; i++) {
            Box box = new EmptyBox();
            boxes.add(box);
        }
    }
    private void placeItemInRandomBox(MysteryBox mysteryBox) {
        boolean boxEmpty = false;
        int random = -1;

        while (!boxEmpty) {
            random = (int) (Math.random() * boxes.size());
            if (this.boxes.get(random) instanceof EmptyBox) {
                boxEmpty = true;
            }
        }

        this.boxes.set(random, mysteryBox);
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
            mysteryBox.items.add(new GreatPotion());
            placeItemInRandomBox(mysteryBox);
        }
        for (int i = 0; i < 6; i++) {
            MysteryBox mysteryBox = new MysteryBox();
            mysteryBox.items.clear();
            mysteryBox.items.add(new StandardPotion());
            placeItemInRandomBox(mysteryBox);
        }
    }

    public void placeEnnemies() {
        for (int i = 0; i < 4; i++) {
            Ennemies ennemie = new Dragon();
            int random = (int) (Math.random() * boxes.size()-1);
            this.boxes.set(random, ennemie);
//            new Random().nextInt(10, boxes.size());

//            boolean boxEmpty = false;
//            while (!boxEmpty) {
//                if (this.boxes.get(random).getMysteryBox() == null && (this.boxes.get(random).getEnnemies() == null) && ((this.boxes.get(random).getCharacter() == null))) {
//                    this.boxes.get(random).setEnnemies(ennemie);
//                    boxEmpty = true;
//                } else {
//                    random = (int) (Math.random() * boxes.size()-1);
//                }
//            }
        }
        for (int i = 0; i < 10; i++) {
            Ennemies ennemie = new Sorcerer();
            int random = (int) (Math.random() * boxes.size()-1);
            this.boxes.set(random, ennemie);
//            boolean boxEmpty = false;
//            while (!boxEmpty) {
//                if (this.boxes.get(random).getMysteryBox() == null && (this.boxes.get(random).getEnnemies() == null) && ((this.boxes.get(random).getCharacter() == null))) {
//                    this.boxes.get(random).setEnnemies(ennemie);
//                    boxEmpty = true;
//                } else {
//                    random = (int) (Math.random() * boxes.size()-1);
//                }
//            }
        }
        for (int i = 0; i < 10; i++) {
            Ennemies ennemie = new Goblin();
            int random = (int) (Math.random() * boxes.size()-1);
            this.boxes.set(random, ennemie);
//            boolean boxEmpty = false;
//            while (!boxEmpty) {
//                if (this.boxes.get(random).getMysteryBox() == null && (this.boxes.get(random).getEnnemies() == null) && ((this.boxes.get(random).getCharacter() == null))) {
//                    this.boxes.get(random).setEnnemies(ennemie);
//                    boxEmpty = true;
//                } else {
//                    random = (int) (Math.random() * boxes.size()-1);
//                }
//            }
        }
    }


    public int getBoxOfCharacter(Hero character) {
        for (int i = 0; i < this.boxes.size(); i++) {
            if (this.boxes.get(i).getCharacter() != null && this.boxes.get(i).getCharacter().equals(character)) {
                return i;
            }
        }
        return -1;
    }

    public void placeCharacterAtStart(Hero character) {
        if (boxes.size() > 0) {
            boxes.get(0).setCharacter(character);
        }
    }

    public void moveCharacter(Hero character, int steps) {
        currentBoxIndex = getBoxOfCharacter(character);
        if (currentBoxIndex != -1) {
            newBoxIndex = currentBoxIndex + steps;
            if (newBoxIndex >= boxes.size()) {
                newBoxIndex = boxes.size() - 1;
            }
            if (newBoxIndex == this.boxes.size() - 1) {
                System.out.println(character.getName() + " a terminé le donjon");
            }

            if (currentBoxIndex < this.boxes.size()) {
                Box box = boxes.get(newBoxIndex);
                box.interaction(character, this);

                boxes.get(currentBoxIndex).setCharacter(null);
                boxes.get(newBoxIndex).setCharacter(character);
            }
        }
    }
//---------------------------------------------------------------------------------------------------------------------------------------------------------------

//    private void handleMysteryBox(Hero character, Items Item) {
//        character.addToInventory(Item);
//        System.out.println("Il y a une boite mystère contenant :" + Item);
//
//
//        if (Item.getType().equals("Épée") && character instanceof Warrior && character.getOffensiveEquipment().getAttackPower() < Item.getPower()) {
//            character.setOffensiveEquipment((OffensiveEquipment) Item);
//            character.setAttackPower(character.getBaseAttackPower() + character.getOffensiveEquipment().getAttackPower());
//            System.out.println("Vous aves maintenant " + Item + " équipée");
//        }
//
//
//        if (Item.getType().equals("Catalyseur") && character instanceof Wizard && character.getOffensiveEquipment().getAttackPower() < Item.getPower()) {
//            character.setOffensiveEquipment((OffensiveEquipment) Item);
//            character.setAttackPower(character.getBaseAttackPower() + character.getOffensiveEquipment().getAttackPower());
//
//            System.out.println("Vous aves maintenat " + Item + " équipée");
//        }
//
//
//        if (Item.getType().equals("Potion")) {
//            character.setHealth(character.getHealth() + Item.getPower());
//            System.out.println("Votre personnage à gagné " + Item.getPower() + "hp");
//        }
//
//    }

//---------------------------------------------------------------------------------------------------------------------------------------------------------------


//    private void handleEnnemyEncounter(Hero character, Ennemies ennemies, int currentBoxIndex, int newBoxIndex) {
//        Menu menu = new Menu();
//        boolean userChoice = menu.fightOrFlee();
//        if (!userChoice) {
////            System.out.println("Le " + ennemies.getName() + " vas vous attaquer pendant votre fuite");
////            int damage = ennemies.getAttackPower() - character.getDefensePower();
////            if (damage < 0) {
////                damage = 0;
////            }
////            character.setHealth(character.getHealth() - damage);
////            System.out.println("il vous reste " + character.getHealth() + " HP");
////            if (character.getHealth() <= 0) {
////                System.out.println("Il vous as tuer, Game Over");
////                System.exit(0);
////            } else {
////                System.out.println("Vous avez fuis comme un lâche");
////                int random = (int) (Math.random() * 6);
////                System.out.println("Vous reculer de " + random + " case(s)");
////                newBoxIndex = currentBoxIndex - (random);
//////                boxes.get(currentBoxIndex).setCharacter(null);
//////                boxes.get(newBoxIndex).setCharacter(character);
////            }
//        } else {
////            while (character.getHealth() > 0 && ennemies.getHealth() > 0) {
////                System.out.println(character.getName() + " attaque et inflige " + character.getAttackPower() + "de dégats à "
////                        + ennemies.getName());
////                ennemies.setHealth(ennemies.getHealth() - character.getAttackPower());
////                System.out.println(ennemies.getName() + " attaque et inflige " + ennemies.getAttackPower() + "de dégats à "
////                        + character.getName());
////                character.setHealth(character.getHealth() - ennemies.getAttackPower());
////                if (ennemies.getHealth() <= 0) {
////                    System.out.println("Le " + ennemies.getName() + " est mort");
////                    System.out.println("il vous reste "+character.getHealth()+" points de vie");
////                    boxes.get(currentBoxIndex).setEnnemies(null);
////                } else {
////
////                    if (character.getHealth() <= 0) {
////                        System.out.println("Il vous as tuer, Game Over");
////                        System.exit(0);
////                    }
////
////                }
////            }
//        }
//    }
}