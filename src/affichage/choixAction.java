package affichage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Choix de l'action : completer le programme, construire un mur ou executer le programme
 */
public class choixAction extends JPanel implements ActionListener {

    //Bouton completer le programme
    private JButton completeProgramme;

    //Bouton construire un mur
    private JButton construireMur;

    //Bouton exectuer le programme
    private JButton executeProgramme;

    public choixAction() {
        initConteneur();

    }

    public void initConteneur() {
        completeProgramme = new JButton("Completer le programme");
        completeProgramme.addActionListener(this);

        construireMur = new JButton("Construire un mur");
        construireMur.addActionListener(this);

        executeProgramme = new JButton("Éxécuter le programme");
        executeProgramme.addActionListener(this);

        this.setLayout(new GridLayout(3, 1));

        this.add(completeProgramme);
        this.add(construireMur);
        this.add(executeProgramme);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == completeProgramme) {
        }

        if (source == construireMur) {
        }

        if (source == executeProgramme) {

        }
    }
}
