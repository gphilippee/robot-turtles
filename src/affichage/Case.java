package affichage;

import com.company.Main;
import jeu.tuile.Tuile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.IOException;

/**
 * Une case de la grille
 */
public class Case extends JPanel {

    /**
     * Taille d'une case, la taille de l'image d'une piece
     */
    public static final int CASE_LENGTH = 60;

    /**
     * Etat de la case : si elle est selectionee, que l'on peut deplacer sa piece dessus, ou rien
     */
    public enum Etat {
        RIEN, SELECTIONE
    }

    /**
     * Coordonnee en abscisse
     */
    protected int x;

    /**
     * Coordonnee en ordonnee
     */
    protected int y;

    /**
     * Famille de la piece sur la case
     */
    protected String famille;

    /**
     * Couleur de la piece sur la case
     */
    protected String couleur;

    /**
     * Direction de la tortue
     */
    protected char direction;

    /**
     * Boolean : si la case contient une piece alors vrai
     */
    protected boolean contientPiece;

    /**
     * Couleur du fond : noir ou blanc
     */
    protected Color backgroundColor;

    /**
     * Etat de la piece
     */
    protected Etat etat;

    /**
     * Constructeur d'une case vide
     *
     * @param x               coordonnee en abscisse
     * @param y               coordonnee en ordonnee
     * @param backgroundColor couleur du fond
     */
    public Case(int x, int y, Color backgroundColor) {
        this.x = x;
        this.y = y;
        this.backgroundColor = backgroundColor;
        this.contientPiece = false;
        this.etat = Etat.RIEN;
        this.setSize(CASE_LENGTH, CASE_LENGTH);
    }

    /**
     * Gere l'affichage de la case selon son etat et la piece qu'elle contient
     */
    public void paintComponent(Graphics g) {
        //fond

        g.setColor(backgroundColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        if (contientPiece) {
            //Dessine l'image de la piece
            String couleurFile = couleur.toLowerCase();
            Image imgPiece = null;
            try {
                imgPiece = ImageIO.read(getClass().getResource(Main.RES_PATH + famille.toLowerCase() + "_" + couleurFile + ".png"));
                AffineTransform rotation = new AffineTransform();
                Graphics2D g2 = (Graphics2D) g;
                if (famille == "TORTUE") {
                    if (direction == 'S') {
                        rotation.rotate(Math.toRadians(180), imgPiece.getWidth(this) / 2, imgPiece.getHeight(this) / 2);
                    } else if (direction == 'O') {
                        rotation.rotate(Math.toRadians(90), imgPiece.getWidth(this) / 2, imgPiece.getHeight(this) / 2);
                    } else if (direction == 'E') {
                        rotation.rotate(Math.toRadians(-90), imgPiece.getWidth(this) / 2, imgPiece.getHeight(this) / 2);
                    }
                }
                g2.drawImage(imgPiece, rotation, this);
            } catch (IOException e) {
                System.out.println("Impossible de charger l'image " + getClass().getResource("src/images/" + famille.toLowerCase() + "_" + couleurFile + ".png"));
            }
        }

        if (!etat.equals(Etat.RIEN)) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0.5f));
            Color select = null;
            if (etat.equals(Etat.SELECTIONE)) {
                select = new Color(0, 102, 51);
            }
            g2d.setColor(select);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 1.0f));
        }

    }

    /**
     * Met a jour la case en y placant la piece passee en argument
     *
     * @param p Piece a placer sur la case
     */
    public void updateCase(Tuile p) {
        if (p == null) {
            this.famille = "";
            this.couleur = "";
            this.contientPiece = false;
        } else {
            this.famille = p.getFamille();
            this.couleur = p.getCouleur();
            this.direction = p.getDirection();
            this.contientPiece = true;
        }
    }

    /**
     * Getter de l'abscisse de la Case sur la grille
     *
     * @return x
     */
    public int getXTableau() {
        return x;
    }

    /**
     * Getter de l'ordonnee de la Case sur la grille
     *
     * @return y
     */
    public int getYTableau() {
        return y;
    }

    /**
     * Getter de la couleur de la piece sur la case
     * @return String
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Getter de l'etat de la case
     * @return etat
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter de l'etat de la case
     * @param e
     */
    public void setEtat(Etat e) {
        this.etat = e;
    }

    /**
     * Permet de savoir si la case contient une piece
     * @return le resultat du test
     */
    public boolean contientPiece() {
        return contientPiece;
    }
}
