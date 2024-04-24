import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Bonjour, quel est votre nom?");
        String name = reader.nextLine();
        System.out.println("Votre nom est " + name);
        System.out.println("Quel est votre job? (guerrier/magicien)");
        String job = reader.nextLine();
        while (!job.equals("guerrier") && !job.equals("magicien")) {
            System.out.println("Veuillez choisir entre guerrier et magicien");
            job = reader.nextLine();
        }

        System.out.println("Voulez vous un équipement dans votre main secondaire? (oui/non)");
        boolean hasDefensiveEquipment = reader.nextLine().equals("oui");
        Character newCharacter = new Character(name,job,hasDefensiveEquipment);
        newCharacter.displayCharacter();

//        int health = 0;
//
//        int attackPower = 0;
//        String OffensiveEquipment = "none";
//        String DefensiveEquipment = "none";
//

//
//
//        if (job.equals("guerrier")) {
//            health = 10;
//            attackPower = 10;
//            OffensiveEquipment = "Arme";
//            if (hasShield) {
//                DefensiveEquipment = "Bouclier";
//            }
//
//        }
//
//        if (job.equals("magicien")) {
//            health = 6;
//            attackPower = 15;
//            OffensiveEquipment = "Sort";
//            System.out.println("Avez-vous un philtre? (oui/non)");
//            boolean hasPotion = reader.nextLine().equals("oui");
//            if (hasPotion) {
//                DefensiveEquipment = "Philtre";
//            }
//        }
//
//
    }
}