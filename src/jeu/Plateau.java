package jeu;

import jeu.tuile.Joyau;
import jeu.tuile.Tortue;
import jeu.tuile.Tuile;
import jeu.tuile.murPierre;

import java.util.ArrayList;

/**
 * Classe qui va creer le plateau du jeu, elle est compose d'un tableau de Pieces
 */
public class Plateau {

    /**
     * Un tableau de pieces.
     */
    protected Tuile[][] plateau;

    /**
     * Reference du jeu
     */
    protected Jeu jeu;

    /**
     * Constructeur
     *
     * @param jeu reference du jeu
     */
    public Plateau(Jeu jeu) {
        this();
        this.jeu = jeu;
    }


    /**
     * Constructeur
     */
    public Plateau() {
        plateau = new Tuile[8][8];
    }

    /**
     * Mise en place des pieces sur le plateau pour une partie d'echecs
     */
    public void miseEnPlacePlateau(int nbJoueur) {

        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                plateau[i][j] = null;
            }
        }
        switch (nbJoueur) {
            case 2:
                jeu.getJoueurBleu().setTortue(new Tortue(1, 7, "BLEU", 'S', this));
                jeu.getJoueurRouge().setTortue(new Tortue(5, 7, "ROUGE", 'S', this));
                setCase(1, 7, jeu.getJoueurBleu().getTortue());
                setCase(5, 7, jeu.getJoueurRouge().getTortue());
                setCase(3, 0, new Joyau(3, 0, "BLEU", this));
                //Placer mur de pierre
                for (int i = 0; i < 8; i++) {
                    setCase(7, i, new murPierre(7, i, "PIERRE", this));
                }
                break;

            case 3:
                jeu.getJoueurBleu().setTortue(new Tortue(0, 7, "BLEU", 'S', this));
                jeu.getJoueurRouge().setTortue(new Tortue(3, 7, "ROUGE", 'S', this));
                jeu.getJoueurVert().setTortue(new Tortue(6, 7, "VERT", 'S', this));
                setCase(0, 7, jeu.getJoueurBleu().getTortue());
                setCase(3, 7, jeu.getJoueurRouge().getTortue());
                setCase(6, 7, jeu.getJoueurVert().getTortue());
                setCase(0, 0, new Joyau(0, 0, "BLEU", this));
                setCase(3, 0, new Joyau(3, 0, "ROUGE", this));
                setCase(6, 0, new Joyau(6, 0, "VERT", this));
                //Placer mur de pierre
                for (int i = 0; i < 8; i++) {
                    setCase(7, i, new murPierre(7, i, "PIERRE", this));
                }
                break;

            case 4:
                jeu.getJoueurBleu().setTortue(new Tortue(0, 7, "BLEU", 'S', this));
                jeu.getJoueurRouge().setTortue(new Tortue(2, 7, "ROUGE", 'S', this));
                jeu.getJoueurVert().setTortue(new Tortue(5, 7, "VERT", 'S', this));
                jeu.getJoueurRose().setTortue(new Tortue(7, 7, "ROSE", 'S', this));
                setCase(0, 7, jeu.getJoueurBleu().getTortue());
                setCase(2, 7, jeu.getJoueurRouge().getTortue());
                setCase(5, 7, jeu.getJoueurVert().getTortue());
                setCase(7, 7, jeu.getJoueurRose().getTortue());
                setCase(1, 0, new Joyau(1, 0, "BLEU", this));
                setCase(6, 0, new Joyau(6, 0, "ROUGE", this));
                break;
            default:

        }


    }

    /**
     * Retourne a la case d'abscisse x et d'ordonnee y.
     *
     * @param x represente l'abscisse.
     * @param y represente l'ordonnee.
     * @return soit la Piece contenu dans la case x,y; soit une erreur dut aux coordonnees.
     */
    public Tuile getCase(int x, int y) {
        if (x < 0 || y > 7) {
            System.out.println("Erreur dans la coordonnee sur l'axe des abscisse : (" + x + "," + y + ")");
            return null;
        }
        if (y > 7 || y < 0) {
            System.out.println("Erreur dans la coordonnee sur l'axe des ordonnees : (" + x + "," + y + ")");
            return null;
        }
        return plateau[x][y];
    }

    /**
     * Insert une Piece dans la case d'abscisse x et d'ordonnee y.
     *
     * @param x represente l'abscisse.
     * @param y represente l'ordonnee.
     * @param a est la Piece a mettre dans la case d'abscisse x et d'ordonnee y.
     */
    public void setCase(int x, int y, Tuile a) {
        if (x < 0 || x > 7) {
            System.out.println("Erreur dans la coordonnee sur l'axe des abscisse : (" + x + "," + y + ")" + " : " + a.toString());
        }
        if (y > 7 || y < 0) {
            System.out.println("Erreur dans la coordonnee sur l'axe des ordonnees : (" + x + "," + y + ") : " + a.toString());
        }
        this.plateau[x][y] = a;

    }

    /**
     * Regarde si une piece est presente dans une case
     *
     * @param x Abscisse de la case
     * @param y Ordonnee de la case
     * @return Vrai si elle est vide
     */
    public boolean estVide(int x, int y) {
        return plateau[x][y] == null;
    }

    /**
     * Getter jeu
     *
     * @return reference du jeu
     */
    public Jeu getJeu() {
        return jeu;
    }

    /**
     * Recupere une liste de toutes les pieces
     *
     * @return une liste
     */
    public ArrayList<Tuile> getPiece() {
        ArrayList<Tuile> p = new ArrayList<Tuile>();
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau.length; j++) {
                if (this.getCase(i, j) != null) {
                    p.add(this.getCase(i, j));
                }
            }
        }
        return p;
    }

    /**
     * Affichage en String du plateau
     */
    public void affiche() {
        System.out.println("    A B C D E F G H");
        for (int i = plateau.length - 1; i >= 0; i--) {
            System.out.print((i + 1) + " | ");
            for (int j = 0; j < plateau[i].length; j++) {
                if (plateau[j][i] != null) {
                    System.out.print(plateau[j][i].getFamille().charAt(0) + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println("Tour du joueur : " + jeu.getJoueurCourant().getCouleur());
    }

    public int getTaille() {
        return plateau.length;
    }


}