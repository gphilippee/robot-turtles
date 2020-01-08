package affichage.jeu;

import affichage.Menu;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

/**
 *
 */
public class Barre extends JMenuBar implements ActionListener, MouseListener, ItemListener, ChangeListener {

    /**
     * Reference de la fenetre
     */
    private Fenetre fenetre;

    /**
     * Menu fichier
     */
    private JMenu Fichier;

    /**
     * Action nouvelle partie
     */
    private JMenuItem nouvellePartie;

    /**
     * Action quitter
     */
    private JMenuItem fermer;

    /**
     * Action retour menu principal
     */
    private JMenuItem menuPrincipal;

    /**
     * Constructeur
     *
     * @param fenetre
     */
    public Barre(Fenetre fenetre) {
        this.fenetre = fenetre;
        Fichier = new JMenu("Fichier");
        nouvellePartie = new JMenuItem("Nouvelle Partie");
        menuPrincipal = new JMenuItem("Menu Principal");
        fermer = new JMenuItem("Fermer");

        this.Fichier.add(nouvellePartie);
        this.Fichier.addSeparator();

        nouvellePartie.addActionListener(this);
        fermer.addActionListener(this);
        menuPrincipal.addActionListener(this);

        this.Fichier.add(menuPrincipal);
        this.Fichier.add(fermer);

        this.add(Fichier);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == nouvellePartie) {
            int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment commencer une nouvelle partie ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choix != JOptionPane.NO_OPTION && choix != JOptionPane.CLOSED_OPTION)
                fenetre.getJeu().reset();
        }

        if (source == fermer) {
            System.exit(0);
        }

        if (source == menuPrincipal) {
            int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment retourner au menu principal ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choix != JOptionPane.NO_OPTION && choix != JOptionPane.CLOSED_OPTION) {
                fenetre.getJeu().getFenetre().setVisible(false);
                fenetre.getJeu().getFenetre().dispose();
                new Menu();
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
