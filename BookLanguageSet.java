package system.book;

import java.util.HashSet;
import java.util.Set;

/**
 * Manages a set of book languages, allowing languages to be added and providing a string representation of the language set.
 */
public class BookLanguageSet {
    private final Set<String> languageSet = new HashSet<String>();

    /**
     * Constructs a new BookLanguageSet with an empty language set.
     */
    public BookLanguageSet() {}

    /**
     * Adds a language to the set.
     *
     * @param language The language to be added.
     */
    public void addLanguage(String language) {
        languageSet.add(language);
    }

    /**
     * Returns a string representation of the language set.
     *
     * @return A string listing all languages in the set, sorted and separated by commas.
     */
    @Override
    public String toString() {
        StringBuilder langSet = new StringBuilder("LanguageSet: ");
        languageSet.stream().sorted().forEach(language -> langSet.append(language).append(", "));
        // Remove the trailing comma and space
        return langSet.substring(0, langSet.length() - 2);
    }
}
