package affichage.jeu;

import affichage.Case;
import affichage.Case.Etat;

import javax.swing.*;
import java.awt.*;

/**
 * Conteneur qui contient toutes les cases du jeu d'echecs a afficher
 *
 * @see Case
 */
public class GrilleJeu<Jpanel> extends JComponent {

    /**
     * Instance de la fenetre qui contient la grille
     */
    private Fenetre fenetre;

    /**
     * Afficher ou non les cases de deplacement possibles
     */
    private boolean affichageAideDeplacement;

    /**
     * Constructeur
     *
     * @param fenetre reference de la fenetre
     */
    public GrilleJeu(Fenetre fenetre) {
        super();
        this.fenetre = fenetre;
        this.affichageAideDeplacement = true;
        initGrille();
        updateGrille();
    }

    /**
     * Ajoute les 64 Cases a la grille
     */
    private void initGrille() {
        this.setLayout(new GridLayout(8, 8));
        Color backgroundColor = Color.WHITE;
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                CaseJeu c = new CaseJeu(j, i, backgroundColor, fenetre);
                if (j != 7) {
                    backgroundColor = (backgroundColor.equals(Color.GRAY)) ? Color.WHITE : Color.GRAY;
                }
                this.add(c);
            }
        }
    }

    /**
     * Met a jour toutes les Cases de la grille pour que celle-ci corresponde au plateau courant
     */
    public void updateGrille() {

        Component[] contenu = this.getComponents();
        for (int i = 0; i < contenu.length; i++) {
            //Si le composant est une Case
            if (contenu[i].getClass().equals(CaseJeu.class)) {
                //Mise a jour de la case selon sa m�me position dans le plateau
                CaseJeu c = (CaseJeu) contenu[i];
                c.updateCase(fenetre.getJeu().getPlateau().getCase(c.getXTableau(), c.getYTableau()));
            }
        }
    }

    /**
     * Remet l'etat de toutes les cases a RIEN
     */
    public void resetEtatCases() {
        Component[] contenu = this.getComponents();
        for (int i = 0; i < contenu.length; i++) {
            if (contenu[i].getClass().equals(CaseJeu.class)) {
                CaseJeu c = (CaseJeu) contenu[i];
                if (c.getEtat() != Etat.RIEN) {
                    c.setEtat(Case.Etat.RIEN);
                }
            }
        }
    }

    /**
     * Reset l'etat des cases en Selectione ou Deplacement_Possible a Rien
     */
    public void resetSelectedCases() {
        Component[] contenu = this.getComponents();
        for (int i = 0; i < contenu.length; i++) {
            if (contenu[i].getClass().equals(CaseJeu.class)) {
                CaseJeu c = (CaseJeu) contenu[i];
                if (c.getEtat().equals(Case.Etat.SELECTIONE)) {
                    c.setEtat(Case.Etat.RIEN);
                }
            }
        }
    }

    /**
     * Active ou desactive la reception d'input pour toutes les cases
     */
    public void setRecoisInput(boolean b) {
        Component[] contenu = this.getComponents();
        for (int i = 0; i < contenu.length; i++) {
            if (contenu[i].getClass().equals(CaseJeu.class)) {
                CaseJeu c = (CaseJeu) contenu[i];
                c.setRecoisInput(b);
            }
        }
    }

    /**
     * Setter affichage de l'aide des coups
     *
     * @param b
     */
    public void setAffichageAideDeplacement(boolean b) {
        this.affichageAideDeplacement = b;
    }

}

