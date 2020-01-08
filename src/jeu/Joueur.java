package jeu;

import jeu.tuile.Cards;
import jeu.tuile.Tortue;
import jeu.tuile.Tuile;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Défini un joueur
 */
public class Joueur {

    /**
     * Couleur du joueur
     */
    protected String couleur;

    /**
     * Stock la pile de carte
     */
    protected ArrayList<Tuile> pileCarte;

    /**
     * Stock la main du joueur
     */
    protected ArrayList<Tuile> mainCarte;

    /**
     * Stock le programme du joueur
     */
    protected ArrayList<Tuile> programme;

    /**
     * Stock le nombre de mur en pierre
     */
    protected int nbrPierre;

    /**
     * Stock le nombre de mur en glace
     */
    protected int nbrGlace;

    /**
     * Instancie la tortue du joueur
     */
    protected Tortue tortue;


    /**
     * Instancie un joueur selon la couleur c
     *
     * @param couleur : couleur du joueur
     */
    public Joueur(String couleur) {
        this.initialisePile();
        this.mainInitiale();
        this.couleur = couleur;
        this.programme = new ArrayList<>();
        this.nbrPierre = 3;
        this.nbrGlace = 2;
    }

    /**
     * Mutateur : pile
     * Initialise la pile
     */
    private void initialisePile() {
        ArrayList<Tuile> pileInitiale = new ArrayList<>();
        //Ajout des cartes bleues "avancer"
        for (int i = 0; i < 18; i++) {
            pileInitiale.add(new Cards(0, 0, "BLEU"));
        }
        //Ajout des cartes jaunes "+PI/2"
        for (int i = 0; i < 8; i++) {
            pileInitiale.add(new Cards(0, 0, "JAUNE"));
        }
        //Ajout des cartes violette "-PI/2"
        for (int i = 0; i < 8; i++) {
            pileInitiale.add(new Cards(0, 0, "VIOLETTE"));
        }
        //Ajout des cartes laser
        for (int i = 0; i < 3; i++) {
            pileInitiale.add(new Cards(0, 0, "LASER"));
        }
        //Melange de la pile
        Collections.shuffle(pileInitiale);
        this.pileCarte = (ArrayList<Tuile>) pileInitiale.clone();
    }

    /**
     * Mutateur : main
     * Initialise la main
     */
    private void mainInitiale() {
        ArrayList<Tuile> mainInitiale = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mainInitiale.add(pileCarte.get(0));
            pileCarte.remove(0);
        }
        this.mainCarte = mainInitiale;
    }

    /**
     * Enleve une carte mur
     *
     * @param matiere
     */
    public void enleverCarteMur(String matiere) {
        if (matiere == "PIERRE") {
            nbrPierre -= 1;
        } else if (matiere == "GLACE") {
            nbrGlace -= 1;
        }
    }

    /**
     * Permet d'ajouter au programme
     *
     * @param carte
     */
    public void ajoutProgramme(Tuile carte) {
        programme.add(carte);
    }

    /**
     * Melange la pile
     */
    public void shufflePile() {
        Collections.shuffle(pileCarte);
    }

    /**
     * Setter : Tortue
     *
     * @param tortue
     */
    public void setTortue(Tortue tortue) {
        this.tortue = tortue;
    }

    /**
     * Getter : Tortue
     *
     * @return
     */
    public Tortue getTortue() {
        return tortue;
    }

    /**
     * Getter : Taille de la pile
     *
     * @return pileCarte.size()
     */
    public int taillePile() {
        return pileCarte.size();
    }

    /**
     * Getter : Pile de carte
     *
     * @return pileCarte
     */
    public ArrayList<Tuile> getPileCarte() {
        return pileCarte;
    }

    /**
     * Getter : Couleur du joueur
     *
     * @return couleur
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Getter : Main du joueur
     *
     * @return mainCarte
     */
    public ArrayList<Tuile> getMainCarte() {
        return mainCarte;
    }

    /**
     * Getter : Programme
     *
     * @return programme
     */
    public ArrayList<Tuile> getProgramme() {
        return programme;
    }

    /**
     * Getter : Taille de la main
     *
     * @return mainCarte.size()
     */
    public int tailleMain() {
        return mainCarte.size();
    }

    /**
     * Getter : Nombre de mur de pierre
     *
     * @return nbrPierre
     */
    public int nombrePierre() {
        return nbrPierre;
    }

    /**
     * Getter : Nombre de mur de glace
     *
     * @return nbrGlace
     */
    public int nombreGlace() {
        return nbrGlace;
    }
}

