public class CaseLibre extends CaseTraversable{
    
    public CaseLibre(int l, int c){super (l, c);}
    public CaseLibre(int l, int c, Obstacle o){
        super (l, c);
        contenu = o;
    }
    public CaseLibre(int l, int c, EntiteMobile e){
        super (l, c);
        contenu = e;
    }
    //public boolean estLibre(){return ( (contenu.resistence == 0) ? true : false);}
    public boolean estLibre(){return ( (contenu == null) ? true : false);}
    public String toString(){
        if (getContenu() == null) {
            return "   ";
        } else {
            return (getContenu().toString("   "));
        }
    }
}
