import java.io.*;
import java.util.Objects;

public class Personnage {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int health = 0;
        int attackPower = 0;
        String OffensiveEquipment = "none";
        String DefensiveEquipment = "none";

        System.out.println("Bonjour, quel est votre nom?");
        String name = reader.readLine();
        System.out.println("Votre nom est " + name);
        System.out.println("Quel est votre job? (guerrier/magicien)");
        String job = reader.readLine();
        while (!job.equals("guerrier") && !job.equals("magicien")){
            System.out.println("Veuillez choisir entre guerrier et magicien");
            job = reader.readLine();
        }

        if (job.equals("guerrier")){
            health =10;
            attackPower=10;
            OffensiveEquipment="weapon";
            System.out.println("Avez-vous un bouclier? (oui/non)");
            boolean hasShield = reader.readLine().equals("oui");
            if (hasShield){
                DefensiveEquipment="shield";
            }

        }
        if (job.equals("magicien")){
            health =6;
            attackPower=15;
            OffensiveEquipment="spell";
            System.out.println("Avez-vous un philtre? (oui/non)");
            boolean hasPotion = reader.readLine().equals("oui");
            if (hasPotion){
                DefensiveEquipment="potion";
            }
        }
        System.out.println("Voici un résumé de votre personnage:");
        System.out.println("Nom: " + name);
        System.out.println("Job: " + job);
        System.out.println("Santé: " + health);
        System.out.println("Puissance d'attaque: " + attackPower);
        System.out.println("Equipement offensif: " + OffensiveEquipment);
        System.out.println("Equipement défensif: " + DefensiveEquipment);


    }
}
