import java.util.Random;

public class Jeu {
//    static int counter;
    Terrain terrain;
    int sortis;

    /* Initialisation d'un jeu avec le terrain initial décrit dans
       le fichier [f] donné en paramètre */
    public Jeu(String f) {
        this.terrain = new Terrain(f);
        this.sortis = 0;
        //this.counter = 100;
    }

    public Case getCaseCible(EntiteMobile e, int i, int j) {
        Case[][] c = terrain.get_C();
        if (e.direction.equals(Direction.nord)) {
//            if (i == 0)
//                return (c[i + 1][j]);
            return (terrain.get_C()[i - 1][j]);
        }
        else if (e.direction.equals(Direction.sud)) {
//            if (i == terrain.getHauteur())
//                return (c[i - 1][j]);
            return (terrain.get_C()[i + 1][j]);
        }
        else if (e.direction.equals(Direction.ouest)) {
//            if( j == 0)
//                return (c[i][j + 1]);
            return (terrain.get_C()[i][j - 1]);
        }
        else {
//            if(j == terrain.getLargeur())
//                return (c[i][j - 1]);
            return (terrain.get_C()[i][j + 1]);
        }

    }

    public void tour() {
        Case[][] c = terrain.get_C();
        for (int i = 0; i < terrain.getHauteur(); i++) {
            for (int j = 0; j < terrain.getLargeur(); j++) {
                //System.out.printf("true");

                if (c[i][j] instanceof CaseTraversable) {
                    //System.out.printf("true");

                    if (!(c[i][j].estLibre())) {
                        //System.out.printf("true");
                        //if (c[i][j] instanceof C)
                        Entite e = c[i][j].getContenu();
                        if ((e instanceof Personnage)) {
                            Personnage p = (Personnage) e;
                            p.action(c[i][j], getCaseCible(p, i, j));
                            if (partieFinie()) break;
                        } else if ((e instanceof Monstre)) {
                            Monstre m = (Monstre) e;
                            m.action(c[i][j], getCaseCible(m, i, j));
                            if(getCaseCible(m, i, j).getContenu() instanceof Obstacle)
                            {

                                ((Obstacle) getCaseCible(m, i, j).getContenu()).set_Color(32);

                            }
//                        }else if ((e instanceof Joueur)){
////                            e.curseur();
                        }
                    }
                }
            }
        }
    }

    public Boolean partieFinie() {
        return ((Terrain.counter == 0) || (Joueur.en_vie == false));
    }

    public static void main(String[] args) {
        int d = 10;
        Jeu j = new Jeu("laby2.txt");
        while (d-- > 0) {
            j.terrain.print();
            j.tour();
            j.terrain.print();
        }
    }
}
//    public static void main(String[] args) {
//         Jeu j = new Jeu("laby1.txt");
//         Case[][] c = terrain.get_C();
//         int ligne;
//         int colonne;
//         Random random = new Random();
//         for (int i = 0; i < terrain.get_H(); i++)  //les murs
//         {
//            c[0][i] = new CaseIntravesable();
//            c[terrain.get_H() - 1][i] = new CaseIntravesable();
//            c[i][0] = new CaseIntravesable();
//            c[i][terrain.get_L() - 1] = new CaseIntravesable();
//         }
//         for (int n = 0; n < 5; n++) {              //les personnages
//            int nb = random.nextInt(terrain.get_H * terrain.get_L()) + 1;
//            ligne = nb / terrain.get_L();
//            colonne = nb % terrain.get_L() - 1;
//            if (c[ligne][colonne].estLibre())
//                c[ligne][colonne].setContenu = new Personnage();
//            else
//                n--;
//        }
//        for (int n = 0; n < 5; n++) {         //les monstres
//            int nb = random.nextInt(terrain.get_H * terrain.get_L()) + 1;
//            ligne = nb / terrain.get_L();
//            colonne = nb % terrain.get_L() - 1;
//            if (c[ligne][colonne].estLibre())
//                c[ligne][colonne].setContenu = new Monstre();
//            else
//                n--;
//        }
//        for (int n = 0; n < 5; n++) {           //les obstacles
//            int nb = random.nextInt(terrain.get_H * terrain.get_L()) + 1;
//            ligne = nb / terrain.get_L();
//            colonne = nb % terrain.get_L() - 1;
//            if (c[ligne][colonne].estLibre())
//                c[ligne][colonne].setContenu = new Obstacle();
//            else
//                n--;
//        }
//        while (true) {                            //la sortie
//            int nb = random.nextInt(terrain.get_H * terrain.get_L() + 1);
//            ligne = nb / terrain.get_L();
//            colonne = nb % terrain.get_L() - 1;
//            if (c[ligne][colonne].estLibre()) {
//                c[ligne][colonne].setContenu = new Sortie();
//                break;
//            }
//        }
//        while (counter > 0) {
//            j.terrain.print();
//            j.tour();
//        }

//    }
// }