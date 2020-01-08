package jeu.tuile;

import jeu.Plateau;

/**
 * Defini le comportement du mur de glace
 */
public class murGlace extends Tuile {

    /**
     * Constructeur de mur de glace
     *
     * @param x       La position en abscisse
     * @param y       La position en ordonnee
     * @param couleur La couleur de la piece (BLEU/ROUGE/VERT/ROSE)
     */
    public murGlace(int x, int y, String couleur, Plateau plateau) {
        super(x, y, "MUR", couleur, plateau);
    }
}
