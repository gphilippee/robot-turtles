package jeu;

import affichage.jeu.Fenetre;
import jeu.tuile.Tortue;
import jeu.tuile.Tuile;
import jeu.tuile.murPierre;

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
     * Définit l'action en cours
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
     *
     */
    protected int[][] plateauCaseExplore;

    /**
     *
     */
    protected int[] caseSelectionee;

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
     * Variable pour savoir si le joueur a effectué une action correctement
     */
    protected boolean isActionCorrecte = false;

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
        caseSelectionee = null;
        fenetre = null;
        action = null;
        plateauCaseExplore = null;
    }

    /**
     * Constructeur
     *
     * @param fenetre reference de la fenetre
     */
    public Jeu(Fenetre fenetre) {
        super();
        plateauCaseExplore = new int[8][8];
        this.nbJoueur = fenetre.getNbJoueur();
        joueurBleu = new Joueur("BLEU");
        joueurRouge = new Joueur("ROUGE");
        joueurVert = new Joueur("VERT");
        joueurRose = new Joueur("ROSE");
        generateOrdreJoueur(fenetre.getNbJoueur());
        this.plateau = new Plateau(this);
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
    public boolean existeChemin(Plateau plateau) {
        return false;
    }

    /**
     *
     */
    public void generateOrdreJoueur(int nbJoueur) {
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
        this.ordreJoueur = listJoueur;
    }

    /**
     * Getter : Joueur qui commence
     */
    public void getPremierJoueur() {
        this.joueurCourant = ordreJoueur.get(0);
    }

    /**
     * Designe comme piece selectionnee
     *
     * @param x coordonnee en abscisse de la futur piece selectionnee
     * @param y coordonnee en ordonnee de la futur piece selectionnee
     */
    public void setCaseSelectionee(int x, int y) {
        caseSelectionee = new int[]{x, y};
        if (fenetre != null) {
            fenetre.repaint();
        }
    }

    /**
     * Getter : Case Selectionnee par le joueur
     *
     * @return
     */
    public int[] getCaseSelectionee() {
        return caseSelectionee;
    }

    /**
     * Permet le reset des cartes selectionees par le joueur
     */
    public void clearCartesSelectionees() {
        cartesSelectionees = new ArrayList<>();
    }

    /**
     * Permet le reset de la case selectionee par le joueur
     */
    public void clearCaseSelectionee() {
        caseSelectionee = null;
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
     *
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
        joueurCourant = ordreJoueur.get((index + 1) % nbJoueur);
        fenetre.addLogPartie("Joueur " + joueurCourant.getCouleur().toLowerCase() + " à toi de jouer !");
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
     * Getter : Nombre de joueur
     *
     * @return nbJoueur
     */
    public int getNbJoueur() {
        return this.nbJoueur;
    }

    /**
     * Getter : Action
     *
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

    //TODO implementer la defausse
    public void lagrosseFonction() {
        plateau.affiche();

        /**
         * Le joueur doit effectuer une des 3 actions correctement
         */
        //Recupere l'action selectionnee par le joueur
        Action action = getAction();
        if (!isActionCorrecte) {
            if (action.equals(Action.AUCUNE)) {

                fenetre.addLogPartie("Veuillez choisir une action.");

            } else if (action.equals(Action.CONSTRUIRE)) {

                //TODO do while tant que le mur nest pas bon good je pense
                //J'ajoute le mur
                plateau.setCase(caseSelectionee[0], caseSelectionee[1], new murPierre(caseSelectionee[0], caseSelectionee[1], "PIERRE", plateau));
                plateau.affiche();
                //Si le mur bloque, je l'enleve
                if (isWallBlock()) {
                    fenetre.addLogPartie("Le mur ne peut être posé car il bloque le jeu. Veuillez reesayer.");
                    plateau.setCase(caseSelectionee[0], caseSelectionee[1], null);
                } else {
                    fenetre.addLogPartie("Le mur a bien été posé.");
                    //L'action est correcte
                    isActionCorrecte = true;
                    setAction(Action.AUCUNE);
                }

            } else if (action.equals(Action.COMPLETE)) {

                //Si le joueur n'a choisi aucune carte
                if (getCartesSelectionees().size() == 0) {
                    fenetre.addLogPartie("Vous n'avez choisi aucune carte. Veuillez recommencer.");
                }
                //Sinon, le joueur a au moins choisi une carte
                else {
                    fenetre.addLogPartie("Les cartes ont bien été ajoutées au programme.");
                    /**
                     * Ajoute les cartes selectionnes au programme et les supprime de la main
                     */
                    System.out.println("Main du joueur avant " + getJoueurCourant().getMainCarte());
                    for (Tuile carte : cartesSelectionees) {
                        getJoueurCourant().ajoutProgramme(carte);
                        getJoueurCourant().ajoutDefausse(carte);
                    }
                    System.out.println("Main du joueur apres " + getJoueurCourant().getMainCarte());
                    fenetre.getMain().resetEtatCartes();
                    //TODO repaint la fenetre avec la main actualisé.
                    fenetre.repaint();
                    //reset des cartes selectionnes
                    clearCartesSelectionees();
                    //L'action est correcte
                    isActionCorrecte = true;
                    setAction(Action.AUCUNE);
                }

            } else if (action.equals(Jeu.Action.EXECUTE)) {
                /**
                 * Pour chaque carte dans le programme
                 */
                ArrayList<Tuile> programmeJoueur = joueurCourant.getProgramme();
                //TODO implementer le comportement des cartes
                for (Tuile carte : programmeJoueur) {
                    //Carte : avancer
                    if (carte.getCouleur().equals("BLEU")) {

                    }
                    //Carte : Anti-horaire
                    else if (carte.getCouleur().equals("JAUNE")) {

                    }
                    //Carte : horaire
                    else if (carte.getCouleur().equals("VIOLETTE")) {

                    }
                    //Carte : laser
                    else if (carte.getCouleur().equals("LASER")) {

                    }
                }
            }
            setAction(Action.AUCUNE);
            fenetre.addLogPartie("Selectionner les cartes que vous voulez defausser, sinon Valider.");
        }


        /**
         * Ensuite, on fait la defausse si l'action precedente a ete correctement effectuee
         */
        fenetre.getChoixAction().setRecoisInput(false);
        boolean isCarteDefausse = false;
        if (isActionCorrecte) {

            setAction(Action.DEFAUSSE);
            /**
             * Reset des selections precedentes
             */
            fenetre.getMain().resetEtatCartes();
            fenetre.getJeu().clearCartesSelectionees();
            fenetre.getGrille().resetEtatCases();
            if (action.equals(Action.DEFAUSSE)) {
                setAction(Action.AUCUNE);
                isCarteDefausse = true;
                isActionCorrecte = false;
            }

        }
        /**
         * Si les cartes ont été défaussées
         */
        if (isCarteDefausse) {
            /**
             * Change le joueur actuel
             */
            switchJoueur();

            /**
             * Redessine la fenetre pour un nouveau tour
             */
            fenetre.repaint();
            /**
             * Réautorise les inputs sur les choix de l'action
             */
            fenetre.getChoixAction().setRecoisInput(true);

        }

    }

    /**
     * On teste s'il existe au moins un joyau accessible pour chaque tortue
     *
     * @return vrai ou faux
     */
    public boolean isWallBlock() {
        for (int i = 0; i < nbJoueur; i++) {
            Tortue tortue = ordreJoueur.get(i).getTortue();
            plateauCaseExplore = new int[8][8];
            boolean cheminExiste = cheminTortueJoyau(tortue.getX(), tortue.getY());
            if (!cheminExiste) {
                return true;
            }
        }
        return false;
    }

    /**
     * Trouve l'existence ou non d'un chemin entre la tortue et le joyaux
     *
     * @param i
     * @param j
     * @return
     */
    public boolean cheminTortueJoyau(int i, int j) {
        //Si la case est en dehors
        if (plateau.getTaille() <= i || i < 0 || plateau.getTaille() <= j || j < 0) {
            return false;
        }
        //Si la case a ete deja été explorée
        if (plateauCaseExplore[j][7 - i] == 1) {
            return false;
        }
        //Sinon, je l'ajoute
        else {
            plateauCaseExplore[j][7 - i] = 1;
        }
        //Si la case n'est pas vide
        if (plateau.getCase(i, j) != null) {
            //S'il s'agit d'un mur de pierre, renvoie false
            if (plateau.getCase(i, j).getFamille().equals("MUR")) {
                if (plateau.getCase(i, j).getCouleur().equals("PIERRE")) {
                    return false;
                }
                //S'il s'agit d'un joyau, il existe un chemin, renvoie true
            } else if (plateau.getCase(i, j).getFamille().equals("JOYAU")) {
                System.out.println(plateau.getCase(i, j).getFamille());
                return true;
            }
        }
        return cheminTortueJoyau(i + 1, j) || cheminTortueJoyau(i, j - 1) || cheminTortueJoyau(i, j + 1) || cheminTortueJoyau(i - 1, j);
    }
}

