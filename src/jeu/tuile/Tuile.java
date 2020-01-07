package jeu.tuile;

import jeu.Coordonnee;
import jeu.Plateau;

import java.util.ArrayList;

/**
 * Classe mere des differentes tuiles
 */
public class Tuile {

    //La famille de la piece
    private String famille;

    //Reference au plateau
    protected Plateau plateau;

    //L'abscisse et l'ordonnee de la piece
    protected int x,y;

    //La couleur de la piece
    protected String couleur;

    public Tuile(int x, int y, String famille, String couleur, Plateau plateau){
        this.x = x;
        this.y = y;
        this.plateau = plateau;
        this.famille=famille;
        this.couleur=couleur;
    }

    /**
     * Recupere les coordonnees de toutes les cases ou peut aller la piece
     * @return ArrayList<Coordonnee> de tous les coups possibles
     */
    public ArrayList<Coordonnee> casesPossibles(){
        return new ArrayList<Coordonnee>();
    }

    /**
     * Retourne la famille de la piece
     * @return Famille de la piece
     */
    public String getFamille(){
        return famille;
    }

    /**
     * Donne la couleur de piece
     * @return La couleur de la piece
     */
    public String getCouleur(){
        return couleur;
    }

    /**
     * Retourne la coordonnee X
     * @return x
     */
    public int getX(){
        return this.x;
    }

    /**
     * Retourne la coordonnee Y
     * @return y
     */
    public int getY(){
        return this.y;
    }

    /**
     * Setter x
     * @param x
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     * Setter x
     * @param y
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     * Setter pour x et y a la foi
     * @param x
     * @param y
     */
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Deplace la piece (change les coordonnees)
     * @param x Le x d'arrivee
     * @param y Le y d'arrivee
     */
    public boolean deplacer(int x,int y) {
    return false;
    }

    /**
     * Verifie si il n'y a pas d'obstacle au deplacement
     * @param x
     * @param y
     * @return vrai ou faux
     */
    public boolean mouvementPossible(int x, int y){
        return true;
    }

}
