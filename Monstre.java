public class Monstre extends EntiteMobile {
    
    public Monstre(String s, String d) {
        super(s, d);
    }

    public String toString(String background) {
        String result = "";
        result = background.charAt(0) + direction + background.charAt(2);
        return (result);
    }
    public void direction_change()
    {
        String new_d = this.direction;
        while (this.direction == new_d)
        {
            double nb = Math.random();
            if (nb <0.25)
                new_d = "m";
            else if (nb < 0.5)
                new_d = "w";
            else if (nb < 0.75)
                new_d = "«";
            else
                new_d = "»";
        }
        this.direction = new_d;
    }

    public void action(Case courante, Case cible){
        
        if (cible instanceof CaseIntraversable) || (cible instanceof Sortie){//le monstre peut pas avancer
            direction_change();
        
        }else {// case traversable
            if ((cible.getContenu() instanceof Obstacle) || (cible.getContenu() instanceof Personnage)) // !=null
            {// case cible occupée
                cible.getContenu().resistence--;
                if (cible.getContenu().resistence <= 0){
                    cible.vide();
                    if ((cible.getContenu() instanceof Personnage)){}
                        Jeu.counter--;
                }

            }else {// case libre
                cible.entre(courante.getContenu());
                courante.vide();
            }
        }
    }

}