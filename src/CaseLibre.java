public class CaseLibre extends CaseTraversable{
    
    public CaseLibre(int l, int c){super (l, c);}
    public CaseLibre(int l, int c, Obstacle o){
        super (l, c);
        contenu = o;
    }
//    public CaseLibre(int l, int c, Personnage p){
//        super (l, c);
//        contenu = p;
//    }
//    public CaseLibre(int l, int c, Monstre m){
//        super (l, c);
//        contenu = m;
//    }
    public CaseLibre(int l, int c, EntiteMobile e){
        super (l, c);
        contenu = e;
    }
    //public boolean estLibre(){return ( (contenu.resistence == 0) ? true : false);}
    public boolean estLibre(){return (true);}
    public String toString(){
        if (getContenu() == null) {
            return "   ";
        } else {
            return (getContenu().toString("   "));
        }
    }
}
