package all;

import all.hero.Hero;
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Menu menu = new Menu();
        RequestDatabase request = new RequestDatabase();
        String firstChoice;
        if(request.getHeroPosition(1) == -1) {
            firstChoice=menu.emptySave();
        }else {
            firstChoice=menu.firstChoice();
        }
        game.setGameState(Game.State.INIT);
        Hero character;
        if (firstChoice.equals("continue")){
            character =request.getHeroFromDatabase(1);
            game.setNewGame(false);
        }else{
            character = game.CharacterBuilder();
            game.setNewGame(true);
        }
        game.setGameState(Game.State.IN_PROGRESS);
        do {
            game.play(character);
        } while (!game.getGameState().equals(Game.State.FINISHED));
        request.deleteAllData();
    }
}