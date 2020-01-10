package affichage;

import affichage.jeu.Fenetre;

import javax.swing.*;
import java.awt.*;

/**
 * Affiche le joueur courant pour la fenetre de replay
 */
public class JoueurCourant extends JPanel {

    /**
     * Affichage du joueur bleu
     */
    private CaseJoueur joueurBleu;

    /**
     * Affichage du joueur rouge
     */
    private CaseJoueur joueurRouge;

    /**
     * Affichage du joueur vert
     */
    private CaseJoueur joueurVert;

    /**
     * Affichage du joueur rose
     */
    private CaseJoueur joueurRose;

    /**
     * Reference de la fenetre de replay
     */
    private Fenetre fenetre;

    /**
     * Constructeur
     *
     * @param fenetre
     */
    public JoueurCourant(Fenetre fenetre) {
        super();
        this.fenetre = fenetre;
        initConteneur();
    }

    /**
     * Instancie et positionne les elements
     */
    private void initConteneur() {
        joueurBleu = new CaseJoueur(Color.BLUE, isTour("BLEU"));
        joueurBleu.setPreferredSize(new Dimension(Case.CASE_LENGTH, Case.CASE_LENGTH));

        joueurRouge = new CaseJoueur(Color.RED, isTour("ROUGE"));
        joueurRouge.setPreferredSize(new Dimension(Case.CASE_LENGTH, Case.CASE_LENGTH));

        joueurVert = new CaseJoueur(Color.GREEN, isTour("VERT"));
        joueurVert.setPreferredSize(new Dimension(Case.CASE_LENGTH, Case.CASE_LENGTH));

        joueurRose = new CaseJoueur(Color.PINK, isTour("ROSE"));
        joueurRose.setPreferredSize(new Dimension(Case.CASE_LENGTH, Case.CASE_LENGTH));

        JLabel textTour = new JLabel("TOUR", JLabel.CENTER);
        textTour.setPreferredSize(new Dimension(Case.CASE_LENGTH * 2, Case.CASE_LENGTH));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        if (fenetre.getNbJoueur() >= 3) {
            //placement joueur vert
            gbc.gridx = 0;
            this.add(joueurVert, gbc);
        }

        //placement joueur bleu
        gbc.gridx = 1;
        this.add(joueurBleu, gbc);

        //placement texte Tour
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(textTour, gbc);

        //placement joueur rouge
        gbc.gridx = 3;
        this.add(joueurRouge, gbc);

        if (fenetre.getNbJoueur() == 4) {
            //placement joueur rose
            gbc.gridx = 4;
            this.add(joueurRose, gbc);
        }

    }

    public boolean isTour(String couleur) {

        return couleur == fenetre.getJeu().getJoueurCourant().getCouleur();
    }

    /**
     * Mise a jour du joueur courant
     */
    public void update() {
        if (fenetre.getJeu().getJoueurCourant().getCouleur().equals("ROUGE")) {
            joueurBleu.isTour = true;
            joueurRouge.isTour = false;
            joueurVert.isTour = false;
            joueurRose.isTour = false;
        } else if (fenetre.getJeu().getJoueurCourant().getCouleur().equals("BLEU")) {
            joueurBleu.isTour = true;
            joueurRouge.isTour = false;
            joueurVert.isTour = false;
            joueurRose.isTour = false;
        } else if (fenetre.getJeu().getJoueurCourant().getCouleur().equals("VERT")) {
            joueurBleu.isTour = false;
            joueurRouge.isTour = false;
            joueurVert.isTour = true;
            joueurRose.isTour = false;
        } else if (fenetre.getJeu().getJoueurCourant().getCouleur().equals("ROSE")) {
            joueurBleu.isTour = false;
            joueurRouge.isTour = false;
            joueurVert.isTour = false;
            joueurRose.isTour = true;
        }
    }
}

/**
 * Un element de l'affichage joueur courant
 */
class CaseJoueur extends JPanel {

    /**
     * Vrai si c'est le tour de cet element
     */
    public boolean isTour;

    /**
     * Couleur de l'element
     */
    private Color couleur;

    /**
     * Constructeur
     *
     * @param couleur
     */
    public CaseJoueur(Color couleur, boolean isTour) {
        super();
        this.couleur = couleur;
        this.isTour = isTour;
    }


    @Override
    public void paintComponent(Graphics g) {
        g.setColor(couleur);
        if (!isTour) {
            g.fillRect(this.getWidth() * 3 / 8, this.getHeight() * 3 / 8, this.getWidth() / 4, this.getHeight() / 4);
            g.setColor(Color.GRAY);
            g.drawRect(this.getWidth() * 3 / 8, this.getHeight() * 3 / 8, this.getWidth() / 4, this.getHeight() / 4);
        } else {
            g.fillRect(this.getWidth() / 4, this.getHeight() / 4, this.getWidth() / 2, this.getHeight() / 2);
            g.setColor(Color.GRAY);
            g.drawRect(this.getWidth() / 4, this.getHeight() / 4, this.getWidth() / 2, this.getHeight() / 2);
        }
    }
}
