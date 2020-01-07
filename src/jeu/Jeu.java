package jeu;

import affichage.Fenetre;
import jeu.tuile.Tuile;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class qui gere les differentes instances d'une partie d'echecs
 */
public class Jeu {

    /**
     * Plateau courant
     */
    protected Plateau plateau;

    /**
     * Instance du Joueur bleu
     */
    protected Joueur joueurBleu;

    /**
     * Instance du Joueur rouge
     */
    protected Joueur joueurRouge;

    /**
     * Instance du Joueur vert
     */
    protected Joueur joueurVert;

    /**
     * Instance du Joueur rose
     */
    protected Joueur joueurRose;

    /**
     * Instance du Joueur courant pendant la partie
     */
    protected Joueur joueurCourant;

    /**
     * Instance de la piece selectionnee par le joueur
     */
    protected Tuile pieceSelectionee;

    /**
     * Instance de la fenetre de jeu
     */
    protected Fenetre fenetre;

    /**
     * Stock le nombre de joueur
     */
    protected int nbJoueur;

    /**
     * Stock l'ordre des joueurs
     */
    protected ArrayList<Joueur> ordreJoueur;

    /**
     * Constructeur
     */
    public Jeu() {
        super();
        plateau = null;
        joueurBleu = null;
        joueurRouge = null;
        joueurVert = null;
        joueurRose = null;
        joueurCourant = null;
        pieceSelectionee = null;
        fenetre = null;
    }

    /**
     * Constructeur
     *
     * @param fenetre reference de la fenetre
     */
    public Jeu(Fenetre fenetre) {
        super();
        this.nbJoueur = fenetre.getNbJoueur();
        this.plateau = new Plateau(this);
        joueurBleu = new Joueur("BLEU");
        joueurRouge = new Joueur("ROUGE");
        joueurVert = new Joueur("VERT");
        joueurRose = new Joueur("ROSE");
        this.ordreJoueur = generateOrdreJoueur(fenetre.getNbJoueur());
        /**
         * A changer
         */
        getPremierJoueur();
        this.fenetre = fenetre;
        plateau.miseEnPlacePlateau(nbJoueur);
    }

    /**
     *
     */
    public ArrayList<Joueur> generateOrdreJoueur(int nbJoueur) {
        ArrayList<Joueur> listJoueur = new ArrayList<>();

        listJoueur.add(joueurBleu);
        listJoueur.add(joueurRouge);
        if (nbJoueur >= 3) {
            listJoueur.add(joueurVert);
        }
        if (nbJoueur >= 4) {
            listJoueur.add(joueurRose);
        }
        Collections.shuffle(listJoueur);
        return listJoueur;

    }

    public void getPremierJoueur() {
        this.joueurCourant = ordreJoueur.get(0);
    }

    public String getCouleurJoueurCourant() {
        return this.joueurCourant.getCouleur();

    }

    /**
     * Designe comme piece selectionnee
     *
     * @param x coordonnee en abscisse de la futur piece selectionnee
     * @param y coordonnee en ordonnee de la futur piece selectionnee
     */
    public void setPieceSelectionee(int x, int y) {
        pieceSelectionee = plateau.getCase(x, y);
        fenetre.getGrille().ajouterDeplacementPossible(pieceSelectionee.casesPossibles());

        if (fenetre != null) {
            fenetre.repaint();
        }
    }

    /**
     * Renvoi le test boolean de si la piece selectionnee est a null
     *
     * @return le resultat du test
     */
    public boolean aucunePieceSelectionee() {
        return pieceSelectionee == null;
    }

    /**
     * Deplace la piece selectionnee sur la coordonnee (x,y)
     *
     * @param x la coordonnee en abscisse
     * @param y la coordonnee en ordonee
     */
    public void deplacerPiece(int x, int y) {

    }

    /**
     * Remet une partie a zero
     */
    public void reset() {
        joueurRouge = new Joueur("ROUGE");
        joueurRose = new Joueur("ROSE");
        joueurBleu = new Joueur("BLEU");
        joueurVert = new Joueur("VERT");
        getPremierJoueur();
        plateau = new Plateau(this);
        pieceSelectionee = null;
        plateau.miseEnPlacePlateau(nbJoueur);
        fenetre.repaint();
    }

    /**
     * Change le joueur courant
     */
    public void switchJoueur() {
        int index = 0;
        for (int i = 0; i < ordreJoueur.size(); i++) {
            if (joueurCourant == ordreJoueur.get(i)) {
                index = i;
            }
        }
        joueurCourant = ordreJoueur.get((index + 1) % 4);
    }

    /**
     * Getter pour le joueurCourant
     *
     * @return la reference du joueurCourant
     */
    public Joueur getJoueurCourant() {
        return joueurCourant;
    }

    /**
     * Getter pour le joueur bleu
     *
     * @return la reference du joueurBleu
     */
    public Joueur getJoueurBleu() {
        return joueurBleu;
    }

    /**
     * Getter pour le joueur rouge
     *
     * @return la reference du joueurRouge
     */
    public Joueur getJoueurRouge() {
        return joueurRouge;
    }

    /**
     * Getter pour le joueur vert
     *
     * @return la reference du joueurVert
     */
    public Joueur getJoueurVert() {
        return joueurVert;
    }

    /**
     * Getter pour le joueur rose
     *
     * @return la reference du joueurRose
     */
    public Joueur getJoueurRose() {
        return joueurRose;
    }

    /**
     * Setter pour joueurCourant
     *
     * @param j joueurCourant
     */
    public void setJoueurCourant(Joueur j) {
        this.joueurCourant = j;
    }

    /**
     * Getter pour la fenetre lie au jeu
     *
     * @return fenetre
     */
    public Fenetre getFenetre() {
        return this.fenetre;
    }

    /**
     * Getter du plateau
     *
     * @return Plateau
     */
    public Plateau getPlateau() {
        return this.plateau;
    }

    /**
     * Getter nbJoueur
     *
     * @return nbJoueur
     */
    public int getNbJoueur() {
        return this.nbJoueur;
    }

}

