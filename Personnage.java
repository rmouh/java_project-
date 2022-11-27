public class Personnage extends EntiteMobile {
    
    public String toString(String background)
    {
        String result = "";
        result = background.charAt(0) + direction + background.charAt(2);
        return (result);
    }
    public void direction_change()
    {

    }
    public void delete_pers()
    {
        
    }
    public void action(Case courante, Case cible)
    {
        if ((cible instanceof Sortie) == true){
                delete_pers();
        }else if (cible.estLibre()){// cqse libre 
                if (cible.getContenu() instanceof Obstacle) // !=null
                {
                    cible.getContenu().resistence--;
                    if (cible.getContenu().resistence <= 0)
                        cible.vide();
                }
                else {//avance le personnage 
                    cible.entre(courante.getContenu());
                    courante.vide(); 
                }
        }else {//case non traversable 
            direction_change();
        }
    }
}
