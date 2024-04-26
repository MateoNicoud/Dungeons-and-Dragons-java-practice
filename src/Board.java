public class Board {
    private final Box[] boxes;

    public Board(){
        this.boxes = new Box[64];
        for(int i = 0; i < 64; i++){
            this.boxes[i] = new Box(i+1);
        }
    }

    public Box getBox(int index) {
        return this.boxes[index];
    }

    public int getBoxOfCharacter(Character character){
        for (int i=0; i< this.boxes.length; i++){
            if(this.boxes[i].getCharacter() == character){
                return i;
            }
        }
        return -1;
    }
    public void moveCharacter(Character character, int steps){
        int currentBoxIndex = getBoxOfCharacter(character);
        if(currentBoxIndex!=1){
            int newBoxIndex = currentBoxIndex + steps;
            while (currentBoxIndex < newBoxIndex) {
                boxes[currentBoxIndex].setCharacter(null);
                currentBoxIndex++;
                if (currentBoxIndex < boxes.length) {
                    boxes[currentBoxIndex].setCharacter(character);
                    System.out.println("avancement :" + (currentBoxIndex+1));
                }
            }
        }
    }
}