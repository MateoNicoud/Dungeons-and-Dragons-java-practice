package all.hero;

import java.sql.*;

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


    public void createHero() {
        String sql = "INSERT INTO dd (id, job, name, healthPoint, attackPower, defensePower, offensiveEquipement, DefensiveEquipment) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.id);
            statement.setString(2, this.job);
            statement.setString(3, this.name);
            statement.setInt(4, this.health);
            statement.setInt(5, this.attackPower);
            statement.setInt(6, this.defensePower);
            statement.setString(7, this.OffensiveEquipment != null ? this.OffensiveEquipment.toString() : null);
            statement.setString(8, this.DefensiveEquipment != null ? this.DefensiveEquipment.toString() : null);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An hero was created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getHeroes() {
        String sql = "SELECT * FROM dd";
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

    public void editHero() {
        String sql = "UPDATE dd SET  healthPoint = ?, attackPower = ?, defensePower = ?, offensiveEquipement = ?, DefensiveEquipment = ? WHERE id = ?";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, this.health);
            statement.setInt(2, this.attackPower);
            statement.setInt(3, this.defensePower);
            statement.setString(4, this.OffensiveEquipment != null ? this.OffensiveEquipment.toString() : null);
            statement.setString(5, this.DefensiveEquipment != null ? this.DefensiveEquipment.toString() : null);
            statement.setInt(6, this.id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing hero was updated successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHero() {
        String sql = "DELETE FROM dd";

        try (Connection connection = all.DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A hero was deleted successfully!");
            }
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
