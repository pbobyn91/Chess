package Display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel {

    private final JTextField movement_display;
    public Board() {
        JPanel board = new JPanel();
        JPanel tiles = new JPanel();
        JPanel logs = new JPanel();
        JTextField log_title = new JTextField();
        movement_display = new JTextField();
        String[] top_rows = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        String[] side_rows = {"0", "A", "B","C", "D", "E", "F", "G", "H"};

        tiles.setBorder(BorderFactory.createEmptyBorder());
        tiles.setLayout(new GridLayout(9, 9,1, 1));
        tiles.setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                if (i == 0 && j == 0) {
                  tiles.add(createDisplay(""));
                } else if (i == 0) {
                    tiles.add(createDisplay(top_rows[j]));
                } else if (j == 0) {
                    tiles.add(createDisplay(side_rows[i]));
                } else if ((i+j) % 2 == 0) {
                    tiles.add(createButton(String.format("%d, %d", i, j), Color.WHITE, new Controller()));
                } else{
                    tiles.add(createButton(String.format("%d, %d", i, j), Color.BLACK, new Controller()));
                }

            }
        }

        log_title.setPreferredSize(new Dimension(300, 100));
        log_title.setBackground(Color.WHITE);
        log_title.setEditable(false);
        log_title.setText("Previous Moves");
        log_title.setFont(new Font(log_title.getFont().getName(), log_title.getFont().getStyle(), 20));
        log_title.setBorder(BorderFactory.createEmptyBorder());

        movement_display.setPreferredSize(new Dimension(300, 800));
        movement_display.setBackground(Color.WHITE);
        movement_display.setEditable(false);
        movement_display.setBorder(BorderFactory.createMatteBorder(1,1, 1, 1, Color.BLACK));
        movement_display.setFont(new Font(log_title.getFont().getName(), log_title.getFont().getStyle(), 14));

        logs.setPreferredSize(new Dimension(300, 910));
        logs.setBorder(BorderFactory.createEmptyBorder());
        logs.add(log_title, BorderLayout.NORTH);
        logs.add(movement_display, BorderLayout.CENTER);
        board.add(tiles, BorderLayout.CENTER);
        board.add(logs, BorderLayout.EAST);
        add(board, BorderLayout.CENTER);
        setVisible(true);
    }

    private JButton createButton (String position, Color color, ActionListener handler) {
        JButton temp = new JButton();

        temp.setPreferredSize(new Dimension(100, 100));
        temp.setBackground(color);

        if (position != null)
            temp.setActionCommand(position);

        temp.setFont(new Font(temp.getFont().getName(), temp.getFont().getStyle(), 20));

        temp.addActionListener(handler);

        return temp;
    }

    private JTextField createDisplay (String value){
        JTextField temp = new JTextField();

        temp.setText(value);
        temp.setPreferredSize(new Dimension(100, 50));
        temp.setFont(new Font(temp.getFont().getName(), temp.getFont().getStyle(), 20));

        return temp;
    }

    private class Controller implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            movement_display.setText(event.getActionCommand());
        }
    }
}
