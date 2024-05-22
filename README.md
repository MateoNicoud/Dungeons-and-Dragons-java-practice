```mermaid
classDiagram
    class hero {
        -String name
        -String job
        -Inventory inventory
        -boolean secondaryHand
        -int health
        -int attackPower
        -int defensePower
        -OffensiveEquipment OffensiveEquipment
        -DefensiveEquipment DefensiveEquipment
        +hero(String, boolean)
        +void addToInventory(Items)
        +void displayInventory()
        +void displayCharacter()
        +boolean getIsSecondaryHand()
        +String getName()
        +String getJob()
        +void setJob(String)
        +boolean isSecondaryHand()
        +int getHealth()
        +void setHealth(int)
        +int getAttackPower()
        +void setAttackPower(int)
        +int getDefensePower()
        +void setDefensePower(int)
        +OffensiveEquipment getOffensiveEquipment()
        +void setOffensiveEquipment(OffensiveEquipment)
        +DefensiveEquipment getDefensiveEquipment()
        +void setDefensiveEquipment(DefensiveEquipment)
    }
    class Warrior {
        +Warrior(String, String, boolean)
    }
    class Inventory {
        -ArrayList<Items> items
        +Inventory()
        +void addItems(Items)
        +void removeItems(Items)
        +void displayInventory()
    }
    class Items {
        -String name
        -String type
        +Items(String, String)
        +String getName()
        +void setName(String)
        +String getType()
        +void setType(String)
    }
    class DefensiveEquipment {
        <<abstract>>
        -int defensePower
        +DefensiveEquipment(String, String, int)
        +int getDefensePower()
        +void setDefensePower(int)
    }
    class ArcaneShield {
        +ArcaneShield()
    }
    class PaperCraftShield {
        +PaperCraftShield()
    }
    class OffensiveEquipment {
        <<abstract>>
        -int attackPower
        +OffensiveEquipment(String, String, int)
        +int getAttackPower()
        +void setAttackPower(int)
    }
    class FoamSword {
        +FoamSword()
    }
    class WoodStick {
        +WoodStick()
    }
    class CharacterOutOfBounds {
        <<Exception>>
        -String errorMessage
        +CharacterOutOfBounds(String)
    }
    class Menu {
        -Scanner reader
        +Menu()
        +void displayMenu()
        +String getRestartResponse()
        +String getCharacterName()
        +String getCharacterJob()
        +boolean getSecondHand()
        +void getEnter()
    }
    class Game {
        +Game()
        +void startGame()
        +void playGame()
    }
    class Main {
        +void main(String[] args)
    }
    class DatabaseConnection{
        +getConnection()
        -String DATABASE_URL
        -String DATABASE_USER 
        -String DATABASE_PASSWORD
    }
    class RequestDatabase{
    +RequestDatabase()
    +void createHero(Board board, Hero character)
    +void getHeroes()
    +void editHero(Board board, Hero character) 
    +void deleteAllData()
    +void deleteHero() 
    +void deleteDefensiveEquipement() 
    +void deleteOffensiveEquipement()
    +void deleteBoard()
    +void deleteCase()
    +void deleteMysteryBox()
    +void deleteEnnemie()
    +void executeUpdate(String sql) 
    +void getDefensiveEquipments() 
    +void insertDefensiveEquipment(Hero character, DefensiveEquipment defensiveEquipment)
    +void editDefensiveEquipment(Hero character, DefensiveEquipment defensiveEquipment)
    +deleteDefensiveEquipment(int id) 
    +void getOffensiveEquipments() 
    +insertOffensiveEquipment(Hero character, OffensiveEquipment offensiveEquipment)
    +editOffensiveEquipment(Hero character, OffensiveEquipment offensiveEquipment)
    +deleteDOffensiveEquipment(Hero character) 
    +editBoard(Hero character, int id_case, int id)
    +void insertBoard(Hero character, int id_case, int id)
    +void createBox(Board board, Hero character, int id)
    +insertMysteryBox(Items item, Board board, int id)
    +insertEnnemie(Ennemies ennemie, Board board, int id)
    +editEnnemie(Ennemies ennemie, int id)
    +void getEnnemyFromDatabase(Board board, int boardId, ArrayList<Box> boxes)
    +void getMysteryBoxFromDatabase(Board board, int boardId, ArrayList<Box> boxes)
    +void getHeroPosition(int boardId)
    }
    hero <|-- Warrior
    hero *-- Inventory
    hero *-- OffensiveEquipment
    hero *-- DefensiveEquipment
    Inventory *-- Items
    Items <|-- DefensiveEquipment
    Items <|-- OffensiveEquipment
    DefensiveEquipment <|-- ArcaneShield
    DefensiveEquipment <|-- PaperCraftShield
    OffensiveEquipment <|-- FoamSword
    OffensiveEquipment <|-- WoodStick
    CharacterOutOfBounds ..> Game : throws
    Game *-- Menu
    Main *-- Game
    Game *-- RequestDatabase
    RequestDatabase *-- DatabaseConnection