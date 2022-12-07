public class Joueur extends Entite{

    protected boolean en_vie;

    public Joueur(){
        super(3);
        en_vie = true;
    }
    public String toString(String background){
        return (background.charAt(0) + "H" + background.charAt(2));
    }
    public void action(Case courante, Case cible){
        if (cible instanceof CaseLibre) {
            cible.entre(courante.getContenu());
            courante.vide();
        }
    }
}
