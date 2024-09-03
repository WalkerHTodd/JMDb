import java.awt.*;
import java.net.MalformedURLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SearchResults {

	private static final Color DARKER_BLUE = new Color(26, 36, 43);

	public static JPanel showSearchResults(Movie[] results) {
		MainGUI.backButton.setVisible(false);
		MainGUI.isSearched = true;

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setBackground(DARKER_BLUE);

		JLabel resultLabel = new JLabel(results.length + " Results");
		resultLabel.setForeground(new Color(255,255,255));
		resultLabel.setFont(new Font("Dialog", Font.PLAIN, 40));
		resultLabel.setBorder(new EmptyBorder(50,55,8,100));

		JPanel movies = new JPanel(new FlowLayout());
		movies.setBackground(DARKER_BLUE);
		JScrollPane scroll = new JScrollPane(movies, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setAlignmentX(Component.LEFT_ALIGNMENT);
		scroll.getHorizontalScrollBar().setUnitIncrement(80);
		scroll.setBorder(new EmptyBorder(0, 40, 0, 40));
		scroll.setBackground(DARKER_BLUE);

		mainPanel.add(resultLabel);
		mainPanel.add(scroll);

		for (Movie movie : results) {
			new Thread(() -> {
				try {
					if (movie.getPoster().isEmpty()) {
						Thread.sleep(3000);
					} else {
						movies.add(new SearchResultNode(movie));
					}
				} catch (MalformedURLException | InterruptedException e) {
					throw new RuntimeException(e);
				}
			}).start();
		}

		return mainPanel;
	}
}
