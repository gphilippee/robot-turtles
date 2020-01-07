package jeu.tuile;

import jeu.Plateau;

/**
 * Defini le comportement du joyau
 */
public class Joyau extends Tuile {

    /**
     * Constructeur de joyau
     * @param x La position en abscisse
     * @param y La position en ordonnee
     * @param couleur La couleur de la piece (BLEU/ROUGE/VERT/ROSE)
     */
    public Joyau(int x, int y,String couleur, Plateau plateau){
        super(x, y, "JOYAU", couleur, plateau);
    }

}
