public class Joueur extends Entite{

    protected static boolean en_vie;

    public Joueur(){
        super(3);
        en_vie = true;
    }
    public String toString(String background){
        return (background.charAt(0) + "H" + background.charAt(2));
    }
    public boolean action(Case courante, Case cible){
        if (cible instanceof Sortie) {// personnage sort
                cible.entre(courante.getContenu());
                courante.vide();
                return (true);
            }
        if (cible instanceof CaseLibre) {
            if((cible.estLibre())) {
                cible.entre(courante.getContenu());
                courante.vide();
                return (true);
            }
        }
        return (false);
    }

}
