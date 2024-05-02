import Character.Character;
import Character.Warrior;
import Character.Wizard;


public class Game {
    private final Menu menu;

    public Game() {
        this.menu = new Menu();
    }

    public Character CharacterBuilder() {

        String name = menu.getCharacterName();
        String job = menu.getCharacterJob();
        System.out.println("Voulez vous un équipement dans votre main secondaire? (oui/non)");
        boolean hasDefensiveEquipment = menu.getSecondHand();

        Character newCharacter;
        if (job.equals("guerrier")) {
            newCharacter = new Warrior(name, job, hasDefensiveEquipment);
        } else {
            newCharacter = new Wizard(name, job, hasDefensiveEquipment);
        }

        return newCharacter;
    }

    public void Play(Character character) {

        boolean end = false;
        while (!end) {

            Board board = new Board();
            board.getBox(0).setCharacter(character);
            board.placeMysteryBox();
            board.placeEnnemies();
            int boxIndex = board.getBoxOfCharacter(character);
            while (boxIndex < 63) {
                System.out.println(character.getName() + " est à la case " + (boxIndex + 1));
                int throwedDice = getThrowedDiceSafely(board.getBoardSize(), boxIndex);
                board.moveCharacter(character, throwedDice);
                boxIndex = board.getBoxOfCharacter(character);
            }
            boolean goodResponse = false;
            while (!goodResponse) {
                String restart = menu.getRestartResponse();
                switch (restart) {
                    case "non" -> {

                        end = true;
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
        Dice dice = new Dice();
        int throwedDice = dice.throwDice(1, 6, 2);

        if ((throwedDice + index) > boardSize ) {
            throw new CharacterOutOfBounds("En dehors du plateau");
        }

        return throwedDice;
    }
}


