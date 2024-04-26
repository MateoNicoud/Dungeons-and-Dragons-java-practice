import java.util.Scanner;

public class Menu {
    private final Scanner reader;

    public Menu() {
        this.reader = new Scanner(System.in);
    }

    public void displayMenu() {
        String userChoice;
        do {
            System.out.println("""
                    1. Reprendre le jeu
                    2. Changer d'équipement
                    3. Quitter le jeu""");

            userChoice = reader.nextLine();

            switch (userChoice) {
                case "1":
                    //Reprendre le jeu
                    break;
                case "2":
                    //Changer d'équipement
                    break;
                case "3":
                    System.out.println("Fermeture du jeu");
                    System.exit(0);
                    break;
            }
        } while (!userChoice.equals("1"));

    }
}
