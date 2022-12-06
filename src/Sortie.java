public class Sortie extends CaseTraversable{

    public Sortie(int l, int c){super (l, c);}
    public boolean estLibre() { return true;}
    public String toString(){
        if (getContenu() == null) {
            return "( )";
        } else {
            return (getContenu().toString("( )"));
        }
    }
}