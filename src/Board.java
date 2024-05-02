import Character.Character;
import Ennemies.*;
import Ennemies.Sorcerer;
import Stuff.Items;

public class Board {
    private final Box[] boxes;

    public Board() {
        this.boxes = new Box[64];
        for (int i = 0; i < 64; i++) {
            this.boxes[i] = new Box(i + 1);
        }
    }

    public Box getBox(int index) {
        return this.boxes[index];
    }

    public int getBoardSize() {
        return this.boxes.length;
    }

    public void placeMysteryBox() {
        for (int i = 0; i < this.boxes.length * 0.05; i++) {
            MysteryBox mysteryBox = new MysteryBox();
            int random = (int) (Math.random() * boxes.length);
            boolean boxEmpty = false;
            while (!boxEmpty) {
                if (this.boxes[random].getMysteryBox() == null && (this.boxes[random].getEnnemies() == null) && ((this.boxes[random].getCharacter() == null))) {
                    this.boxes[random].setMysteryBox(mysteryBox);
                    boxEmpty = true;
                } else {
                    random = (int) (Math.random() * boxes.length);
                }
            }
        }
    }

    public void placeEnnemies() {
        for (int i = 0; i < this.boxes.length * 0.05; i++) {
            int randomEnnemie = (int) (Math.random() * 3);
            Ennemies ennemie = null;
            if (randomEnnemie < 1) {
                ennemie = new Sorcerer();
            } else if (randomEnnemie < 2) {
                ennemie = new Goblin();
            } else {
                ennemie = new Dragon();
            }
            int random = (int) (Math.random() * boxes.length);
            boolean boxEmpty = false;
            while (!boxEmpty) {
                if (this.boxes[random].getMysteryBox() == null && (this.boxes[random].getEnnemies() == null) && ((this.boxes[random].getCharacter() == null))) {
                    this.boxes[random].setEnnemies(ennemie);
                    boxEmpty = true;
                } else {
                    random = (int) (Math.random() * boxes.length);
                }
            }


        }
    }


public int getBoxOfCharacter(Character character) {
    for (int i = 0; i < this.boxes.length; i++) {
        if (this.boxes[i].getCharacter() == character) {
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
            if (currentBoxIndex <= this.boxes.length) {
                boxes[currentBoxIndex].setCharacter(null);
                currentBoxIndex++;
                if (currentBoxIndex < this.boxes.length) {
                    boxes[currentBoxIndex].setCharacter(character);
                    if (boxes[currentBoxIndex].getMysteryBox() != null) {
                        Items randomItem = boxes[currentBoxIndex].getMysteryBox().getRandomItem();
                        character.addToInventory(randomItem);
                        System.out.println("Il y a une boite mystère contenant :" + randomItem);
                        character.displayInventory();
                    }
                    if (boxes[currentBoxIndex].getEnnemies() != null) {
                        System.out.println("Il y a un " + boxes[currentBoxIndex].getEnnemies().getName() + " Sur cette case");
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
