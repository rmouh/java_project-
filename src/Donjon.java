import javax.swing.Timer;

public class Donjon {
    public static void main(String[] args) {
        int tempo = 600;
        Jeu jeu = new Jeu("laby2.txt");
        FenetreJeu graphic = new FenetreJeu(jeu.terrain);
        //graphic.addKeyListener(graphic);
        Timer timer = new Timer(tempo, e -> {
            jeu.tour();
            graphic.repaint();//probleme de changement de direction 
            if (jeu.partieFinie()) { graphic.ecranFinal(jeu.sortis); }
        });
        timer.setInitialDelay(0);
        timer.start();
    }
}