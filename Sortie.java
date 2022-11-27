public class Sortie extends CaseTraversable{

    //public boolean estLibre() { return true;}
    public String toString(){
        if (getContenu() == null) {
            return "( )";
        } else {
            return (getContenu().toString("( )"));
        }
    }
    
}
