public class CaseLibre extends CaseTraversable{
    
    public boolean estLibre(){return ( (contenu.resistence == 0) ? true : false);}
    //public boolean estLibre(){return ( (contenu == null) ? true : false);}
    public String toString(){
        if (getContenu() == null) {
            return "   ";
        } else {
            return (getContenu().toString("   "));
        }
    }
}
