import java.util.Scanner;

public class Dice {
    public Dice(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Appuie sur entrée pour lancer les dès");
        String enter = reader.nextLine();
        while (!enter.isEmpty()){
            System.out.println("S'il vous plaît appuyer juste sur entrée");
            enter = reader.nextLine();
        }

    }
}
