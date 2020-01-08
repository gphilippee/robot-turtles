package affichage.jeu;

import affichage.Case;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Une case de la grille
 */
public class CaseJeu extends Case implements MouseListener {

    /**
     * Active/desactive la prise d'input
     */
    private boolean recoisInput;

    /**
     * Reference de la fenetre
     */
    private Fenetre fenetre;

    /**
     * Constructeur d'une case vide
     *
     * @param x               coordonnee en abscisse
     * @param y               coordonnee en ordonnee
     * @param backgroundColor couleur du fond
     * @param fenetre         reference de la fenetre
     */
    public CaseJeu(int x, int y, Color backgroundColor, Fenetre fenetre) {
        super(x, y, backgroundColor);
        this.fenetre = fenetre;
        this.addMouseListener(this);
        this.recoisInput = true;
    }

    /**
     * Test si l'etat de la case est SELECTIONE ou DEPLACEMENT_POSSIBLE
     *
     * @return le resultat du test
     */
    public boolean isSelectionee() {
        return etat.equals(Etat.SELECTIONE);
    }

    /**
     * Setter de la prise d'input
     *
     * @param recoisInput
     */
    public void setRecoisInput(boolean recoisInput) {
        this.recoisInput = recoisInput;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!recoisInput) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0.5f));
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
            g2d.setComposite(AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 1.0f));
        }

        //Entourer la tortue du joueur actif
        if (famille.equals("TORTUE") && couleur.equals(fenetre.getJeu().getJoueurCourant().getCouleur())) {
            Color color = Color.BLACK;
            switch (couleur) {
                case "ROUGE":
                    color = Color.RED;
                    break;
                case "BLEU":
                    color = Color.BLUE;
                    break;
                case "VERT":
                    color = Color.GREEN;
                    break;
                case "ROSE":
                    color = Color.PINK;
                    break;
            }
            this.setBorder(BorderFactory.createLineBorder(color, 3));

        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        if (recoisInput) {
            if (this.couleur.equals(fenetre.getJeu().getJoueurCourant().getCouleur())) {
                fenetre.getGrille().resetSelectedCases();
                this.etat = Etat.SELECTIONE;
                fenetre.repaint();
                //fenetre.getJeu().setPieceSelectionee(x, y);
            } else {
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {

    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {

    }
}

