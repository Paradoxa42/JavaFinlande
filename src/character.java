public class character {
    private String name;
    private String CharacterClass;
    private int level = 1;

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getCharacterClass() {
        return CharacterClass;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCharacterClass(String characterClass) {
        CharacterClass = characterClass;
    }

    public void setName(String name) {
        this.name = name;
    }
}
