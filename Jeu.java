public class Jeu {
    static int counter;
    Terrain terrain;
    int sortis;

    /* Initialisation d'un jeu avec le terrain initial dÃ©crit dans
       le fichier [f] donnÃ© en paramÃ¨tre */
    public Jeu(String f) {
        this.terrain = new Terrain(f);
        this.sortis = 0;
    }

    public static void main(String[] args) {
        Jeu j = new Jeu("laby1.txt");
        j.terrain.print();
    }
    public Case getCaseCible(EntiteMobile e, int i, int j){
        Case [][] c = terrain.get_C();
        if (e.direction ==  "m" || e.direction ==  "^")
            return (c[i+1][j]);
        else if (e.direction == "w" || e.direction ==  "v")
            return (c[i-1][j]);
        else if (e.direction == "«" || e.direction ==  "<")
            return (c[i][j-1]);
        else
            return (c[i][j+1]);

    }
    public void tour (){
        Case [][] c = terrain.get_C();
        for (int i = 0;i < terrain.get_H(); i++) {
            for (int j = 0; j < terrain.get_L() ; j++){
                Entite e =  c[i][j].getContenu();
             if ((e instanceof Personnage) || (e instanceof Monstre))
                 e.action(c[i][j],getCaseCible(e, i, j));
            }
        }
    }
}
//    public static void main(String[] args) {
//        Case[][] c = terrain.get_C();
//        int ligne;
//        int colonne;
//        Random random = new Random();
//        for (int i = 0; i < terrain.get_H(); i++)  //le mur
//        {
//            c[0][i] = new CaseIntravesable();
//            c[terrain.get_H() - 1][i] = new CaseIntravesable();
//            c[i][0] = new CaseIntravesable();
//            c[i][terrain.get_H() - 1] = new CaseIntravesable();
//        }
//        for (int n = 0; n < 5; n++) {              //les personnage
//            int nb = random.nextInt(terrain.get_H * terrain.get_L()) + 1;
//            ligne = nb / terrain.get_H();
//            colonne = nb % terrain.get_H() - 1;
//            if (c[ligne][colonne].estLibre())
//                c[ligne][colonne].getContenu = new Personnage();
//            else
//                n--;
//        }
//        for (int n = 0; n < 5; n++) {         //les monstre
//            int nb = random.nextInt(terrain.get_H * terrain.get_L()) + 1;
//            ligne = nb / terrain.get_H();
//            colonne = nb % terrain.get_H() - 1;
//            if (c[ligne][colonne].estLibre())
//                c[ligne][colonne].getContenu = new Monstre();
//            else
//                n--;
//        }
//        for (int n = 0; n < 5; n++) {           //les obstacle
//            int nb = random.nextInt(terrain.get_H * terrain.get_L()) + 1;
//            ligne = nb / terrain.get_H();
//            colonne = nb % terrain.get_H() - 1;
//            if (c[ligne][colonne].estLibre())
//                c[ligne][colonne].getContenu = new Obstacle();
//            else
//                n--;
//        }
//        while (true) {
//            int nb = random.nextInt(terrain.get_H * terrain.get_L() + 1);
//            ligne = nb / terrain.get_H();
//            colonne = nb % terrain.get_H() - 1;
//            if (c[ligne][colonne].estLibre()) {
//                c[ligne][colonne].getContenu = new Sortie();
//                break;
//            }
//        }
//    }

//}