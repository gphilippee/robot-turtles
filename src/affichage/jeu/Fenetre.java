package affichage.jeu;


import affichage.Case;
import affichage.JoueurCourant;
import affichage.MainJoueur;
import affichage.choixAction;
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
    private affichage.choixAction choixAction;

    /**
     * Stock le nombre de joueur
     */
    private int nbJoueur;

    /**
     * Zone de text pour l'affichage d'informations sur la partie
     */
    private JTextArea logsPartie;

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
        Dimension dim = new Dimension(60 * 16, 60 * 13);
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
        joueurCourant.setPreferredSize(new Dimension(Case.CASE_LENGTH * 8, Case.CASE_LENGTH));

        //Affichage du choix action
        choixAction = new choixAction(this);
        choixAction.setPreferredSize(new Dimension(Case.CASE_LENGTH * 3, Case.CASE_LENGTH * 2));

        //Logs de la partie
        logsPartie = new JTextArea();
        logsPartie.setEditable(false);
        logsPartie.setLineWrap(true);
        logsPartie.setMargin(new Insets(5, 5, 5, 5));
        JScrollPane scrollZone = new JScrollPane(logsPartie);
        scrollZone.setPreferredSize(new Dimension(Case.CASE_LENGTH * 6, Case.CASE_LENGTH * 8));
        scrollZone.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

        //Ajout du texte
        this.addLogPartie("Bienvenue sur Robot Turtles");
        this.addLogPartie("Vous avez choisi le mode " + nbJoueur + " joueurs.");


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
        mainJoueur = new MainJoueur(this);
        mainJoueur.setPreferredSize(new Dimension(470, Case.CASE_LENGTH * 2));

        //Positionnement sur le GridBagLayout
        conteneurGeneral.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //Placement de affichage joueur courant
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
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

        //Placement des logs de la partie
        gbc.gridx = 3;
        gbc.insets = new Insets(0, 10, 0, 0);
        gbc.gridwidth = 1;
        conteneurGeneral.add(scrollZone, gbc);

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
        gbc.gridy = 3;
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
        this.grille.updateGrille();
        this.joueurCourant.update();
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
     * Ajoute un message au logs de la partie
     *
     * @param s message
     */
    public void addLogPartie(String s) {
        logsPartie.append(s + "\n");
        logsPartie.setCaretPosition(logsPartie.getDocument().getLength());
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
