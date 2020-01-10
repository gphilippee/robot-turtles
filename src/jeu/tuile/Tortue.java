package jeu.tuile;

import jeu.Plateau;

/**
 * Defini le comportement du tortue
 */
public class Tortue extends Tuile {

    /**
     * Constructeur de tortue
     *
     * @param x       La position en abscisse
     * @param y       La position en ordonnee
     * @param couleur La couleur de la piece (BLEU/ROUGE/VERT/ROSE)
     */
    public Tortue(int x, int y, String couleur, char direction, Plateau plateau) {
        super(x, y, "TORTUE", couleur, direction, plateau);
    }

    /**
     * Verifie si le deplacement est possible
     *
     * @param x L'abscisse d'arrive
     * @param y l'ordonnee d'arrive
     * @return resultat du test
     */
    public boolean coupPossible(int x, int y) {
        if (x == this.x - 1 && y == this.y - 1) {
            return true;
        }
        //
        if (x == this.x + 1 && y == this.y - 1) {
            return true;
        }
        //
        if (x == this.x + 1 && y == this.y + 1) {
            return true;
        }
        //
        if (x == this.x - 1 && y == this.y + 1) {
            return true;
        }
        //
        return false;
    }

    /**
     * Verifie si il n'y a pas d'obstacle au deplacement
     *
     * @param x
     * @param y
     * @return vrai ou faux
     */
    public boolean mouvementPossible(int x, int y) {
        return true;
    }


}
