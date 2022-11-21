public class Jeu {

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
}