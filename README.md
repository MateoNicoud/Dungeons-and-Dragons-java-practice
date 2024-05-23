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
    class Wizard {
        +Wizard(String, String, boolean)
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
        class LoadedShield {
        +LoadedShield(String, String, int)
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
    class ExcaliburSword{
        +ExcaliburSword()
    }
    class EldritchStaff{
        +EldritchStaff()
    }
    class LoadedOffensive{
        +LoadedOffensive(String, String, int)
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
    class LoadedConsumable{
        +LoadedConsumable(String,String,int)
    }
    class Consumable{
        +Consumable(String,String,int)
    }
    class GreatPotion{
        +GreatPotion()
    }
    class StandardPotion{
        +StandardPotion()
    }
    class GreatPotion{
        +GreatPotion()
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
    class Box{
    +void interaction(Hero,Board)
    }
    <<interface>> Box
    class Ennemies{
        -int health
        -Hero character
        -String name
        -int attackPower
        -int id
        +interaction(Hero,Board)
    }
    class LoadedEnnemie{
        +LoadedEnnemie(String,int,int)
    }
    class Goblin{
        +Goblin()
    }
    class Dragon{
        +Dragon()
    }
    class Sorcerer{
        +Sorcerer()
    }
    class MysteryBox{
        +MysteryBox()
        -Hero character
        -int id
        -List<items> items
        +interaction(Hero,Board)
    }
    class EmptyBox{
        +EmptyBox()
        -Hero character
        +interaction(Hero,Board)
    }
    hero <|-- Warrior
    hero <|-- Wizard
    hero *-- Inventory
    hero *-- OffensiveEquipment
    hero *-- DefensiveEquipment
    Inventory *-- Items
    Items <|-- DefensiveEquipment
    Items <|-- OffensiveEquipment
    Items <|-- Consumable
    DefensiveEquipment <|-- ArcaneShield
    DefensiveEquipment <|-- PaperCraftShield
    DefensiveEquipment <|-- LoadedShield
    OffensiveEquipment <|-- LoadedOffensive
    OffensiveEquipment <|-- ExcaliburSword
    OffensiveEquipment <|-- EldritchStaff
    OffensiveEquipment <|-- FoamSword
    OffensiveEquipment <|-- WoodStick
    Consumable <|-- GreatPotion
    Consumable <|-- StandardPotion
    Consumable <|-- LoadedConsumable
    Ennemies <|-- Dragon
    Ennemies <|-- Goblin
    Ennemies <|-- Sorcerer
    Ennemies <|-- LoadedEnnemie
    Box <|-- EmptyBox
    Box <|-- Ennemies
    Box <|-- MysteryBox
    CharacterOutOfBounds ..> Game : throws
    Game *-- Menu
    Main *-- Game
    Game *-- RequestDatabase
    Box *-- Ennemies
    RequestDatabase *-- DatabaseConnection