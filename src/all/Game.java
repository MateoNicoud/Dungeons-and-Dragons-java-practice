package all;

import all.Ennemies.Ennemies;
import all.Stuff.DefensiveEquipement.LoadedShield;
import all.Stuff.Items;
import all.Stuff.OffensiveEquipement.LoadedOffensive;
import all.board.Box;
import all.hero.Hero;
import all.hero.Warrior;
import all.hero.Wizard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import all.Stuff.*;


public class Game {

    enum State {
        INIT,
        IN_PROGRESS,
        FINISHED
    }

    private final Menu menu;

    public State getGameState() {
        return gameState;
    }

    public void setGameState(State gameState) {
        this.gameState = gameState;
    }

    private State gameState;


    public Game() {
        this.menu = new Menu();
    }

    public Hero CharacterBuilder() {

        String name = menu.getCharacterName();
        String job = menu.getCharacterJob();
        System.out.println("Voulez vous un équipement dans votre main secondaire? (oui/non)");
        boolean hasDefensiveEquipment = menu.getSecondHand();

        Hero newCharacter;
        if (job.equals("guerrier")) {
            newCharacter = new Warrior(name, job, hasDefensiveEquipment);
        } else {
            newCharacter = new Wizard(name, job, hasDefensiveEquipment);
        }

        newCharacter.displayCharacter();
        newCharacter.displayInventory();

        return newCharacter;
    }


    public Hero getHeroFromDatabase(int boardId) {
        Hero hero = null;
        String sql = "SELECT hero.* FROM hero JOIN board ON hero.id = board.Hero_id WHERE board.id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, boardId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String job = resultSet.getString("Job");
                int healthPoint = resultSet.getInt("healthPoint");
                int attackPower = resultSet.getInt("attackPower");
                int defensePower = resultSet.getInt("defensePower");
                boolean secondaryHand = false;

                if (job.equals("guerrier")) {
                    hero = new Warrior(name, job, secondaryHand);
                } else {
                    hero = new Wizard(name, job, secondaryHand);
                }

                hero.setHealth(healthPoint);
                hero.setAttackPower(attackPower);
                hero.setDefensePower(defensePower);

                // Get offensive equipment
                sql = "SELECT * FROM offensiveEquipement WHERE Hero_id = ?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, hero.getId());
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String nameOffensive = resultSet.getString("name");
                    int attackPowerOffensive = resultSet.getInt("attackPower");
                    String typeOffensive = resultSet.getString("type");

                    OffensiveEquipment offensiveEquipment = new LoadedOffensive(typeOffensive, nameOffensive, attackPowerOffensive);
                    hero.setOffensiveEquipment(offensiveEquipment);
                }

                // Get defensive equipment
                sql = "SELECT * FROM defensiveEquipement WHERE Hero_id = ?";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, hero.getId());
                resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String nameDefensive = resultSet.getString("name");
                    int defensePowerDefensive = resultSet.getInt("defensePower");
                    String typeDefensive = resultSet.getString("type");

                    DefensiveEquipment defensiveEquipment = new LoadedShield(typeDefensive, nameDefensive, defensePowerDefensive);
                    hero.setDefensiveEquipment(defensiveEquipment);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hero;
    }


    public void play(Hero character, Boolean newGame) {

        RequestDatabase request = new RequestDatabase();
        Board board;
        if(!newGame){
            board = new Board(false);
        } else {
            request.deleteAllData();
            board = new Board(true);
            board.placeCharacterAtStart(character);
            request.createHero(board, character);
            request.insertOffensiveEquipment(character, character.getOffensiveEquipment());
            request.insertDefensiveEquipment(character, character.getDefensiveEquipment());


            for (int i = 0; i < board.getBoardSize(); i++) {
                request.createBox(board, character, i);
            }
            for (int i = 0; i < board.getBoardSize(); i++) {
                Box box = board.getBox(i);
                if (box instanceof Ennemies ennemies) {
                    request.insertEnnemie(ennemies, board, i);
                }
                if (box instanceof MysteryBox mysteryBox) {
                    Items item = mysteryBox.getRandomItem();
                    request.insertMysteryBox(item, board, i);
                }
            }



            request.insertBoard(character, board.getBoxOfCharacter(character), 1);
        }
        int boxIndex = board.getBoxOfCharacter(character);
        //Lance des tours jusqu'à avoir fini le plateau.
        while (boxIndex < 63) {
            boxIndex = playTurn(character,board, boxIndex);
            request.editHero(board, character);
            request.editOffensiveEquipment(character, character.getOffensiveEquipment());
            request.editDefensiveEquipment(character, character.getDefensiveEquipment());
            Box box = board.getBox(boxIndex);
            if (box instanceof Ennemies ennemies) {
                request.editEnnemie(ennemies, boxIndex);
            }
            request.editBoard(character, boxIndex, 1);
        }


        boolean goodResponse = false;
        while (!goodResponse) {
            String restart = menu.getRestartResponse();
            switch (restart) {
                case "non" -> {

                    gameState = State.FINISHED;
                    System.out.println("Cya");
                    goodResponse = true;
                }
                case "oui" -> {
                    System.out.println("Redémarrage de la partie");
                    goodResponse = true;
                }
                case "menu" -> menu.displayMenu();
                default -> System.out.println("Réponse incorrect");
            }
        }
    }


    private int getThrowedDiceSafely(int boardSize, int index) {
        try {
            return getThrowedDice(boardSize, index);
        } catch (CharacterOutOfBounds error) {
            System.out.println(error.getMessage());
            return boardSize - index - 1;
        }
    }

    private int getThrowedDice(int boardSize, int index) throws CharacterOutOfBounds {
        Dice dice = new Dice1();
        int thrownDice = dice.throwDice(1, 6, 2);

        if ((thrownDice + index) > boardSize) {
            throw new CharacterOutOfBounds("En dehors du plateau");
        }

        return thrownDice;
    }
    private int playTurn(Hero character, Board board, int boxIndex){
        System.out.println(character.getName() + " est à la case " + (boxIndex + 1));
        int throwedDice = getThrowedDiceSafely(board.getBoardSize(), boxIndex);
        board.moveCharacter(character, throwedDice);
        if (boxIndex<=63) {
            boxIndex = board.getBoxOfCharacter(character);
            return boxIndex;
        }else {
            return 63;
        }
    }


}

