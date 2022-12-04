import java.util.Random;

public class Jeu {
    static int counter;
    Terrain terrain;
    static int sortis;

    /* Initialisation d'un jeu avec le terrain initial décrit dans
       le fichier [f] donné en paramètre */
    public Jeu(String f) {
        this.terrain = new Terrain(f);
        this.sortis = 0;
        this.counter = 5;
    }

    public Case getCaseCible(EntiteMobile e, int i, int j){
        Case [][] c = terrain.get_C();
        if (e.direction.equals(Direction.nord))
            return (c[i+1][j]);
        else if (e.direction.equals (Direction.sud))
            return (c[i-1][j]);
        else if (e.direction.equals(Direction.ouest))
            return (c[i][j-1]);
        else
            return (c[i][j+1]);

    }
    public void tour (){
        Case [][] c = terrain.get_C();
        for (int i = 0; i < terrain.get_H(); i++) {
            for (int j = 0; j < terrain.get_L() ; j++){
                if (!(c[i][j].estLibre()))
                {
                    Entite e =  c[i][j].getContenu();
                    if ((e instanceof Personnage))
                    { 
                        Personnage p = (Personnage)e;
                        p.action(c[i][j], getCaseCible(p, i, j));
                    }else if ((e instanceof Monstre))
                    { 
                        Monstre m = (Monstre)e;
                        m.action(c[i][j], getCaseCible(m, i, j));
                    }
            }
            }
        }
    }
    public static void main(String[] args) {
        Jeu j = new Jeu("laby1.txt");
        j.terrain.print();
    }
}
//    public static void main(String[] args) {
//        Case[][] c = terrain.get_C();
//        int ligne;
//        int colonne;
//        Random random = new Random();
//        for (int i = 0; i < terrain.get_H(); i++)  //les murs
//        {
//            c[0][i] = new CaseIntravesable();
//            c[terrain.get_H() - 1][i] = new CaseIntravesable();
//            c[i][0] = new CaseIntravesable();
//            c[i][terrain.get_L() - 1] = new CaseIntravesable();
//        }
//        for (int n = 0; n < 5; n++) {              //les personnages
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
//            terrain.print();
//            tour();
//        }

//    }
//}