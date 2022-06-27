import Display.Board;
import Display.SplashScreen;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main (String[] args){
        /* Start with the splashscreen */
        SplashScreen splashScreen = new SplashScreen(5000);
        splashScreen.dispose();

        /* Display the Board */
        Board board = new Board();

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame();

                frame.setMinimumSize(new Dimension(1400, 1000));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(board);
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }
        });
    }
}
