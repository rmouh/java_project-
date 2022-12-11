public class Personnage extends EntiteMobile {

    // public Personnage(String s, String d) {
    //     super(s, d);
    // }

    public Personnage(Direction ofChar) {
        super(ofChar);
    }

    public String toString(String background) {
        if (direction.equals(Direction.nord))
            return (background.charAt(0) + "^" + background.charAt(2));
        else if (direction.equals(Direction.sud))
            return (background.charAt(0) + "v" + background.charAt(2));
        else if (direction.equals(Direction.est))
            return (background.charAt(0) + ">" + background.charAt(2));
        else
            return (background.charAt(0) + "<" + background.charAt(2));
    }

    // public String toString(String background)
    // {
    //     String result = "";
    //     result = background.charAt(0) + direction + background.charAt(2);
    //     return (result);
    // }
    // public void direction_change()
    // {
    //     Direction new_d = this.direction;
    //     while (this.direction == new_d)
    //     {
    //         double nb = Math.random();
    //         if (nb <0.25)
    //             new_d = ">";
    //         else if (nb < 0.5)
    //             new_d = "<";
    //         else if (nb < 0.75)
    //             new_d = "v";
    //         else
    //             new_d = "^";
    //     }
    //     this.direction = new_d;
    // }
    public void direction_change() {
        Direction new_d = this.direction.random();
        while (this.direction.equals(new_d)) {
            new_d = this.direction.random();
        }
        this.direction = new_d;
    }

    public void action(Case courante, Case cible) {
        if (cible instanceof Sortie) {// personnage sort
            courante.vide();
            Terrain.counter--;
            //Jeu.sortis++;
        } else if (cible instanceof CaseTraversable) {// case traversable
            if (cible.getContenu() instanceof Obstacle) // cible = obstacle
            {
                cible.getContenu().resistence--;
                if (cible.getContenu().resistence <= 0) {
                    cible.vide();
                    cible.entre(courante.getContenu());
                    courante.vide();
                } else
                    direction_change();
            }else if (cible.getContenu() instanceof Monstre)  // cible = monstre
            {
                direction_change();
                cible.entre(courante.getContenu());
                courante.vide();
            }else if (cible.getContenu() instanceof Personnage || cible.getContenu() instanceof Joueur) { // cible = monstre
                    direction_change();
            } else {//avance le personnage
            cible.entre(courante.getContenu());
            courante.vide();
            }
        }else{//case non traversable
            direction_change();
        }
    }
}
