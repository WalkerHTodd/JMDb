import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class EditWatchList extends JButton {
    private int clickCount;
    private JButton editButton;

    public EditWatchList(Movie title) {
        boolean inList = false;
        for (int i = 0; i < DropDownList.movieList().getSize(); i++) {
            if (DropDownList.movieList().getElementAt(i).getTitle().equals(
                    title.getTitle())) {
                inList = true;
            }
        }
        if (!inList) {
            this.editButton = new JButton("Add to Watch List");
            clickCount = 0;
        } else {
            this.editButton = new JButton("Remove From Watch List");
            clickCount = 1;
        }
        editButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                if (clickCount % 2 == 1) {
                    DropDownList.add(title);
                    editButton.setText("Remove From Watch List");
                } else {
                    DropDownList.remove(title);
                    editButton.setText("Add to Watch List");
                }

            }
        });
    }

    public JButton getButton() {
        return editButton;
    }

}
