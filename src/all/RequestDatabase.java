package all;

import all.Ennemies.Ennemies;
import all.Stuff.DefensiveEquipment;
import all.Stuff.Items;
import all.Stuff.OffensiveEquipment;
import all.hero.Hero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestDatabase {
    public RequestDatabase() {

    }

    public void createHero(Board board, Hero character) {
        String sql = "INSERT INTO hero (id, name, job, healthPoint, attackPower, defensePower, Position) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, character.getId());
            statement.setString(2, character.getName());
            statement.setString(3, character.getJob());
            statement.setInt(4, character.getHealth());
            statement.setInt(5, character.getAttackPower());
            statement.setInt(6, character.getDefensePower());
            int characterPosition = board.getBoxOfCharacter(character);
            statement.setInt(7, characterPosition);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getHeroes() {
        String sql = "SELECT id,job,name FROM hero";
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(); // remove sql from here
            while (resultSet.next()) {
                System.out.println("ID " + resultSet.getInt("id"));
                System.out.println("Job " + resultSet.getString("job"));
                System.out.println("Name " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editHero(Board board, Hero character) {
        String sql = "UPDATE hero SET name = ?, job = ?, healthPoint = ?, attackPower = ?, defensePower = ?, Position = ? WHERE id = ?";
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, character.getName());
            statement.setString(2, character.getJob());
            statement.setInt(3, character.getHealth());
            statement.setInt(4, character.getAttackPower());
            statement.setInt(5, character.getDefensePower());
            statement.setInt(6, board.getBoxOfCharacter(character));
            statement.setInt(7, character.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAllData() {
        deleteHero();
        deleteDefensiveEquipement();
        deleteOffensiveEquipement();
        deleteBoard();
        deleteCase();
        deleteMysteryBox();
        deleteEnnemie();
    }

    public void deleteHero() {
        deleteDefensiveEquipement();
        String sql = "DELETE FROM hero";
        executeUpdate(sql);
    }

    public void deleteDefensiveEquipement() {
        String sql = "DELETE FROM defensiveEquipement";
        executeUpdate(sql);
    }


    public void deleteOffensiveEquipement() {
        String sql = "DELETE FROM offensiveEquipement";
        executeUpdate(sql);
    }

    public void deleteBoard() {
        String sql = "DELETE FROM board";
        executeUpdate(sql);
    }

    public void deleteCase() {
        String sql = "DELETE FROM `case`";
        executeUpdate(sql);
    }

    public void deleteMysteryBox() {
        String sql = "DELETE FROM MysteryBox";
        executeUpdate(sql);
    }

    public void deleteEnnemie() {
        String sql = "DELETE FROM Ennemy";
        executeUpdate(sql);
    }

    private void executeUpdate(String sql) {
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getDefensiveEquipments() {
        String sql = "SELECT id,name,type,defensePower FROM defensiveEquipement";
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID " + resultSet.getInt("id"));
                System.out.println("Name " + resultSet.getString("name"));
                System.out.println("Type " + resultSet.getString("type"));
                System.out.println("Defense Power " + resultSet.getInt("defensePower"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertDefensiveEquipment(Hero character, DefensiveEquipment defensiveEquipment) {
        String sql = "INSERT INTO defensiveEquipement (id, name, type, defensePower, Hero_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, System.identityHashCode(defensiveEquipment));
            statement.setString(2, defensiveEquipment.getName());
            statement.setString(3, defensiveEquipment.getType());
            statement.setInt(4, defensiveEquipment.getDefensePower());
            statement.setInt(5, character.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editDefensiveEquipment(Hero character, DefensiveEquipment defensiveEquipment) {
        String sql = "UPDATE defensiveEquipement SET name = ?, type = ?, defensePower = ? WHERE Hero_id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, defensiveEquipment.getName());
            statement.setString(2, defensiveEquipment.getType());
            statement.setInt(3, defensiveEquipment.getDefensePower());
            statement.setInt(4, character.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDefensiveEquipment(int id) {
        String sql = "DELETE FROM defensiveEquipement WHERE id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getOffensiveEquipments() {
        String sql = "SELECT id,name,type,defensePower FROM offensiveEquipement";
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID " + resultSet.getInt("id"));
                System.out.println("Name " + resultSet.getString("name"));
                System.out.println("Type " + resultSet.getString("type"));
                System.out.println("Attack Power " + resultSet.getInt("attackPower"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOffensiveEquipment(Hero character, OffensiveEquipment offensiveEquipment) {
        String sql = "INSERT INTO offensiveEquipement (id, name, type, attackPower, Hero_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, System.identityHashCode(offensiveEquipment));
            statement.setString(2, offensiveEquipment.getName());
            statement.setString(3, offensiveEquipment.getType());
            statement.setInt(4, offensiveEquipment.getAttackPower());
            statement.setInt(5, character.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editOffensiveEquipment(Hero character, OffensiveEquipment offensiveEquipment) {
        String sql = "UPDATE offensiveEquipement SET name = ?, type = ?, attackPower = ? WHERE Hero_id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, offensiveEquipment.getName());
            statement.setString(2, offensiveEquipment.getType());
            statement.setInt(3, offensiveEquipment.getAttackPower());
            statement.setInt(4, character.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDOffensiveEquipment(Hero character) {
        String sql = "DELETE FROM offensiveEquipement WHERE Hero_id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, character.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editBoard(Hero character, int id_case, int id) {
        String sql = "UPDATE board SET Hero_id = ?, case_id = ? WHERE id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, character.getId());
            statement.setInt(2, id_case);
            statement.setInt(3, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBoard(Hero character, int id_case, int id) {
        String checkSql = "SELECT id FROM `case` WHERE id = ?";
        String insertSql = "INSERT INTO board (id,Hero_id,case_id) VALUES (?,?,?)";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
            checkStatement.setInt(1, id_case);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setInt(1, id);
                insertStatement.setInt(2, character.getId());
                insertStatement.setInt(3, id_case);
                insertStatement.executeUpdate();
            } else {
                System.out.println("case_id does not exist in the case table");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createBox(Board board, Hero character, int id) {
        String sql = "INSERT INTO `case` (id, Content) VALUES (?, ?)";
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            if (board.getBox(id) instanceof Ennemies) {
                statement.setString(2, "Monster");
            } else if (board.getBox(id) instanceof MysteryBox) {
                statement.setString(2, "Mystery Box");
            } else {
                statement.setNull(2, java.sql.Types.VARCHAR);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertMysteryBox(Items item, Board board, int id) {
        String checkSql = "SELECT id FROM `case` WHERE id = ?";
        String insertSql = "INSERT INTO MysteryBox (id, item, type, power, case_id)VALUES (?,?,?,?,?)";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
            checkStatement.setInt(1, id);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setInt(1, System.identityHashCode(board.getBox(id)));
                insertStatement.setString(2, item.getName());
                insertStatement.setString(3, item.getType());
                insertStatement.setInt(4, item.getPower());
                insertStatement.setInt(5, id);
                insertStatement.executeUpdate();
            } else {
                System.out.println("case_id does not exist in the case table");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertEnnemie(Ennemies ennemie, Board board, int id) {
        String checkSql = "SELECT id FROM `case` WHERE id = ?";
        String insertSql = "INSERT INTO Ennemy (id, Ennemy, healthPoint, attackPower, case_id)VALUES (?,?,?,?,?)";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement checkStatement = connection.prepareStatement(checkSql);
            checkStatement.setInt(1, id);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                PreparedStatement insertStatement = connection.prepareStatement(insertSql);
                insertStatement.setInt(1, System.identityHashCode(board.getBox(id)));
                insertStatement.setString(2, ennemie.getName());
                insertStatement.setInt(3, ennemie.getHealth());
                insertStatement.setInt(4, ennemie.getAttackPower());
                insertStatement.setInt(5, id);
                insertStatement.executeUpdate();
            } else {
                System.out.println("case_id does not exist in the case table");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editEnnemie(Ennemies ennemie, int id) {
        String sql = "UPDATE Ennemy SET healthPoint=? WHERE case_id= ?";
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ennemie.getHealth());
            statement.setInt(2, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
