import javax.swing.JFrame;
import javax.swing.JPanel;

public class SearchBarTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Visual Bookz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.pack();
        frame.setVisible(true);
        JPanel main = new JPanel();
        frame.add(main);
        Movie[] test = new Movie[3];
        ///Movie fake1 = new Movie("Inception", "1975", "");
        //Movie fake2 = new Movie("Pulp Fiction", "1975", "");
        //Movie fake3 = new Movie("Harry Potter", "1975", "");
        //test[0] = fake1;
        //test[1] = fake2;
        //test[2] = fake3;

        //SearchResults.showSearchResults(test);
    }

}
