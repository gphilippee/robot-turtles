package affichage;

import com.company.Main;
import jeu.tuile.Tuile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Une carte de la main
 */
public class Carte extends JPanel {

    /**
     *
     */
    public static final int CARTE_WIDTH = 85;
    public static final int CARTE_HEIGHT = 120;

    /**
     *
     */
    protected int indiceCarte;

    /**
     * Boolean : si la case contient une carte alors vrai
     */
    protected boolean contientPiece;

    /**
     * Etat de la case : si elle est selectionee, que l'on peut deplacer sa piece dessus, ou rien
     */
    public enum Etat {RIEN, SELECTIONE}

    /**
     * Instance d'enum etat
     */
    protected Etat etat;

    /**
     * Famille de la carte
     */
    protected String famille;

    /**
     * Couleur de la carte
     */
    protected String couleur;

    public Carte(int indiceCarte) {
        this.contientPiece = false;
        this.etat = Etat.RIEN;
        this.indiceCarte = indiceCarte;
        this.setSize(CARTE_WIDTH, CARTE_HEIGHT);
    }


    @Override
    public void paintComponent(Graphics g) {

        if (contientPiece) {
            //Dessine l'image de la piece
            String couleurFile = couleur.toLowerCase();
            Image imgPiece = null;
            try {
                imgPiece = ImageIO.read(getClass().getResource(Main.RES_PATH + famille.toLowerCase() + "_" + couleurFile + ".png"));
                g.drawImage(imgPiece, 0, 0, this);
            } catch (IOException e) {
                System.out.println("Impossible de charger l'image " + getClass().getResource("src/images/" + famille.toLowerCase() + "_" + couleurFile + ".png"));
            }
        }

        if (!etat.equals(Carte.Etat.RIEN)) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0.3f));
            Color select = null;
            if (etat.equals(Carte.Etat.SELECTIONE)) {
                select = new Color(249, 255, 171);
            }
            g2d.setColor(select);
            g2d.fillRect(0, 0, 85, 120);
            g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 1.0f));
        }
    }

    /**
     * Met a jour la carte en y placant la carte passee en argument
     *
     * @param p Piece a placer sur la case
     */
    public void updateCarte(Tuile p) {
        if (p == null) {
            this.famille = "";
            this.couleur = "";
            this.contientPiece = false;
        } else {
            this.famille = p.getFamille();
            this.couleur = p.getCouleur();
            this.contientPiece = true;
        }
    }

    /**
     * Getter : indice de la carte dans la main
     *
     * @return
     */
    public int getIndiceCarte() {
        return indiceCarte;
    }

    /**
     * Getter de la couleur de la piece sur la carte
     *
     * @return String
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Getter de l'etat de la carte
     *
     * @return etat
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter de l'etat de la carte
     *
     * @param e
     */
    public void setEtat(Etat e) {
        this.etat = e;
    }
}
