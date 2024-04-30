```mermaid
classDiagram
    class Character {
        -String name
        -String job
        -Inventory inventory
        -boolean secondaryHand
        -int health
        -int attackPower
        -int defensePower
        -OffensiveEquipment OffensiveEquipment
        -DefensiveEquipment DefensiveEquipment
        +Character(String, boolean)
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
    Character <|-- Warrior
    Character *-- Inventory
    Character *-- OffensiveEquipment
    Character *-- DefensiveEquipment
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