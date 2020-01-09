package affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Menu du jeu
 */
public class Menu extends JFrame implements ActionListener, MouseListener {

    //Bouton deux joueurs
    private JButton jouer;

    //Bouton quitter
    private JButton quitter;

    private Background background;

    public Menu() {
        super("Robot Turtles");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(620, 802);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initFenetre();
        this.setVisible(true);
    }

    /**
     * Instancie et positionne les elements de la fenetre
     */
    public void initFenetre() {
        //Initialise les boutons
        Dimension taille = new Dimension(150, 50);

        jouer = new JButton("Jouer");
        jouer.setPreferredSize(taille);
        jouer.addActionListener(this);
        jouer.addMouseListener(this);

        background = new Background();
        background.setLayout(new BorderLayout());
        this.setContentPane(background);

        //Positionnement jouer
        background.add(jouer, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == jouer) {
            new selectionJoueur(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2, this);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

