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
     *
     */
    protected JLabel numeroCarte;

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
        this.setLayout(new BorderLayout());
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

                    //Ajout d'un numero sur la carte pour connaitre l'ordre
                    numeroCarte = new JLabel("" + fenetre.getJeu().getCartesSelectionees().size());
                    Font police = new Font("Arial", Font.BOLD, 24);
                    numeroCarte.setFont(police);
                    numeroCarte.setForeground(Color.WHITE);
                    numeroCarte.setHorizontalAlignment(JLabel.CENTER);
                    this.add(numeroCarte, BorderLayout.CENTER);

                    System.out.println(fenetre.getJeu().getCartesSelectionees());
                    //this.setVisible(false);
                } else {
                    this.setBorder(BorderFactory.createEmptyBorder());
                    this.etat = Etat.RIEN;
                    fenetre.addLogPartie("La carte a bien été enlevé au programme");
                    this.remove(numeroCarte);
                    fenetre.getJeu().removeCarteSelectionnee(indiceCarte);

                    //Enleve le numero sur la carte

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
            } else {
                fenetre.addLogPartie("Si vous souhaitez completer le programme, veuillez choisir, il faut choisir \"Completer le programme\".");
            }
        } else {
            fenetre.addLogPartie("Les cartes ne peuvent pas être sélectionnées");
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
