package affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Selection du nombre de joueur : 1, 2 ou 3
 */
public class selectionJoueur extends JFrame implements ActionListener {

    //Bouton deux joueurs
    private JButton deuxJoueurs;

    //Bouton trois joueurs
    private JButton troisJoueurs;

    //Bouton quatre joueurs
    private JButton quatreJoueurs;

    /**
     * Reference du menu
     */
    private Menu menu;

    public selectionJoueur(int x, int y, Menu menu) {
        this.menu = menu;
        JPanel pan = new JPanel(new GridLayout(3, 1, 1, 1));
        this.setSize(200, 300);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setResizable(false);
        deuxJoueurs = new JButton("2 joueurs");
        deuxJoueurs.addActionListener(this);
        troisJoueurs = new JButton("3 joueurs");
        troisJoueurs.addActionListener(this);
        quatreJoueurs = new JButton("4 joueurs");
        quatreJoueurs.addActionListener(this);
        this.setContentPane(pan);
        pan.add(deuxJoueurs);
        pan.add(troisJoueurs);
        pan.add(quatreJoueurs);
        this.setLocation(x - this.getWidth() / 2, y - this.getHeight() / 2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == deuxJoueurs) {
            menu.setVisible(false);
            menu.dispose();
            this.setVisible(false);
            this.dispose();
            new Fenetre(this.getX() + this.getWidth(), this.getY() + this.getHeight(), 2);
        }

        if (source == troisJoueurs) {
            menu.setVisible(false);
            menu.dispose();
            this.setVisible(false);
            this.dispose();
            new Fenetre(this.getX() + this.getWidth(), this.getY() + this.getHeight(), 3);
        }

        if (source == quatreJoueurs) {
            menu.setVisible(false);
            menu.dispose();
            this.setVisible(false);
            this.dispose();
            new Fenetre(this.getX() + this.getWidth(), this.getY() + this.getHeight(), 4);
        }
    }
}
