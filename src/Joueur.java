public class Joueur extends Entite{
    public Joueur(){
        super(3);
    }
    public String toString(String background){
        return (background.charAt(0) + "H" + background.charAt(2));
    }
//    public void curseur(){}
}
