import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Terrain {

    private int hauteur, largeur;
    private Case[][] carte;
    protected static int counter;
    public Case J_case;


    // public Terrain(int h, int l)
    // {
    //         hauteur = h;
    //         largeur = l;
    //         carte = new Case[h][l];

    // }

    public void print(){
        for (int i = 0;i < hauteur; i++) {
            for (int j = 0; j < largeur; j++)
            {
                if (carte[i][j]!= null )
                    System.out.print(carte[i][j].toString());
        
            }
            System.out.println();
        }
    }
    public int getHauteur(){return this.hauteur;}
    public int getLargeur(){return this.largeur;}
    public Case[][] get_C(){return this.carte;}

    /* Initialisation d'un terrain à partir de la description donnée par
       un fichier texte. Format du fichier de description :
       - hauteur et largeur sur la première ligne
       - puis dessin du terrain (un caractère == une case) avec le codage
         suivant
         '#' pour un mur
         ' ' (espace) pour une case libre
         'o' pour une sortie
         '@' pour une case libre contenant un obstacle
         '^', 'v', '>', '<' pour une case libre contenant un personnage
         'm', 'w', '»', '«' pour une case libre contenant un monstre
    */
    public Terrain(String file) {
        try {
            Scanner sc = new Scanner(new FileInputStream(file));
            this.hauteur = sc.nextInt();
            this.largeur = sc.nextInt();
            this.counter = 0;
            sc.nextLine();
            this.carte = new Case[hauteur][largeur];
            for (int l=0; l<hauteur; l++) {
                String line = sc.nextLine();
                for (int c=0; c<largeur; c++) {
                    Case cc;
                    Character ch = line.charAt(c);
                    switch (ch) {
                        case '#': cc = new CaseIntraversable(l, c); break;
                        case ' ': cc = new CaseLibre(l, c); break;
                        case 'o': cc = new Sortie(l, c); break;
                        case '@': cc = new CaseLibre(l, c, new Obstacle()); break;
                        case 'H': cc = new CaseLibre(l, c, new Joueur());
                        J_case = cc;
                        break;
                        case '^': case '>': case 'v': case '<':
                            cc = new CaseLibre(l, c, new Personnage(Direction.ofChar(ch)));
                            counter++;
                            break;
                        case 'm': case '»': case 'w': case '«':
                            cc = new CaseLibre(l, c, new Monstre(Direction.ofChar(ch)));
                            break;
                        default:  cc = null; break;
                    }
                    carte[l][c] = cc;
                }
            }
            sc.close();
        }
        catch (IOException e) { e.printStackTrace(); }
    }
}