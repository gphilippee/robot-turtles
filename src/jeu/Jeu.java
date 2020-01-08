package jeu;

import affichage.jeu.Fenetre;
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
     *
     */
    public enum Action {AUCUNE, COMPLETE, EXECUTE, CONSTRUIRE, DEFAUSSE}

    protected Action action;

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
     * Instance des cartes de la main selectionnee par le joueur
     */
    protected ArrayList<Tuile> cartesSelectionees;

    /**
     * Instance de la carte selectionnee par le joueur
     */
    protected Tuile carteSelectionee;

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
        cartesSelectionees = null;
        fenetre = null;
        action = null;
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
        action = Action.AUCUNE;
        /**
         * A changer
         */
        getPremierJoueur();
        this.fenetre = fenetre;
        plateau.miseEnPlacePlateau(nbJoueur);
        cartesSelectionees = new ArrayList<>();
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

    /**
     * Getter : Joueur qui commence
     */
    public void getPremierJoueur() {
        this.joueurCourant = ordreJoueur.get(0);
    }

    /**
     * @param indiceCarte
     */
    public void addCarteSelectionnee(int indiceCarte) {
        carteSelectionee = joueurCourant.getMainCarte().get(indiceCarte);
        cartesSelectionees.add(carteSelectionee);
        if (fenetre != null) {
            fenetre.repaint();
        }

    }

    public void removeCarteSelectionnee(int indiceCarte) {
        for (Tuile carte : cartesSelectionees) {
            if (joueurCourant.getMainCarte().get(indiceCarte).equals(carte)) {
                cartesSelectionees.remove(carte);
            }
        }
        if (fenetre != null) {
            fenetre.repaint();
        }

    }

    /**
     * Getter : Cartes Selectionnees
     * @return
     */
    public ArrayList<Tuile> getCartesSelectionees() {
        return cartesSelectionees;
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
        cartesSelectionees = null;
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
     * @param j joueurCourant
     */
    public void setJoueurCourant(Joueur j) {
        this.joueurCourant = j;
    }

    /**
     * Getter pour la fenetre lie au jeu
     * @return fenetre
     */
    public Fenetre getFenetre() {
        return this.fenetre;
    }

    /**
     * Getter du plateau
     * @return Plateau
     */
    public Plateau getPlateau() {
        return this.plateau;
    }

    /**
     * Getter : Nombre de joueur
     * @return nbJoueur
     */
    public int getNbJoueur() {
        return this.nbJoueur;
    }

    /**
     * Getter : Action
     * @return
     */
    public Action getAction() {
        return action;
    }

    /**
     * Setter : Action
     *
     * @param action
     */
    public void setAction(Action action) {
        this.action = action;
    }

}

