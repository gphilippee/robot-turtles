package affichage;

import com.company.Main;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Background extends JPanel {

    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(getClass().getResource( Main.RES_PATH+"background.jpeg"));
            //g.drawImage(img, 0, 0, this);
            //Pour une image de fond
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
