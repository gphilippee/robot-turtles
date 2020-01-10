package affichage;

import com.company.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Background extends JPanel {

    protected String path;

    public Background(String path) {
        this.path = path;
    }

    public void paintComponent(Graphics g) {
        try {
            Image img = ImageIO.read(getClass().getResource(Main.RES_PATH + path));
            //g.drawImage(img, 0, 0, this);
            //Pour une image de fond
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
