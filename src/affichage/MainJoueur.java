package affichage;

import affichage.jeu.CarteJoueur;
import affichage.jeu.Fenetre;

import javax.swing.*;
import java.awt.*;

/**
 * Conteneur qui les cartes a afficher
 */
public class MainJoueur extends JComponent {

    /**
     * Instance de la fenetre qui contient la grille
     */
    protected Fenetre fenetre;

    /**
     * Constructeur
     * @param fenetre
     */
    public MainJoueur(Fenetre fenetre) {
        super();
        this.fenetre = fenetre;
        initMain();
        updateMain();
    }

    /**
     * Initialise les 5 cartes de la main
     */
    public void initMain() {
        this.setLayout(new GridLayout(1, 5, 10, 0));
        for (int i = 0; i < 5; i++) {
            CarteJoueur c = new CarteJoueur(i, fenetre);
            this.add(c);
        }
    }

    /**
     *
     */
    public void updateMain() {
        Component[] contenu = this.getComponents();
        for (int i = 0; i < contenu.length; i++) {
            //Si le composant est une carte
            if (contenu[i].getClass().equals(CarteJoueur.class)) {
                //Mise a jour de la case selon sa m�me position dans la main
                CarteJoueur c = (CarteJoueur) contenu[i];
                c.updateCarte(fenetre.getJeu().getJoueurCourant().getMainCarte().get(c.getIndiceCarte()));
            }
        }
    }



}
