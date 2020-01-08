package jeu.tuile;

public class Cards extends Tuile {

    //La couleur de la carte
    protected String couleur;

    //La famille de la carte
    protected String famille;

    /**
     * Constructeur de la carte
     *
     * @param couleur La couleur de la carte (BLEU/ROUGE/VIOLETTE/LASER)
     */
    public Cards(int x, int y, String couleur) {
        super(x, y, "CARTE", couleur);
    }
}
