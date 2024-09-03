import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DropDownList {
    private static DefaultComboBoxModel<Movie> movieList;
    private static JComboBox<Movie> movies;

    public static JComboBox<Movie> dropDown() {
        try {
            movieList = new DefaultComboBoxModel<Movie>();
            List<Movie> a = readMovieList();
            for (Movie movie : a) {
                movieList.addElement(movie);
            }
            movies = new JComboBox<>(movieList);

            movies.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (movies.getSelectedItem() != null) {
                        Movie movie = (Movie) movies.getSelectedItem();
                        try {
                            MainGUI.changePanel(
                                    MovieDisplay.displayMovie(movie));
                        } catch (MalformedURLException e1) {

                        }
                    }

                }
            });

        } catch (Exception e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        return movies;
    }

    public static DefaultComboBoxModel<Movie> movieList() {
        return movieList;
    }

    public static void add(Movie title) {
        movieList.addElement(title);
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Movie> a = new ArrayList<Movie>();
        try {
            for (int i = 0; i < movieList.getSize(); i++) {
                a.add(movieList.getElementAt(i));
            }
            mapper.writeValue(new File("watchlist.json"), a);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.err.println("Error writing to file");
            e.printStackTrace();

        }

    }

    public static void remove(Movie title) {
        boolean inList = false;
        for (int i = 0; i < movieList.getSize(); i++) {
            if (movieList.getElementAt(i).getTitle().equals(title.getTitle())) {
                movieList.removeElement(movieList.getElementAt(i));
            }
        }

        // movieList.removeElement(title);
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Movie> a = new ArrayList<Movie>();
        try {
            for (int i = 0; i < movieList.getSize(); i++) {
                a.add(movieList.getElementAt(i));
            }
            mapper.writeValue(new File("watchlist.json"), a);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static List<Movie> readMovieList() throws IOException {
        FileInputStream input = new FileInputStream("cs345\\James-Madison-Database\\ui\\watchlist.json");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree = mapper.readTree(input);
        List<Movie> newMovies = new ArrayList<Movie>();

        for (JsonNode movie : tree) {
            String title = movie.get("title").asText();
            String ID = movie.get("id").asText();
            String director = movie.get("director").asText();
            String year = movie.get("year").asText();
            String image = movie.get("poster").asText();
            String contentRating = movie.get("movieRating").asText();
            String imDbRating = movie.get("imdbrating").asText();
            String plot = movie.get("plot").asText();
            String runTime = movie.get("runTime").asText();
            String awards = movie.get("awards").asText();
            String genres = movie.get("genres").asText();
            String countries = movie.get("countries").asText();
            String languages = movie.get("languages").asText();
            Actor[] actorList = new Actor[5];

            for (int i = 0; i < 4; i++) {
                try {
                    String name = movie.get("actorList").get(i).get(
                            "name").asText();
                    String id1 = movie.get("actorList").get(i).get(
                            "id").asText();
                    String image1 = movie.get("actorList").get(i).get(
                            "image").asText();
                    String charecter = movie.get("actorList").get(i).get(
                            "asCharacter").asText();
                    actorList[i] = new Actor(name, id1, image1, charecter);
                } catch (NullPointerException e) {
                    System.out.println("None");
                }

            }
            Movie tempMovie = new Movie(title, director, ID, image, actorList,
                    imDbRating, contentRating, year, plot, runTime, awards,
                    genres, countries, languages);
            newMovies.add(tempMovie);
        }
        return newMovies;
    }

}
