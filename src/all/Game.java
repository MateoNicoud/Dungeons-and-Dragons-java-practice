package all;

import all.hero.Hero;
import all.hero.Warrior;
import all.hero.Wizard;


public class Game {

    enum State {
        INIT,
        IN_PROGRESS,
        FINISHED
    }

    private final Menu menu;

    public State getGameState() {
        return gameState;
    }

    public void setGameState(State gameState) {
        this.gameState = gameState;
    }

    private State gameState;


    public Game() {
        this.menu = new Menu();
    }

    public Hero CharacterBuilder() {

        String name = menu.getCharacterName();
        String job = menu.getCharacterJob();
        System.out.println("Voulez vous un équipement dans votre main secondaire? (oui/non)");
        boolean hasDefensiveEquipment = menu.getSecondHand();

        Hero newCharacter;
        if (job.equals("guerrier")) {
            newCharacter = new Warrior(name, job, hasDefensiveEquipment);
        } else {
            newCharacter = new Wizard(name, job, hasDefensiveEquipment);
        }
        newCharacter.displayCharacter();
        newCharacter.displayInventory();

        return newCharacter;
    }

    public void play(Hero character) {


        Board board = new Board();
        board.placeCharacterAtStart(character);


//        board.getBox(0).setCharacter(character);



        int boxIndex = board.getBoxOfCharacter(character);

        //Lance des tours jusqu'à avoir fini le plateau.
        while (boxIndex < 63) {
           boxIndex = playTurn(character,board, boxIndex);
        }

        boolean goodResponse = false;
        while (!goodResponse) {
            String restart = menu.getRestartResponse();
            switch (restart) {
                case "non" -> {

                    gameState = State.FINISHED;
                    System.out.println("Cya");
                    goodResponse = true;
                }
                case "oui" -> {
                    System.out.println("Redémarrage de la partie");
                    goodResponse = true;
                }
                case "menu" -> menu.displayMenu();
                default -> System.out.println("Réponse incorrect");
            }
        }
    }


    private int getThrowedDiceSafely(int boardSize, int index) {
        try {
            return getThrowedDice(boardSize, index);
        } catch (CharacterOutOfBounds error) {
            System.out.println(error.getMessage());
            return boardSize - index - 1;
        }
    }

    private int getThrowedDice(int boardSize, int index) throws CharacterOutOfBounds {
        Dice dice = new Dice1();
        int thrownDice = dice.throwDice(1, 6, 2);

        if ((thrownDice + index) > boardSize) {
            throw new CharacterOutOfBounds("En dehors du plateau");
        }

        return thrownDice;
    }
    private int playTurn(Hero character, Board board, int boxIndex){
        System.out.println(character.getName() + " est à la case " + (boxIndex + 1));
        int throwedDice = getThrowedDiceSafely(board.getBoardSize(), boxIndex);
        board.moveCharacter(character, throwedDice);
        if (boxIndex<=63) {
            boxIndex = board.getBoxOfCharacter(character);
            return boxIndex;
        }else {
            return 63;
        }
    }


}

