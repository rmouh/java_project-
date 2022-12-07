public class Monstre extends EntiteMobile {
    
    // public Monstre(String s, String d) {
    //     super(s, d);
    // }
    public Monstre(Direction ofChar) {
        super (ofChar);
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
    // public String toString(String background) {
    //     String result = "";
    //     if (direction == )
    //     result = background.charAt(0) + direction + background.charAt(2);
    //     return (result);
    // }
//    public void direction_change()
//    {
//        Direction new_d = this.direction;
//        while (this.direction.equals(new_d))
//        {
//            double nb = Math.random();
//            if (nb <0.25)
//                new_d = Direction.est;
//            else if (nb < 0.5)
//                new_d = Direction.nord;
//            else if (nb < 0.75)
//                new_d = Direction.ouest;
//            else
//                new_d = Direction.sud;
//        }
//        this.direction = new_d;
//    }
    public void direction_change()
    {
        //Direction new_d = this.direction;
        while (this.direction.equals(this.direction.random()))
        {
            this.direction = this.direction.random();
        }
    }
    public void action(Case courante, Case cible){

        if( (cible instanceof CaseIntraversable) || (cible instanceof Sortie)){//le monstre peut pas avancer
            direction_change();
        }else {// case traversable
            if ((cible.getContenu() instanceof Obstacle) || (cible.getContenu() instanceof Personnage) || (cible.getContenu() instanceof Joueur)) // !=null
            {// case cible occupée
                cible.getContenu().resistence--;
                if (cible.getContenu().resistence <= 0) {
                    if ((cible.getContenu() instanceof Personnage))
                        Terrain.counter--;
                    cible.vide();
                    cible.entre(courante.getContenu());
                    courante.vide();
                } else
                    direction_change();
            }else if ((cible.getContenu() instanceof Monstre)) {// case monstre
                direction_change();
            }else{
                cible.entre(courante.getContenu());
                courante.vide();
            }
        }
    }

}