import Character.Character;
public class Main {
    public static void main(String[] args) {

        Game game = new Game();
        game.setGameState("INITIALISATION");
        Character character = game.CharacterBuilder();
        game.setGameState("IN_PROGRESS");
        do {
            game.Play(character);
        } while (!game.getGameState().equals("FINISHED"));

    }
}