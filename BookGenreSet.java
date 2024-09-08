package system.book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Manages a set of book genres, allowing genres to be added and providing a string representation of the genre set.
 */
public class BookGenreSet {
    private final Set<String> genreSet = new HashSet<String>();

    /**
     * Constructs a new BookGenreSet with an empty genre set.
     */
    public BookGenreSet() {}

    /**
     * Adds a genre to the set.
     *
     * @param genre The genre to be added.
     */
    public void addGenre(String genre) {
        genreSet.add(genre);
    }

    /**
     * Returns a string representation of the genre set.
     *
     * @return A string listing all genres in the set, sorted and separated by commas.
     */
    @Override
    public String toString() {
        StringBuilder setGenre = new StringBuilder("GenreSet: ");
        genreSet.stream().filter(Objects::nonNull).sorted().forEach(genre -> setGenre.append(genre).append(", "));
        // Remove the trailing comma and space
        return setGenre.substring(0, setGenre.length() - 2);
    }
}
