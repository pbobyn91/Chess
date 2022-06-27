package Display;

import javax.swing.*;

public class SplashScreen extends JWindow {
    public SplashScreen(int duration) {
        Icon img = new ImageIcon(getClass().getResource("splashscreen.png"));

        int width = img.getIconWidth();
        int height = img.getIconHeight();

        getContentPane().add(new JLabel("", img, SwingConstants.CENTER));
        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);

        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            System.exit(1);
        }
    }
}