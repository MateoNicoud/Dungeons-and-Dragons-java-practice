import java.util.Scanner;

public class Dice {
    public int throwDice(int min, int max, int quantity) {
        Scanner reader = new Scanner(System.in);
        Menu menu =new Menu();
        int[] dice = new int[quantity];
        int total = 0;
        for(int i=0;i<dice.length;i++) {
            System.out.println("Appuie sur entrée pour lancer les dès");
            String enter = reader.nextLine();
            while (!enter.isEmpty()) {
                if (enter.equals("menu")){
                    menu.displayMenu();
                }
                System.out.println("Appuie sur entrée pour lancer les dès");
                enter = reader.nextLine();
            }

            int range = (max - min) + 1;
           dice[i] = (int) ((range * Math.random()) + min);
           System.out.println("Résultat du lancer de dès numéro "+(i+1)+" : "+dice[i]);

           total += dice[i];
        }
        return total;

    }
}
