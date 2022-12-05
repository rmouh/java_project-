import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

class FenetreJeu extends JPanel {
    private Terrain terrain;
    private int tailleCase = 24;
    private int hauteur, largeur;
    private JFrame frame;

    public FenetreJeu(Terrain t) {
        this.hauteur = t.getHauteur();
        this.largeur = t.getLargeur();
        this.terrain = t;

        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(largeur * tailleCase, hauteur * tailleCase));

        JFrame frame = new JFrame("Donjon");
        this.frame = frame;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Case [][] c = terrain.get_C();
        for (int i = 0; i < terrain.getHauteur(); i++) {
            for (int j = 0; j < terrain.getLargeur() ; j++){
                if (c[i][j] instanceof Sortie)
                {
                    Color color = g.getColor();
                    g.setColor(Color.BLUE);
                    g.fillRect(j*tailleCase, i*tailleCase, tailleCase , tailleCase);
                }else if (c[i][j] instanceof CaseTraversable){
                    if (c[i][j] instanceof CaseLibre) {
                        if ((Entite) c[i][j].getContenu() instanceof Obstacle) {
                            Color color = g.getColor();
                            g.setColor(Color.DARK_GRAY);
                            g.fillOval(j * tailleCase, i * tailleCase, (int) (tailleCase * 0.9), (int) (tailleCase * 0.9));
                        } else if ((EntiteMobile) c[i][j].getContenu() instanceof Personnage) {
                            Color color = g.getColor();
                            g.setColor(Color.GREEN);
                            g.fillOval(j * tailleCase, i * tailleCase, (int) (tailleCase * 0.9), (int) (tailleCase * 0.9));
                        } else if ((EntiteMobile) c[i][j].getContenu() instanceof Monstre) {
                            Color color = g.getColor();
                            g.setColor(Color.RED);
                            g.fillOval(j * tailleCase, i * tailleCase, (int) (tailleCase * 0.9), (int) (tailleCase * 0.9));
                        }
                    }
                }else if (c[i][j] instanceof CaseIntraversable) {
                    Color color = g.getColor();
                    g.setColor(Color.BLACK);
                    g.fillRect(j*tailleCase, i*tailleCase, tailleCase , tailleCase);
                }
            }
        }
    }

    public void ecranFinal(int n) {
        frame.remove(this);
        JLabel label = new JLabel("Score " + n);
        label.setFont(new Font("Verdana", 1, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setSize(this.getSize());
        frame.getContentPane().add(label);
        frame.repaint();
    }
//    public static void main(String[] args) {
//        Jeu j = new Jeu("laby1.txt");
//        FenetreJeu fenetre = new FenetreJeu(j.terrain);
//
//
//    }

    // private static void FenetreJeu(Terrain terrain2) {
    // }
}