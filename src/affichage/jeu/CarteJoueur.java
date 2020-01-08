package affichage.jeu;

import affichage.Carte;
import jeu.Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 */
public class CarteJoueur extends Carte implements MouseListener {

    /**
     * Instance de classe jeu
     */
    protected Fenetre fenetre;

    /**
     * Active/desactive la prise d'input
     */
    private boolean recoisInput;

    /**
     * Constructeur
     *
     * @param indiceCarte
     * @param fenetre
     */
    public CarteJoueur(int indiceCarte, Fenetre fenetre) {
        super(indiceCarte);
        this.fenetre = fenetre;
        this.addMouseListener(this);
        this.recoisInput = true;
    }

    /**
     * Setter de la prise d'input
     *
     * @param recoisInput
     */
    public void setRecoisInput(boolean recoisInput) {
        this.recoisInput = recoisInput;
    }

    /**
     * Gere l'affichage de la case selon son etat et la carte qu'elle contient
     */
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
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (recoisInput) {
            //Si l'action est complete
            if (fenetre.getJeu().getAction().equals(Jeu.Action.COMPLETE)) {
                if (this.etat == Etat.RIEN) {
                    this.etat = Etat.SELECTIONE;
                    this.setBorder(BorderFactory.createRaisedBevelBorder());
                    fenetre.addLogPartie("La carte a bien été ajouté au programme");
                    fenetre.getJeu().addCarteSelectionnee(indiceCarte);
                    System.out.println(fenetre.getJeu().getCartesSelectionees());
                    //this.setVisible(false);
                } else {
                    this.setBorder(BorderFactory.createEmptyBorder());
                    this.etat = Etat.RIEN;
                    fenetre.addLogPartie("La carte a bien été enlevé au programme");
                    fenetre.getJeu().removeCarteSelectionnee(indiceCarte);
                    System.out.println(fenetre.getJeu().getCartesSelectionees());
                }

            }
            //Si l'action est defausser
            else if (fenetre.getJeu().getAction().equals(Jeu.Action.DEFAUSSE)) {
                if (this.etat == Etat.RIEN) {
                    this.etat = Etat.SELECTIONE;
                    this.setBorder(BorderFactory.createRaisedBevelBorder());

                } else {
                    this.setBorder(BorderFactory.createEmptyBorder());
                    this.etat = Etat.RIEN;
                }
                fenetre.repaint();
            }
        }
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
