import java.util.Scanner;

public class Game {
    private final Menu menu;
    public Game() {
        this.menu = new Menu();
    }
    public Character CharacterBuilder(){
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
            newCharacter = new Warrior(name,job, hasDefensiveEquipment);
        } else {
            newCharacter = new Wizard(name,job, hasDefensiveEquipment);
        }

        return newCharacter;
    }

}
