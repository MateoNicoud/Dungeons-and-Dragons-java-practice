import Character.Character;

public static void main() {

    Game game = new Game();
    Character character = game.CharacterBuilder();
    character.displayCharacter();
    MysteryBox mysteryBox = new MysteryBox();
    character.addToInventory(mysteryBox.getRandomItem());
    character.displayInventory();
    game.Play(character);

}