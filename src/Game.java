import java.util.Scanner;

public class Game {
    private final Menu menu;

    public Game() {
        this.menu = new Menu();
    }

    public Character CharacterBuilder() {
        Scanner reader = new Scanner(System.in);

        System.out.println("Bonjour, quel est votre nom?");
        String name = reader.nextLine();
        while (name.equals("menu")) {
            menu.displayMenu();
            System.out.println("Bonjour, quel est votre nom?");
            name = reader.nextLine();
        }
        System.out.println("Quel est votre job? (guerrier/magicien)");
        String job = reader.nextLine();
        if (job.equals("menu")) {
            menu.displayMenu();
        }
        while (!job.equals("guerrier") && !job.equals("magicien")) {
            System.out.println("Veuillez choisir entre guerrier et magicien");

            job = reader.nextLine();
            if (job.equals("menu")) {
                menu.displayMenu();
            }
        }

        System.out.println("Voulez vous un équipement dans votre main secondaire? (oui/non)");
        boolean hasDefensiveEquipment = reader.nextLine().equals("oui");

        Character newCharacter;
        if (job.equals("guerrier")) {
            newCharacter = new Warrior(name, job, hasDefensiveEquipment);
        } else {
            newCharacter = new Wizard(name, job, hasDefensiveEquipment);
        }

        return newCharacter;
    }

    public void Play(Character character) {
        Scanner reader = new Scanner(System.in);

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
            System.out.println(character.getName() + " a terminé le donjon");
            boolean goodResponse = false;
            while (!goodResponse) {
                System.out.println("Veut tu recommencer avec ce personnage ? (oui/non)");
                String restart = reader.nextLine();
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
