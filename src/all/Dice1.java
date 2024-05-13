package all;

public class Dice1 implements Dice {

    public int throwDice(int min, int max, int quantity) {
        Menu menu =new Menu();
        int[] dice = new int[quantity];
        int total = 0;
        for(int i=0;i<dice.length;i++) {
           menu.getEnter();

            int range = (max - min) + 1;
           dice[i] = (int) ((range * Math.random()) + min);
           System.out.println("Résultat du lancer de dès numéro "+(i+1)+" : "+dice[i]);

           total += dice[i];
        }
        return total;

    }
}
