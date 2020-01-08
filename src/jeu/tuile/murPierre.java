package jeu.tuile;

import jeu.Plateau;

/**
 * Defini le comportement du mur de pierre
 */
public class murPierre extends Tuile {

    /**
     * Constructeur de mur de pierre
     *
     * @param x       La position en abscisse
     * @param y       La position en ordonnee
     * @param couleur La couleur de la piece (BLEU/ROUGE/VERT/ROSE)
     */
    public murPierre(int x, int y, String couleur, Plateau plateau) {
        super(x, y, "MUR", couleur, plateau);
    }

}
