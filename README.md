# D&D (dev, practice)

Ce projet est un mini-jeu développé en Java. Le but de ce jeu était de m'initier à Java. Une connexion à une base de données est nécessaire pour le système de sauvegarde. Un conteneur Docker est disponible [ici](https://hub.docker.com/r/mateonicoud/java).

[//]: # (```mermaid)

[//]: # (classDiagram)

[//]: # (    class hero {)

[//]: # (        -String name)

[//]: # (        -String job)

[//]: # (        -Inventory inventory)

[//]: # (        -boolean secondaryHand)

[//]: # (        -int health)

[//]: # (        -int attackPower)

[//]: # (        -int defensePower)

[//]: # (        -OffensiveEquipment OffensiveEquipment)

[//]: # (        -DefensiveEquipment DefensiveEquipment)

[//]: # (        +hero&#40;String, boolean&#41;)

[//]: # (        +void addToInventory&#40;Items&#41;)

[//]: # (        +void displayInventory&#40;&#41;)

[//]: # (        +void displayCharacter&#40;&#41;)

[//]: # (        +boolean getIsSecondaryHand&#40;&#41;)

[//]: # (        +String getName&#40;&#41;)

[//]: # (        +String getJob&#40;&#41;)

[//]: # (        +void setJob&#40;String&#41;)

[//]: # (        +boolean isSecondaryHand&#40;&#41;)

[//]: # (        +int getHealth&#40;&#41;)

[//]: # (        +void setHealth&#40;int&#41;)

[//]: # (        +int getAttackPower&#40;&#41;)

[//]: # (        +void setAttackPower&#40;int&#41;)

[//]: # (        +int getDefensePower&#40;&#41;)

[//]: # (        +void setDefensePower&#40;int&#41;)

[//]: # (        +OffensiveEquipment getOffensiveEquipment&#40;&#41;)

[//]: # (        +void setOffensiveEquipment&#40;OffensiveEquipment&#41;)

[//]: # (        +DefensiveEquipment getDefensiveEquipment&#40;&#41;)

[//]: # (        +void setDefensiveEquipment&#40;DefensiveEquipment&#41;)

[//]: # (    })

[//]: # (    class Warrior {)

[//]: # (        +Warrior&#40;String, String, boolean&#41;)

[//]: # (    })

[//]: # (    class Wizard {)

[//]: # (        +Wizard&#40;String, String, boolean&#41;)

[//]: # (    })

[//]: # (    class Inventory {)

[//]: # (        -ArrayList<Items> items)

[//]: # (        +Inventory&#40;&#41;)

[//]: # (        +void addItems&#40;Items&#41;)

[//]: # (        +void removeItems&#40;Items&#41;)

[//]: # (        +void displayInventory&#40;&#41;)

[//]: # (    })

[//]: # (    class Items {)

[//]: # (        -String name)

[//]: # (        -String type)

[//]: # (        +Items&#40;String, String&#41;)

[//]: # (        +String getName&#40;&#41;)

[//]: # (        +void setName&#40;String&#41;)

[//]: # (        +String getType&#40;&#41;)

[//]: # (        +void setType&#40;String&#41;)

[//]: # (    })

[//]: # (    class DefensiveEquipment {)

[//]: # (        <<abstract>>)

[//]: # (        -int defensePower)

[//]: # (        +DefensiveEquipment&#40;String, String, int&#41;)

[//]: # (        +int getDefensePower&#40;&#41;)

[//]: # (        +void setDefensePower&#40;int&#41;)

[//]: # (    })

[//]: # (    class ArcaneShield {)

[//]: # (        +ArcaneShield&#40;&#41;)

[//]: # (    })

[//]: # (    class PaperCraftShield {)

[//]: # (        +PaperCraftShield&#40;&#41;)

[//]: # (    })

[//]: # (        class LoadedShield {)

[//]: # (        +LoadedShield&#40;String, String, int&#41;)

[//]: # (    })

[//]: # (    class OffensiveEquipment {)

[//]: # (        <<abstract>>)

[//]: # (        -int attackPower)

[//]: # (        +OffensiveEquipment&#40;String, String, int&#41;)

[//]: # (        +int getAttackPower&#40;&#41;)

[//]: # (        +void setAttackPower&#40;int&#41;)

[//]: # (    })

[//]: # (    class FoamSword {)

[//]: # (        +FoamSword&#40;&#41;)

[//]: # (    })

[//]: # (    class WoodStick {)

[//]: # (        +WoodStick&#40;&#41;)

[//]: # (    })

[//]: # (    class ExcaliburSword{)

[//]: # (        +ExcaliburSword&#40;&#41;)

[//]: # (    })

[//]: # (    class EldritchStaff{)

[//]: # (        +EldritchStaff&#40;&#41;)

[//]: # (    })

[//]: # (    class LoadedOffensive{)

[//]: # (        +LoadedOffensive&#40;String, String, int&#41;)

[//]: # (    })

[//]: # (    class CharacterOutOfBounds {)

[//]: # (        <<Exception>>)

[//]: # (        -String errorMessage)

[//]: # (        +CharacterOutOfBounds&#40;String&#41;)

[//]: # (    })

[//]: # (    class Menu {)

[//]: # (        -Scanner reader)

[//]: # (        +Menu&#40;&#41;)

[//]: # (        +void displayMenu&#40;&#41;)

[//]: # (        +String getRestartResponse&#40;&#41;)

[//]: # (        +String getCharacterName&#40;&#41;)

[//]: # (        +String getCharacterJob&#40;&#41;)

[//]: # (        +boolean getSecondHand&#40;&#41;)

[//]: # (        +void getEnter&#40;&#41;)

[//]: # (    })

[//]: # (    class Game {)

[//]: # (        +Game&#40;&#41;)

[//]: # (        +void startGame&#40;&#41;)

[//]: # (        +void playGame&#40;&#41;)

[//]: # (    })

[//]: # (    class Main {)

[//]: # (        +void main&#40;String[] args&#41;)

[//]: # (    })

[//]: # (    class DatabaseConnection{)

[//]: # (        +getConnection&#40;&#41;)

[//]: # (        -String DATABASE_URL)

[//]: # (        -String DATABASE_USER )

[//]: # (        -String DATABASE_PASSWORD)

[//]: # (    })

[//]: # (    class LoadedConsumable{)

[//]: # (        +LoadedConsumable&#40;String,String,int&#41;)

[//]: # (    })

[//]: # (    class Consumable{)

[//]: # (        +Consumable&#40;String,String,int&#41;)

[//]: # (    })

[//]: # (    class GreatPotion{)

[//]: # (        +GreatPotion&#40;&#41;)

[//]: # (    })

[//]: # (    class StandardPotion{)

[//]: # (        +StandardPotion&#40;&#41;)

[//]: # (    })

[//]: # (    class GreatPotion{)

[//]: # (        +GreatPotion&#40;&#41;)

[//]: # (    })

[//]: # (    class RequestDatabase{)

[//]: # (    +RequestDatabase&#40;&#41;)

[//]: # (    +void createHero&#40;Board board, Hero character&#41;)

[//]: # (    +void getHeroes&#40;&#41;)

[//]: # (    +void editHero&#40;Board board, Hero character&#41; )

[//]: # (    +void deleteAllData&#40;&#41;)

[//]: # (    +void deleteHero&#40;&#41; )

[//]: # (    +void deleteDefensiveEquipement&#40;&#41; )

[//]: # (    +void deleteOffensiveEquipement&#40;&#41;)

[//]: # (    +void deleteBoard&#40;&#41;)

[//]: # (    +void deleteCase&#40;&#41;)

[//]: # (    +void deleteMysteryBox&#40;&#41;)

[//]: # (    +void deleteEnnemie&#40;&#41;)

[//]: # (    +void executeUpdate&#40;String sql&#41; )

[//]: # (    +void getDefensiveEquipments&#40;&#41; )

[//]: # (    +void insertDefensiveEquipment&#40;Hero character, DefensiveEquipment defensiveEquipment&#41;)

[//]: # (    +void editDefensiveEquipment&#40;Hero character, DefensiveEquipment defensiveEquipment&#41;)

[//]: # (    +deleteDefensiveEquipment&#40;int id&#41; )

[//]: # (    +void getOffensiveEquipments&#40;&#41; )

[//]: # (    +insertOffensiveEquipment&#40;Hero character, OffensiveEquipment offensiveEquipment&#41;)

[//]: # (    +editOffensiveEquipment&#40;Hero character, OffensiveEquipment offensiveEquipment&#41;)

[//]: # (    +deleteDOffensiveEquipment&#40;Hero character&#41; )

[//]: # (    +editBoard&#40;Hero character, int id_case, int id&#41;)

[//]: # (    +void insertBoard&#40;Hero character, int id_case, int id&#41;)

[//]: # (    +void createBox&#40;Board board, Hero character, int id&#41;)

[//]: # (    +insertMysteryBox&#40;Items item, Board board, int id&#41;)

[//]: # (    +insertEnnemie&#40;Ennemies ennemie, Board board, int id&#41;)

[//]: # (    +editEnnemie&#40;Ennemies ennemie, int id&#41;)

[//]: # (    +void getEnnemyFromDatabase&#40;Board board, int boardId, ArrayList<Box> boxes&#41;)

[//]: # (    +void getMysteryBoxFromDatabase&#40;Board board, int boardId, ArrayList<Box> boxes&#41;)

[//]: # (    +void getHeroPosition&#40;int boardId&#41;)

[//]: # (    })

[//]: # (    class Box{)

[//]: # (    +void interaction&#40;Hero,Board&#41;)

[//]: # (    })

[//]: # (    <<interface>> Box)

[//]: # (    class Ennemies{)

[//]: # (        -int health)

[//]: # (        -Hero character)

[//]: # (        -String name)

[//]: # (        -int attackPower)

[//]: # (        -int id)

[//]: # (        +interaction&#40;Hero,Board&#41;)

[//]: # (    })

[//]: # (    class LoadedEnnemie{)

[//]: # (        +LoadedEnnemie&#40;String,int,int&#41;)

[//]: # (    })

[//]: # (    class Goblin{)

[//]: # (        +Goblin&#40;&#41;)

[//]: # (    })

[//]: # (    class Dragon{)

[//]: # (        +Dragon&#40;&#41;)

[//]: # (    })

[//]: # (    class Sorcerer{)

[//]: # (        +Sorcerer&#40;&#41;)

[//]: # (    })

[//]: # (    class MysteryBox{)

[//]: # (        +MysteryBox&#40;&#41;)

[//]: # (        -Hero character)

[//]: # (        -int id)

[//]: # (        -List<items> items)

[//]: # (        +interaction&#40;Hero,Board&#41;)

[//]: # (    })

[//]: # (    class EmptyBox{)

[//]: # (        +EmptyBox&#40;&#41;)

[//]: # (        -Hero character)

[//]: # (        +interaction&#40;Hero,Board&#41;)

[//]: # (    })

[//]: # (    hero <|-- Warrior)

[//]: # (    hero <|-- Wizard)

[//]: # (    hero *-- Inventory)

[//]: # (    hero *-- OffensiveEquipment)

[//]: # (    hero *-- DefensiveEquipment)

[//]: # (    Inventory *-- Items)

[//]: # (    Items <|-- DefensiveEquipment)

[//]: # (    Items <|-- OffensiveEquipment)

[//]: # (    Items <|-- Consumable)

[//]: # (    DefensiveEquipment <|-- ArcaneShield)

[//]: # (    DefensiveEquipment <|-- PaperCraftShield)

[//]: # (    DefensiveEquipment <|-- LoadedShield)

[//]: # (    OffensiveEquipment <|-- LoadedOffensive)

[//]: # (    OffensiveEquipment <|-- ExcaliburSword)

[//]: # (    OffensiveEquipment <|-- EldritchStaff)

[//]: # (    OffensiveEquipment <|-- FoamSword)

[//]: # (    OffensiveEquipment <|-- WoodStick)

[//]: # (    Consumable <|-- GreatPotion)

[//]: # (    Consumable <|-- StandardPotion)

[//]: # (    Consumable <|-- LoadedConsumable)

[//]: # (    Ennemies <|-- Dragon)

[//]: # (    Ennemies <|-- Goblin)

[//]: # (    Ennemies <|-- Sorcerer)

[//]: # (    Ennemies <|-- LoadedEnnemie)

[//]: # (    Box <|-- EmptyBox)

[//]: # (    Box <|-- Ennemies)

[//]: # (    Box <|-- MysteryBox)

[//]: # (    CharacterOutOfBounds ..> Game : throws)

[//]: # (    Game *-- Menu)

[//]: # (    Main *-- Game)

[//]: # (    Game *-- RequestDatabase)

[//]: # (    Box *-- Ennemies)

[//]: # (    RequestDatabase *-- DatabaseConnection)