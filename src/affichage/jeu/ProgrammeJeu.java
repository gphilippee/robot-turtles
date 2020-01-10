package affichage.jeu;

import affichage.Case;
import com.company.Main;
import jeu.Jeu;
import jeu.tuile.Tuile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ProgrammeJeu extends JPanel {

    /**
     *
     */
    protected Jeu jeu;

    /**
     * @param jeu
     */
    public ProgrammeJeu(Jeu jeu) {
        super();
        this.jeu = jeu;

    }

    @Override
    public void paintComponent(Graphics g) {
        ArrayList<Tuile> priseTemp = jeu.getJoueurCourant().getProgramme();
        int x = 40;
        int y = 0;
        for (int i = 0; i < priseTemp.size(); i++) {
            //Dessine l'image de la piece
            Image imgPiece = null;
            try {
                imgPiece = ImageIO.read(getClass().getResource(Main.RES_PATH + "carte_back.png"));
                g.drawImage(imgPiece, x, y, this);
                x += Case.CASE_LENGTH;
                if (x >= Case.CASE_LENGTH * 7) {
                    y += Case.CASE_LENGTH + 5;
                    x = 40;
                }

            } catch (IOException e) {
                System.out.println("Impossible de charger l'image " + getClass().getResource(Main.RES_PATH + "carte_back.png"));
            }


        }
    }
}
