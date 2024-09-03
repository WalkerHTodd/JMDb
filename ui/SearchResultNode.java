import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchResultNode extends JPanel {

    JButton button;
    URL posterImage;

    public SearchResultNode(Movie movie) throws MalformedURLException {
        super(new BorderLayout());

        setBackground(new Color(30, 41, 49));
        setPreferredSize(new Dimension(192, 360));

        button = new JButton();
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        if (movie.getPoster().isEmpty()) {
            button.setIcon(new ImageIcon("nopicture.jpg"));
        } else {
            posterImage = new URL("https://imdb-api.com/API/ResizeImage?apikey=k_mcx0w8kk&size=192x264&url=" + movie.getPoster());
            button.setIcon(new ImageIcon(posterImage));
        }
        // System.out.println(posterImage);

        JLabel title = new JLabel("<html>"+ movie.getTitle() +"</html>");
        title.setBorder(new EmptyBorder(10, 10, 10, 10));
        title.setForeground(new Color(255,255,255));
        title.setFont(new Font("Dialog", Font.BOLD, 13));

        add(button, BorderLayout.NORTH);
        add(title);

        button.addActionListener(e -> {
            try {
                MainGUI.changePanel(MovieDisplay.displayMovie(DataBase.SearchMovieByID(movie.getID())));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }
}
