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
                    2. Ouvrir l'inventaire
                    3. Quitter le jeu""");

            userChoice = reader.nextLine();

            switch (userChoice) {
                case "1":
                    //Reprendre le jeu
                    break;
                case "2":
                    //Ouvrir l'inventaire
                    break;
                case "3":
                    System.out.println("Fermeture du jeu");
                    System.exit(0);
                    break;
            }
        } while (!userChoice.equals("1"));

    }

    public String getRestartResponse() {
        System.out.println("Veut tu recommencer avec ce personnage ? (oui/non)");
        return reader.nextLine();
    }

    public String getCharacterName() {
        System.out.println("Bonjour, quel est votre nom?");
        String name = reader.nextLine();
        while (name.equals("menu")) {
            displayMenu();
            System.out.println("Bonjour, quel est votre nom?");
            name = reader.nextLine();
        }
        return name;
    }


    public String getCharacterJob() {
        System.out.println("Quel est votre job? (guerrier/magicien)");
        String job = reader.nextLine();
        if (job.equals("menu")) {
            displayMenu();
        }
        while (!job.equals("guerrier") && !job.equals("magicien")) {
            System.out.println("Veuillez choisir entre guerrier et magicien");

            job = reader.nextLine();
            if (job.equals("menu")) {
                displayMenu();
            }
        }
        return job;
    }

    //Choix d'équiper un objet dans la main secondaire
    public boolean getSecondHand() {
        while (true) {
            try {
                String response = reader.nextLine();
                if (response.equals("oui")) {
                    return true;
                } else if (response.equals("non")) {
                    return false;
                } else {
                    throw new IllegalArgumentException("Réponse non valide");
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    //Lancement des jets de dés
    public void getEnter() {
        System.out.println("Appuie sur entrée pour lancer les dès");
        String enter = reader.nextLine();
        while (!enter.isEmpty()) {
            if (enter.equals("menu")) {
                displayMenu();
            }
            System.out.println("Appuie sur entrée pour lancer les dès");
            enter = reader.nextLine();
        }
    }
}
