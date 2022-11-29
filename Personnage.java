public class Personnage extends EntiteMobile {

    public Personnage(String s, String d) {
        super(s, d);
    }

    public String toString(String background)
    {
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
                new_d = ">";
            else if (nb < 0.5)
                new_d = "<";
            else if (nb < 0.75)
                new_d = "v";
            else
                new_d = "^";
        }
        this.direction = new_d;
    }

    public void action(Case courante, Case cible)
    {
        if (cible instanceof Sortie){
            courante.vide();
            Jeu.counter--;
        }else if (cible instanceof CaseTraversable){// cqse libre
                if (cible.getContenu() instanceof Obstacle) // !=null
                {
                    cible.getContenu().resistence--;
                    if (cible.getContenu().resistence <= 0)
                        cible.vide();
                }
                else if (cible.getContenu() instanceof Monstre) {//avance le personnage
                    direction_change();
                }else {
                    cible.entre(courante.getContenu());
                    courante.vide();
                }
        }else {//case non traversable 
            direction_change();
        }
    }
}
