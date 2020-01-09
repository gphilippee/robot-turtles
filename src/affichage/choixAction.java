package affichage;

import affichage.jeu.Fenetre;
import jeu.Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Choix de l'action : completer le programme, construire un mur ou executer le programme
 */
public class choixAction extends JPanel implements ActionListener {

    /**
     * Bouton completer le programme
     */
    private JButton completeProgramme;

    /**
     * Bouton construire un mur
     */
    private JButton construireMur;

    /**
     * Bouton exectuer le programme
     */
    private JButton executeProgramme;

    /**
     * Instancie la fenetre
     */
    protected Fenetre fenetre;

    public choixAction(Fenetre fenetre) {
        this.fenetre = fenetre;
        initConteneur();

    }

    public void initConteneur() {
        completeProgramme = new JButton("Completer le programme");
        completeProgramme.addActionListener(this);

        construireMur = new JButton("Construire un mur");
        construireMur.addActionListener(this);

        executeProgramme = new JButton("Éxécuter le programme");
        executeProgramme.addActionListener(this);

        this.setLayout(new GridLayout(3, 1));

        this.add(completeProgramme);
        this.add(construireMur);
        this.add(executeProgramme);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == completeProgramme) {
            //Pour eviter le spam
            if (fenetre.getJeu().getAction() != Jeu.Action.COMPLETE) {
                fenetre.addLogPartie("Vous avez choisi de completer le programme.");
                fenetre.getJeu().setAction(Jeu.Action.COMPLETE);
                //reset des autres actions
                reset();
                fenetre.repaint();
            }


        }

        if (source == construireMur) {
            if (fenetre.getJeu().getAction() != Jeu.Action.CONSTRUIRE) {
                fenetre.addLogPartie("Vous avez choisi de construire un mur.");
                fenetre.getJeu().setAction(Jeu.Action.CONSTRUIRE);
                reset();
                fenetre.repaint();
            }


        }

        if (source == executeProgramme) {
            if (fenetre.getJeu().getAction() != Jeu.Action.EXECUTE) {
                fenetre.addLogPartie("Vous avez choisi d'executer le programme.");
                fenetre.getJeu().setAction(Jeu.Action.EXECUTE);
                reset();
                fenetre.repaint();
            }

        }
    }

    /**
     * Reset les selections
     */
    public void reset() {
        fenetre.getGrille().resetEtatCases();
        fenetre.getMain().resetEtatCartes();
        fenetre.getJeu().clearCartesSelectionees();
    }
}
