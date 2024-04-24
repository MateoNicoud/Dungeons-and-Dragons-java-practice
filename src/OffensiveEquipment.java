public abstract class OffensiveEquipment {
    private final String name;

    public OffensiveEquipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    // Vous pouvez ajouter d'autres méthodes et attributs communs à tous les équipements défensifs ici
}