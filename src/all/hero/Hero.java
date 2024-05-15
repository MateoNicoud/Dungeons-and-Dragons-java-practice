package all.hero;

import java.sql.*;

import all.Board;
import all.Ennemies.Ennemies;
import all.MysteryBox;
import all.Stuff.DefensiveEquipment;
import all.Stuff.Items;
import all.Stuff.OffensiveEquipment;

public abstract class Hero {


    private final String name;
    private String job;
    private final Inventory inventory;

    private int id = System.identityHashCode(this);


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }


    private final boolean secondaryHand;
    private int health = 0;
    private int attackPower = 0;
    private int defensePower = 0;
    private all.Stuff.OffensiveEquipment OffensiveEquipment;
    private all.Stuff.DefensiveEquipment DefensiveEquipment;

    public int getBaseAttackPower() {
        return baseAttackPower;
    }


    private final int baseAttackPower;

    public Hero(String name, boolean secondaryHand, int baseAttackPower) {
        this.name = name;
        this.secondaryHand = secondaryHand;
        this.inventory = new Inventory();
        this.baseAttackPower = baseAttackPower;
    }

    public void addToInventory(Items item) {
        this.inventory.addItems(item);
    }

    public void displayInventory() {
        this.inventory.displayInventory();
    }


    public void displayCharacter() {
        System.out.println("Voici un résumé de votre personnage:");
        System.out.println("Nom: " + name);
        System.out.println("Job: " + job);
        System.out.println("Santé: " + health);
        System.out.println("Défense: " + defensePower);
        System.out.println("Puissance d'attaque: " + attackPower);
        System.out.println("Equipement offensif: " + OffensiveEquipment);
        if (DefensiveEquipment != null) {
            System.out.println("Equipement défensif: " + DefensiveEquipment);
        }
    }


    public void createHero(Board board, Hero character) {
        String sql = "INSERT INTO hero (id, name, job, healthPoint, attackPower, defensePower, position) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.id);
            statement.setString(2, this.job);
            statement.setString(3, this.name);
            statement.setInt(4, this.health);
            statement.setInt(5, this.attackPower);
            statement.setInt(6, this.defensePower);
            int characterPosition = board.getBoxOfCharacter(character);
            statement.setInt(4, characterPosition);
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
        String sql = "UPDATE hero SET  healthPoint = ?, attackPower = ?, defensePower = ?, position = ? WHERE id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.health);
            statement.setInt(2, (this.attackPower+this.OffensiveEquipment.getAttackPower()));
            statement.setInt(3, (this.defensePower+this.DefensiveEquipment.getDefensePower()));
            int characterPosition = board.getBoxOfCharacter(character);
            statement.setInt(4, characterPosition);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHero() {
        String sql = "DELETE FROM hero";

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

    public void editDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        String sql = "UPDATE defensiveEquipement SET name = ?, type = ?, defensePower = ? WHERE Hero_id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, defensiveEquipment.getName());
            statement.setString(2, defensiveEquipment.getType());
            statement.setInt(3, defensiveEquipment.getDefensePower());
            statement.setInt(4, this.id);

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

    public void editOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        String sql = "UPDATE offensiveEquipement SET name = ?, type = ?, attackPower = ? WHERE Hero_id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, offensiveEquipment.getName());
            statement.setString(2, offensiveEquipment.getType());
            statement.setInt(3, offensiveEquipment.getAttackPower());
            statement.setInt(4, this.id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDOffensiveEquipment() {
        String sql = "DELETE FROM offensiveEquipement WHERE Hero_id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void editBoard(Board board) {
        String sql = "UPDATE board SET id = ? WHERE Hero_id=? && case_id=case.id";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, System.identityHashCode(board));
            statement.setInt(2, this.id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createBox(Board board, Hero character, int id) {
        String sql = "INSERT INTO case (id, content) VALUES (?, ?)";
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            if (board.getBox(id) instanceof Ennemies) {
                statement.setString(2, "Monster");
            } else if (board.getBox(id) instanceof MysteryBox) {
                statement.setString(2, board.getBox(id).toString());
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean getIsSecondaryHand() {
        return secondaryHand;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean isSecondaryHand() {
        return secondaryHand;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public OffensiveEquipment getOffensiveEquipment() {
        return OffensiveEquipment;
    }

    public void setOffensiveEquipment(OffensiveEquipment offensiveEquipment) {
        OffensiveEquipment = offensiveEquipment;
    }

    public DefensiveEquipment getDefensiveEquipment() {
        return DefensiveEquipment;
    }

    public void setDefensiveEquipment(DefensiveEquipment defensiveEquipment) {
        DefensiveEquipment = defensiveEquipment;
    }
}
