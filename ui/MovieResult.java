import javax.swing.*;

/**
 * Potential class to encapsulate a movie result to make search results more dynamic.
 */
public class MovieResult {

    public static JPanel createMovieResult(Movie movie) {
        JPanel movieButton = new JPanel();
        JLabel label = new JLabel(String.format("%s (%s)", movie.getTitle(), movie.getYear()));
        // System.out.println(label);

        return movieButton;
    }
}
