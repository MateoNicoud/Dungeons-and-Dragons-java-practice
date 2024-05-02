import Character.Character;
import Ennemies.*;
import Ennemies.Sorcerer;
import Stuff.Items;
import java.util.ArrayList;


public class Board {
    private ArrayList<Box> boxes;

    public Board() {
        boxes = new ArrayList<Box>();
        for (int i = 0; i < 64; i++) {
            Box box = new DefaultBox(i+1);
            boxes.add(box);
        }
    }

    public void addBox(Box box){
        boxes.add(box);
    }

    public Box getBox(int index) {
        return this.boxes.get(index);
    }

    public int getBoardSize() {
        return this.boxes.size();
    }

    public void placeMysteryBox() {
        for (int i = 0; i < this.boxes.size() * 0.05; i++) {
            MysteryBox mysteryBox = new MysteryBox();
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
    }

    public void placeEnnemies() {
        for (int i = 0; i < this.boxes.size() * 0.05; i++) {
            int randomEnnemie = (int) (Math.random() * 3);
            Ennemies ennemie = null;
            if (randomEnnemie < 1) {
                ennemie = new Sorcerer();
            } else if (randomEnnemie < 2) {
                ennemie = new Goblin();
            } else {
                ennemie = new Dragon();
            }
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
        while (currentBoxIndex < newBoxIndex) {
            if (currentBoxIndex <= this.boxes.size()) {
                boxes.get(currentBoxIndex).setCharacter(null);
                currentBoxIndex++;
                if (currentBoxIndex < this.boxes.size()) {
                    boxes.get(currentBoxIndex).setCharacter(character);
                    if (boxes.get(currentBoxIndex).getMysteryBox() != null) {
                        Items randomItem = boxes.get(currentBoxIndex).getMysteryBox().getRandomItem();
                        character.addToInventory(randomItem);
                        System.out.println("Il y a une boite mystère contenant :" + randomItem);
                        character.displayInventory();
                    }
                    if (boxes.get(currentBoxIndex).getEnnemies() != null) {
                        System.out.println("Il y a un " + boxes.get(currentBoxIndex).getEnnemies().getName() + " Sur cette case");
                    }
                    System.out.println("avancement :" + (currentBoxIndex + 1));
                }

            } else {
                System.out.println(character.getName() + " a terminé le donjon");
                break;
            }
        }

    }
}
}
