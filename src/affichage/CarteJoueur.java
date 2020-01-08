package affichage;

import com.company.Main;
import jeu.Jeu;
import jeu.tuile.Tuile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class CarteJoueur extends JPanel implements MouseListener {

    protected Jeu jeu;

    /**
     *
     */
    protected Tuile tuile;

    /**
     * @param jeu
     */
    public CarteJoueur(Jeu jeu, Tuile tuile) {
        this.jeu = jeu;
        this.tuile = tuile;

    }

    @Override
    public void paintComponent(Graphics g) {
        //Dessine l'image de la piece
        String couleurFile = tuile.getCouleur();
        Image imgPiece = null;
        try {
            imgPiece = ImageIO.read(getClass().getResource(Main.RES_PATH + tuile.getFamille().toLowerCase() + "_" + couleurFile + ".png"));
            g.drawImage(imgPiece, 0, 0, this);

        } catch (IOException e) {
            System.out.println("Impossible de charger l'image " + getClass().getResource(Main.RES_PATH + tuile.getFamille().toLowerCase() + "_" + couleurFile + ".png"));
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
