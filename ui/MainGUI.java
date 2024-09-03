
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainGUI {
    public static JFrame frame;
    public static Dimension screenSize;
    private static JPanel currentPanel;
    private JTextField searchText;
    private JTextField searchText2;
    private JTextField searchText3;
    private JPanel searchBar;
    public static JButton backButton = new JButton();
    public static JButton actorSearchButton = new JButton();
    public static JButton invis = new JButton();
    public static JButton inivs2 = new JButton();
    public static boolean isSearched = false;

    public MainGUI() {
        frame = new JFrame();
        frame.add(searchPanel(), BorderLayout.NORTH);
        currentPanel = welcomePage();
        frame.add(currentPanel);
        display();
    }

    public static void changePanel(JPanel displayMovie) {
        frame.remove(currentPanel);
        currentPanel = displayMovie;
        frame.add(currentPanel);
        frame.revalidate();
        frame.repaint();
    }

    private void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setVisible(true);
    }

    private JPanel searchPanel() {
        searchBar = new JPanel();
        Color searchColor = new Color(51, 51, 65);

        searchBar.add(backButton);
        backButton.setVisible(false);
        backButton.setAction(backAction);
        backButton.setBounds(100, 100, 100, 100);
        backButton.setText("Back");

        searchBar.add(invis);
        invis.setText("Back");
        invis.setForeground(searchColor);
        invis.setBackground(searchColor);
        invis.setBounds(100, 100, 100, 100);
        invis.setBorder(null);

        searchText3 = new JTextField(100);
        searchText3.setColumns(10);
        searchBar.add(searchText3);
        searchText3.setBackground(searchColor);
        searchText3.setBorder(null);
        searchText3.setEditable(false);

        searchText2 = new JTextField(100);

        searchText2.setColumns(15);
        searchText2.setPreferredSize(new Dimension(1, 20));
        searchBar.add(searchText2);
        searchText2.setBackground(searchColor);
        searchText2.setBorder(null);
        searchText2.setEditable(false);

        JLabel label = new JLabel("Search ");
        label.setFont(new Font("Sherif", Font.PLAIN, 17));
        label.setForeground(Color.WHITE);
        searchText = new JTextField(20);
        searchText.setAction(searchAction);
        searchText.setColumns(22);
        JButton b = new JButton();
        b.setSize(20, 20);
        b.setAction(searchAction);
        Image icon = (new ImageIcon("cs345\\James-Madison-Database\\search-icon.png")).getImage().getScaledInstance(
                b.getWidth(), b.getHeight(), Image.SCALE_SMOOTH);
        b.setIcon(new ImageIcon(icon));
        searchBar.setVisible(true);
        searchBar.setBackground(searchColor);
        searchBar.add(label).setVisible(true);
        searchBar.add(searchText).setVisible(true);
        searchBar.add(b).setVisible(true);

        searchBar.add(actorSearchButton);
        actorSearchButton.setAction(actorSearchAction);
        actorSearchButton.setText("Actor Search ");

        searchBar.add(inivs2);
        inivs2.setBackground(searchColor);
        inivs2.setBorder(null);

        searchText2 = new JTextField(100);
        searchText2.setAction(searchAction);
        searchText2.setColumns(12);
        searchBar.add(searchText2);
        searchText2.setBackground(searchColor);
        searchText2.setBorder(null);
        searchText2.setEditable(false);

        JLabel watchListLabel = new JLabel("Watch List ");
        watchListLabel.setForeground(Color.WHITE);
        watchListLabel.setFont(new Font("Sherif", Font.PLAIN, 17));
        searchBar.add(watchListLabel);
        JComboBox wl = DropDownList.dropDown();
        searchBar.add(wl);

        return searchBar;
    }

    private JPanel welcomePage() {
//        JLabel welcomeLabel = new JLabel("JMU IMDB");
//        welcomeLabel.setForeground(Color.white);
//        welcomeLabel.setFont(new Font("Amazon Ember", Font.BOLD, 50));

        JPanel welcome = new JPanel();
//        welcome.setBounds(searchBar.getX(), searchBar.getY(), frame.WIDTH,
//                frame.HEIGHT);
//        welcome.setBackground(new Color(69, 0, 132));
//        welcome.add(welcomeLabel);
        welcome.setName("WELCOME_PAGE");
        ImageIcon backgroundGif = new ImageIcon("cs345\\James-Madison-Database\\imdb.gif");
        JLabel background = new JLabel(backgroundGif, SwingConstants.CENTER);
        welcome.setBackground(new Color(51, 51, 65));
        welcome.add(background);

        return welcome;
    }

    JPanel temp;
    Action searchAction = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
            new DataBaseWorker().execute();
        }
    };
    Action backAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            changePanel(temp);
            backButton.setVisible(false);
        }
    };

    Action actorSearchAction = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Actor[] actor = DataBase.SearchActor(searchText.getText());
                if(actor != null) {
                    temp = ActorSearchResults.showActorSearchResults(actor);
                    changePanel(temp);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
    };

    public static void main(String[] args) {
        new MainGUI();
    }

    class DataBaseWorker extends SwingWorker<Boolean, Integer> {
        Movie[] movies;

        protected Boolean doInBackground() throws Exception {
            // Do a time-consuming task.
            movies = DataBase.SearchMovie(searchText.getText());
                return true;
    

        }

        protected void done() {
            try {
                if(movies != null) {
                    temp = SearchResults.showSearchResults(movies);
                    changePanel(temp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
