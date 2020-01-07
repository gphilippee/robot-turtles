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

    public Menu(){
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
    public void initFenetre(){
        //Initialise les boutons
        Dimension taille = new Dimension(150, 50);

        jouer = new JButton("Jouer");
        jouer.setPreferredSize(taille);
        jouer.addActionListener(this);
        jouer.addMouseListener(this);

        quitter = new JButton("Quitter");
        quitter.addActionListener(this);

        background = new Background();
        background.setLayout(new GridBagLayout());
        this.setContentPane(background);

        /**
        JLabel titre = new JLabel("Robot Turtles");
        titre.setFont(new Font("Dialog", Font.BOLD,50));
        titre.setHorizontalAlignment(JLabel.CENTER);
         */

        //Positionnement
        GridBagConstraints gbc = new GridBagConstraints();

        //positionnement deux joueurs
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        background.add(jouer, gbc);

        //positionnement quitter
        gbc.gridy = 4;
        background.add(quitter, gbc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == jouer){
            new selectionJoueur(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2,this);
        }

        if(source == quitter){
            setVisible(false);
            this.dispose();
            System.exit(0);
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
