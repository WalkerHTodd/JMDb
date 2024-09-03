import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MovieDisplay {

    private static final double imageScale = 0.5;
    private static final Color DARKER_BLUE = new Color(26, 36, 43);

    public static JPanel displayMovie(Movie movie) throws MalformedURLException {
        FlowLayout layout = new FlowLayout();
        layout.setHgap(40);
        MainGUI.invis.setVisible(false);
        if(MainGUI.isSearched) {
        	MainGUI.backButton.setVisible(true);
        }
        JPanel contentPane = new JPanel(layout);

        contentPane.setBorder(new EmptyBorder(50, 200, 50, 200));
        contentPane.setBackground(DARKER_BLUE);

        JPanel posterPanel = new JPanel();
        posterPanel.setOpaque(false);
        contentPane.add(posterPanel);

        JLabel poster = new JLabel();
        URL posterLink = new URL(movie.getPoster());
        ImageIcon posterImage = new ImageIcon(posterLink);
        poster.setIcon(new ImageIcon(normalizeImage(posterImage)));
        poster.setHorizontalAlignment(SwingConstants.TRAILING);
        posterPanel.add(poster);

        JPanel infoPanel = new JPanel();
        infoPanel.setOpaque(false);
        contentPane.add(infoPanel);
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(movie.getTitle());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        infoPanel.add(titleLabel);
        titleLabel.setOpaque(false);
        titleLabel.setForeground(Color.WHITE);

        JLabel yearLabel = new JLabel("Release Date: " + String.valueOf(movie.getYear()));
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(yearLabel);
        yearLabel.setOpaque(false);
        yearLabel.setForeground(Color.LIGHT_GRAY);
       
        JLabel Directors = new JLabel("Director: " + String.valueOf(movie.getDirector()));
        Directors.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(Directors);
        Directors.setOpaque(false);
        Directors.setForeground(Color.LIGHT_GRAY);

        JLabel runTime = new JLabel("Run Time: " + String.valueOf(movie.getRunTime()));
        runTime.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(runTime);
        runTime.setOpaque(false);
        runTime.setForeground(Color.LIGHT_GRAY);

        JLabel languages = new JLabel("Languages: " + String.valueOf(movie.getLanguages()));
        languages.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(languages);
        languages.setOpaque(false);
        languages.setForeground(Color.LIGHT_GRAY);

        JLabel ratingLabel = new JLabel("Content Rating: " + String.valueOf(movie.getMovieRating()));
        ratingLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(ratingLabel);
        ratingLabel.setOpaque(false);
        ratingLabel.setForeground(Color.LIGHT_GRAY);

        JLabel imdbRating = new JLabel("IMDB Rating: " + String.valueOf(movie.getIMDBRating()) + "/10.0");
        imdbRating.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(imdbRating);
        imdbRating.setOpaque(false);
        imdbRating.setForeground(Color.LIGHT_GRAY);

        JLabel genres = new JLabel("Genres: " + String.valueOf(movie.getGenres()));
        genres.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(genres);
        genres.setOpaque(false);
        genres.setForeground(Color.LIGHT_GRAY);

        JLabel countries = new JLabel("Countries: " + String.valueOf(movie.getCountries()));
        countries.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(countries);
        countries.setOpaque(false);
        countries.setForeground(Color.LIGHT_GRAY);

        JLabel awards = new JLabel("Awards: " + String.valueOf(movie.getAwards()));
        awards.setFont(new Font("Arial", Font.PLAIN, 18));
        infoPanel.add(awards);
        awards.setOpaque(false);
        awards.setForeground(Color.LIGHT_GRAY);

        JTextArea paragraph = new JTextArea();
        //paragraph.setBackground(new Color(192, 192, 192));
        paragraph.setAlignmentX(Component.LEFT_ALIGNMENT);
        paragraph.setEditable(false);
        paragraph.setWrapStyleWord(true);
        paragraph.setLineWrap(true);
        paragraph.setText("\n" + movie.getPlot() + "\n");
        paragraph.setFont(new Font("Arial", Font.PLAIN, 18));
        paragraph.setOpaque(false);
        paragraph.setColumns(30);
        paragraph.setForeground(Color.WHITE);
        infoPanel.add(paragraph);

        JTextArea actorListLabel = new JTextArea();
        //paragraph.setBackground(new Color(192, 192, 192));
        actorListLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        actorListLabel.setEditable(false);
        actorListLabel.setWrapStyleWord(true);
        actorListLabel.setLineWrap(true);
        actorListLabel.setForeground(Color.WHITE);
        Actor[] actorlist = movie.getActorList();
        String actorTest = "Stars: \n";
        for (Actor actor : actorlist) {
            if (actor != null) {
                actorTest += "    " + String.valueOf(actor.getName()) + " (" + actor.getCharecter() + ")" + "\n";
            }
        }
        actorListLabel.setText(actorTest);
        actorListLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        actorListLabel.setOpaque(false);
        actorListLabel.setColumns(30);
        infoPanel.add(actorListLabel);
        

        
        EditWatchList button = new EditWatchList(movie);
        button.setBorder(new EmptyBorder(20,0,0,0));
        infoPanel.add(button.getButton());


        return contentPane;
    }

    private static Image normalizeImage(ImageIcon image) {

        Dimension dimensions = MainGUI.screenSize;
        double idealHeight = dimensions.height * imageScale;
        double idealWidth = (idealHeight / image.getIconHeight()) * image.getIconWidth();
        // System.out.println(dimensions);
        // System.out.println(idealWidth + " " + idealHeight);

        return image.getImage().getScaledInstance((int) idealWidth, (int) idealHeight, Image.SCALE_SMOOTH);
    }
}
