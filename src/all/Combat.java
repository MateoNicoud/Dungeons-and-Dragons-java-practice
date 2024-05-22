package all;

import all.Ennemies.Ennemies;
import all.hero.Hero;
import all.RequestDatabase;

public class Combat {
    public Combat(Ennemies ennemie, Hero hero,Board board){
        Menu menu = new Menu();
        boolean choice = menu.fightOrFlee(ennemie.getName());
        if (choice) {
            fight(ennemie, hero, board);
        } else {
            flee(ennemie, hero, board);
        }

    }


    public void fight(Ennemies ennemies, Hero character, Board board){
        while (character.getHealth() > 0 && ennemies.getHealth() > 0) {
            System.out.println(character.getName() + " attaque et inflige " + character.getAttackPower() + "de dégats à "
                    + ennemies.getName());
            ennemies.setHealth(ennemies.getHealth() - character.getAttackPower());
            System.out.println(ennemies.getName() + " attaque et inflige " + ennemies.getAttackPower() + "de dégats à "
                    + character.getName());
            character.setHealth(character.getHealth() - ennemies.getAttackPower());
        }
        if (ennemies.getHealth() <= 0 && character.getHealth()>0) {
            System.out.println("Le " + ennemies.getName() + " est mort");
            System.out.println("il vous reste "+character.getHealth()+" points de vie");
//                boxes.get(currentBoxIndex).setEnnemies(null);
        } else {

            if (character.getHealth() <= 0) {
                RequestDatabase request = new RequestDatabase();
                request.deleteAllData();
                System.out.println("Il vous as tuer, Game Over");
                System.exit(0);
            }

        }
    }



    public void flee(Ennemies ennemies, Hero character, Board board){
        System.out.println("Le " + ennemies.getName() + " vas vous attaquer pendant votre fuite");
        int damage = ennemies.getAttackPower() - character.getDefensePower();
        if (damage < 0) {
            damage = 0;
        }
        character.setHealth(character.getHealth() - damage);
        System.out.println("il vous reste " + character.getHealth() + " HP");
        if (character.getHealth() <= 0) {
            RequestDatabase request = new RequestDatabase();
            request.deleteAllData();
            System.out.println("Il vous as tuer, Game Over");
            System.exit(0);
        } else {
            System.out.println("Vous avez fuis comme un lâche");
            int random = (int) (Math.random() * 6);
            if( (board.getCurrentBoxIndex() - (random))>1) {
                System.out.println("Vous reculer de " + random + " case(s)");
                int newBoxIndex = board.getCurrentBoxIndex() - (random);
                board.setNewBoxIndex(newBoxIndex);
            } else {
                System.out.println("Vous reculer de " + (board.getCurrentBoxIndex()-1) + " case(s)");
                board.setNewBoxIndex(1);

            }
//                boxes.get(currentBoxIndex).setCharacter(null);
//                boxes.get(newBoxIndex).setCharacter(character);
        }
    }
}
