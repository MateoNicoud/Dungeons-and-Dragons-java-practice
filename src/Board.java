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
}