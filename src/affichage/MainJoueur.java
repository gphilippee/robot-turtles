package affichage;

import jeu.Jeu;
import jeu.tuile.Tuile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Conteneur qui les cartes a afficher
 */
public class MainJoueur extends JComponent {

    /**
     * Instance de la fenetre qui contient la grille
     */
    protected Jeu jeu;

    /**
     * Instance de la fenetre qui contient la grille
     */
    protected Fenetre fenetre;

    /**
     * Constructeur
     *
     * @param jeu reference du jeu
     */
    public MainJoueur(Fenetre fenetre, Jeu jeu) {
        super();
        this.jeu = jeu;
        this.fenetre = fenetre;
        initMain();

    }

    /**
     * Initialise les 5 cartes de la main
     */
    public void initMain() {
        this.setLayout(new GridLayout(1, 5));
        Color backgroundColor = Color.WHITE;
        ArrayList<Tuile> mainTemp = jeu.getJoueurCourant().getMainCarte();
        for (int i = 0; i < 5; i++) {
            CarteJoueur c = new CarteJoueur(jeu,mainTemp.get(i));
            this.add(c);
        }
    }

}
