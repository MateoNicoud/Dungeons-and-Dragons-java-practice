public static void main() {
    Game game = new Game();
    Character character = game.CharacterBuilder();
    character.displayCharacter();

    Board board = new Board();
    board.getBox(0).setCharacter(character);

    int boxIndex = board.getBoxOfCharacter(character);
    System.out.println(character.getName()+" est à la case "+(boxIndex+1));
}