package all;

import all.hero.Hero;
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Menu menu = new Menu();
        String firstChoice =menu.firstChoice();
        game.setGameState(Game.State.INIT);
        Hero character;
        boolean newGame;
        if (firstChoice.equals("continue")){
            character = game.getHeroFromDatabase(1);
            newGame=false;
        }else{
            character = game.CharacterBuilder();
            newGame=true;
        }
        game.setGameState(Game.State.IN_PROGRESS);
        do {
            game.play(character, newGame);
        } while (!game.getGameState().equals(Game.State.FINISHED));
    }
}