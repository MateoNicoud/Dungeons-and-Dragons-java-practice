import Character.Character;

public static void main() {

    Game game = new Game();
    Character character = game.CharacterBuilder();
    character.displayCharacter();
    game.Play(character);

}