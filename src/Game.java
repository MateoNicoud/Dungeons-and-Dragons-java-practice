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
            int boxIndex = board.getBoxOfCharacter(character);
            while (boxIndex < 63) {
                System.out.println(character.getName() + " est à la case " + (boxIndex + 1));
                Dice dice = new Dice();
                int throwedDice = dice.throwDice(1, 6, 2);
                if (boxIndex + throwedDice > 63) {
                    System.out.println(character.getName() + " a terminé le donjon");
                    break;
                }
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

}
