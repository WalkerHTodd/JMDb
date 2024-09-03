import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class ActorSearchResults {

	private static final Color DARKER_BLUE = new Color(26, 36, 43);

	public static JPanel showActorSearchResults(Actor[] results) throws MalformedURLException {
		MainGUI.backButton.setVisible(false);
		JPanel firstResult = new JPanel(new BorderLayout());
		JPanel secondResult = new JPanel(new BorderLayout());
		JPanel thirdResult = new JPanel(new BorderLayout());
		JPanel fourthResult = new JPanel(new BorderLayout());
		JPanel mainPanel = new JPanel(new GridLayout(2, 2));

		JLabel firstLabel;
		JLabel secondLabel;
		JLabel thirdLabel;
		JLabel fourthLabel;
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);

		mainPanel.add(firstResult);
		mainPanel.add(secondResult);
		mainPanel.add(thirdResult);
		mainPanel.add(fourthResult);

		firstResult.setSize(250, 75);
		firstResult.setBorder(blackBorder);
		firstResult.setBackground(DARKER_BLUE);
		String actorResultOne = String.format("%s", results[0].getName());
		firstLabel = new JLabel(actorResultOne);
		firstLabel.setBackground(Color.blue);
		firstLabel.setHorizontalAlignment(JLabel.CENTER);
		firstLabel.setBorder(new EmptyBorder(30, 0, 0, 0));
		firstLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		firstResult.add(firstLabel, BorderLayout.NORTH);
		firstResult.setVisible(true);
		firstLabel.setForeground(Color.WHITE);

		JLabel poster = new JLabel();
		if (results[0].getImage() != null) {
			try {
				URL posterLink = new URL(results[0].getImage());
				ImageIcon posterImage = new ImageIcon(posterLink);
				poster.setIcon(new ImageIcon(normalizeImage(posterImage)));
				poster.setHorizontalAlignment(JLabel.CENTER);
				firstResult.add(poster, JLabel.CENTER); // CENTER DOESNT WORK
			} catch (MalformedURLException e) {
				Image icon = (new ImageIcon("nopicture.jpg")).getImage();
				poster.setIcon(new ImageIcon(icon));
				poster.setHorizontalAlignment(JLabel.CENTER);
				firstResult.add(poster, JLabel.CENTER); // CENTER DOESNT WORK
			}
		}

		secondResult.setSize(250, 75);
		secondResult.setBorder(blackBorder);
		secondResult.setBackground(DARKER_BLUE);
		String actorResultTwo = String.format("%s", results[1].getName());
		secondLabel = new JLabel(actorResultTwo);
		secondLabel.setBackground(Color.blue);
		secondLabel.setHorizontalAlignment(JLabel.CENTER);
		secondLabel.setBorder(new EmptyBorder(30, 0, 0, 0));
		secondLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		secondResult.add(secondLabel, BorderLayout.NORTH);
		secondResult.setVisible(true);
		secondLabel.setForeground(Color.WHITE);

		JLabel posterTwo = new JLabel();
		if (results[1].getImage() != null) {
			try {

				URL posterLinkTwo = new URL(results[1].getImage());
				ImageIcon posterImageTwo = new ImageIcon(posterLinkTwo);
				posterTwo.setIcon(new ImageIcon(normalizeImage(posterImageTwo)));
				posterTwo.setHorizontalAlignment(JLabel.CENTER);
				secondResult.add(posterTwo, JLabel.CENTER); // CENTER DOESNT WORK
			} catch (MalformedURLException e) {
				Image icon = (new ImageIcon("nopicture.jpg")).getImage();
				posterTwo.setIcon(new ImageIcon(icon));
				posterTwo.setHorizontalAlignment(JLabel.CENTER);
				secondResult.add(posterTwo, JLabel.CENTER); // CENTER DOESNT WORK
			}
		}

		thirdResult.setSize(250, 75);
		thirdResult.setBorder(blackBorder);
		thirdResult.setBackground(DARKER_BLUE);
		String actorResultThree = String.format("%s", results[2].getName());
		thirdLabel = new JLabel(actorResultThree);
		thirdLabel.setBackground(Color.blue);
		thirdLabel.setHorizontalAlignment(JLabel.CENTER);
		thirdLabel.setBorder(new EmptyBorder(30, 0, 0, 0));
		thirdLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		thirdResult.add(thirdLabel, BorderLayout.NORTH);
		thirdResult.setVisible(true);
		thirdLabel.setForeground(Color.WHITE);

		JLabel posterThree = new JLabel();
		if (results[2].getImage() != null) {
			try {
				URL posterLinkThree = new URL(results[2].getImage());
				ImageIcon posterImageThree = new ImageIcon(posterLinkThree);
				posterThree.setIcon(new ImageIcon(normalizeImage(posterImageThree)));
				posterThree.setHorizontalAlignment(JLabel.CENTER);
				thirdResult.add(posterThree, JLabel.CENTER); // CENTER DOESNT WORK
			} catch (MalformedURLException e) {
				Image icon = (new ImageIcon("nopicture.jpg")).getImage();
				posterThree.setIcon(new ImageIcon(icon));
				posterThree.setHorizontalAlignment(JLabel.CENTER);
				thirdResult.add(posterThree, JLabel.CENTER); // CENTER DOESNT WORK
			}
		}

		fourthResult.setSize(250, 75);
		fourthResult.setBorder(blackBorder);
		fourthResult.setBackground(DARKER_BLUE);
		String actorResultFour = String.format("%s", results[3].getName());
		fourthLabel = new JLabel(actorResultFour);
		fourthLabel.setBackground(Color.blue);
		fourthLabel.setHorizontalAlignment(JLabel.CENTER);
		fourthLabel.setBorder(new EmptyBorder(30, 0, 0, 0));
		fourthLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		fourthResult.add(fourthLabel, BorderLayout.NORTH);
		fourthResult.setVisible(true);
		fourthLabel.setForeground(Color.WHITE);

		JLabel posterFour = new JLabel();
		if (results[3].getImage() != null) {
			try {
				URL posterLinkFour = new URL(results[3].getImage());
				ImageIcon posterImageFour = new ImageIcon(posterLinkFour);
				posterFour.setIcon(new ImageIcon(normalizeImage(posterImageFour)));
				posterFour.setHorizontalAlignment(JLabel.CENTER);
				fourthResult.add(posterFour, JLabel.CENTER); // CENTER DOESNT WORK
			} catch (MalformedURLException e) {
				Image icon = (new ImageIcon("nopicture.jpg")).getImage();
				posterFour.setIcon(new ImageIcon(icon));
				posterFour.setHorizontalAlignment(JLabel.CENTER);
				fourthResult.add(posterFour, JLabel.CENTER); // CENTER DOESNT WORK
			}
		}

		return mainPanel;
	}

	private static Image normalizeImage(ImageIcon image) {

		Dimension dimensions = MainGUI.screenSize;
		double idealHeight = dimensions.height * .3;
		double idealWidth = (idealHeight / image.getIconHeight()) * image.getIconWidth();
		// System.out.println(dimensions);
		// System.out.println(idealWidth + " " + idealHeight);

		return image.getImage().getScaledInstance((int) idealWidth, (int) idealHeight, Image.SCALE_SMOOTH);
	}
}