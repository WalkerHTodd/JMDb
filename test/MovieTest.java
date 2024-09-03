import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MovieTest {

//    private String title;
//    private int year;
//    private String director;
//    private String imageLink;
//    private Actor[] actorList;
//    private String imDbRating;
//    // Might not be able to do it
//    private String movieRating;
//    private String id;
//    private String plot;
    @Test
    public void movieTest() throws Exception {
        Actor[] list = new Actor[3];

        Movie test = new Movie("Harry Potter", "JK Rowling", "123456",
                "Poster link", list, "PG", "8.0", "1937",
                "that dude gets a wand", "19 hours", "9 awards", "Action",
                "Detroit", "Latin");
        assertEquals(test.getTitle(), "Harry Potter");
        assertEquals(test.getDirector(), "JK Rowling");
        assertEquals(test.getID(), "123456");
        assertEquals(test.getPoster(), "Poster link");
        assertEquals(test.getTitle(), "Harry Potter");
        assertEquals(test.getMovieRating(), "8.0");
        assertEquals(test.getIMDBRating(), "PG");
        assertEquals(test.getYear(), 1937);
        assertEquals(test.getPlot(), "that dude gets a wand");
        assertEquals(test.getLanguages(), "Latin");
        assertEquals(test.getRunTime(), "19 hours");
        assertEquals(test.getGenres(), "Action");
        assertEquals(test.getAwards(), "9 awards");
        assertEquals(test.getCountries(), "Detroit");


    }
}
