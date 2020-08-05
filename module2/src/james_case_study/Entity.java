package james_case_study;

import java.util.Arrays;

public class Entity {
    private String name;
    private String pronoun;
    private String meaning;
    private String wordClass;
    private String[] synonym;

    public Entity() {
        name = null;
        meaning = null;
        pronoun = null;
        wordClass = null;
        synonym = null;
    }

    public Entity(String name, String pronoun, String meaning, String wordClass, String[] synonym) {
        this.name = name;
        this.pronoun = pronoun;
        this.meaning = meaning;
        this.wordClass = wordClass;
        this.synonym = synonym;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getWordClass() {
        return wordClass;
    }

    public void setWordClass(String wordClass) {
        this.wordClass = wordClass;
    }

    public String[] getSynonym() {
        return synonym;
    }

    public void setSynonym(String[] synonym) {
        this.synonym = synonym;
    }

    @Override
    public String toString() {
        return "@'" + name + '\'' + "\n" +
                "* Pronoun: /" + pronoun + "/" + "\n" +
                "* Word Class: " + wordClass + "\n" +
                "* Meaning: " + meaning + "\n" +
                "* Synonym: " + Arrays.toString(synonym);
    }
}
