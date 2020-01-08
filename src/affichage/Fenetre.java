package affichage;


import jeu.Jeu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame implements ActionListener {

    /**
     * Reference du jeu
     */
    private Jeu jeu;

    /**
     * Reference de la grille
     */
    private GrilleJeu grille;

    /**
     * Reference du content panel de la fenetre
     */
    private JPanel conteneurGeneral;

    /**
     * Affichage des coordonnees abscisses du plateau
     */
    private JPanel coordAbscisse;

    /**
     * Affichage des coordonnees ordonnees du plateau
     */
    private JPanel coordOrdonnee;

    /**
     * Affichage du joueur courant
     */
    private JoueurCourant joueurCourant;

    /**
     * Affichage de la main
     */
    private MainJoueur mainJoueur;

    /**
     * Affichage de la main
     */
    private choixAction choixAction;

    /**
     * Stock le nombre de joueur
     */
    private int nbJoueur;

    /**
     * Constructeur
     *
     * @param x position x de la fenetre
     * @param y position y de la fenetre
     */
    public Fenetre(int x, int y, int nbJoueur) {
        super("Robot Turtles");
        this.nbJoueur = nbJoueur;
        jeu = new Jeu(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Default : 14 / 12
        Dimension dim = new Dimension(60 * 13, 60 * 13);
        this.setSize(dim);
        this.setMinimumSize(dim);
        initFenetre();
        this.setLocation(x - this.getWidth() / 2, y - this.getHeight() / 2);
        this.setVisible(true);
    }

    /**
     * Initialise les variables et positionne les elements sur la fenetre
     */
    private void initFenetre() {

        //Creation de tous les conteneurs

        //Conteneur general de la fenetre
        conteneurGeneral = new JPanel();
        conteneurGeneral.setPreferredSize(this.getPreferredSize());

        //Grille du plateau de jeu
        grille = new GrilleJeu(this);
        grille.setPreferredSize(new Dimension(Case.CASE_LENGTH * 8, Case.CASE_LENGTH * 8));

        //Affichage du joueur courant
        joueurCourant = new JoueurCourant(this);
        joueurCourant.setPreferredSize(new Dimension(Case.CASE_LENGTH * 6, Case.CASE_LENGTH));

        //Affichage du choix action
        choixAction = new choixAction();
        choixAction.setPreferredSize(new Dimension(Case.CASE_LENGTH * 3, Case.CASE_LENGTH * 2));

        //Coords
        coordAbscisse = new JPanel();
        coordAbscisse.setLayout(new GridLayout(1, 8));
        for (char i = 'A'; i <= 'H'; i++) {
            JLabel c = new JLabel(i + "", JLabel.CENTER);
            c.setPreferredSize(new Dimension(Case.CASE_LENGTH, 10));
            coordAbscisse.add(c);
        }

        coordOrdonnee = new JPanel();
        coordOrdonnee.setLayout(new GridLayout(8, 1));
        for (int i = 8; i >= 1; i--) {
            JLabel c = new JLabel(i + "");
            c.setPreferredSize(new Dimension(10, Case.CASE_LENGTH));
            coordOrdonnee.add(c);
        }

        //Barre des menus du jeu
        Barre b = new Barre(this);
        this.setJMenuBar(b);

        //Affichage de la main
        mainJoueur = new MainJoueur(this, jeu);
        mainJoueur.setPreferredSize(new Dimension(Case.CASE_LENGTH * 8, Case.CASE_LENGTH * 2));

        //Positionnement sur le GridBagLayout
        conteneurGeneral.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Placement de affichage joueur courant
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 10, 0, 0);
        conteneurGeneral.add(joueurCourant, gbc);

        //Placement des ordonnees
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 0, 0);
        conteneurGeneral.add(coordOrdonnee, gbc);

        //Placement de la grille
        gbc.gridx = 2;
        gbc.insets = new Insets(0, 10, 0, 10);
        conteneurGeneral.add(grille, gbc);

        //Placement des abscisses
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 0, 10);
        conteneurGeneral.add(coordAbscisse, gbc);

        //Placement la main du joueur
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.gridwidth = 1;
        conteneurGeneral.add(mainJoueur, gbc);

        //Placement du choix de l'action
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 10, 0, 10);
        conteneurGeneral.add(choixAction, gbc);


        this.setContentPane(conteneurGeneral);

        JPanel gp = (JPanel) this.getGlassPane();
        gp.setLayout(null);
        gp.setVisible(false);

    }

    @Override
    public void repaint() {
        super.repaint();
    }

    /**
     * Getter jeu
     *
     * @return jeu
     */
    public Jeu getJeu() {
        return jeu;
    }

    /**
     * Getter grille
     *
     * @return grille
     */
    public GrilleJeu getGrille() {
        return grille;
    }

    /**
     * Getter nbJoueur
     *
     * @return nbJoueur
     */
    public int getNbJoueur() {
        return this.nbJoueur;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
    }
}
