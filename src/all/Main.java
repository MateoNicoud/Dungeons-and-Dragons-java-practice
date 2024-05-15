package all;

import all.hero.Hero;
public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        game.setGameState(Game.State.INIT);
        Hero character = game.CharacterBuilder();
        game.setGameState(Game.State.IN_PROGRESS);
        do {
            game.play(character);
        } while (!game.getGameState().equals(Game.State.FINISHED));
        character.deleteHero();
    }
}