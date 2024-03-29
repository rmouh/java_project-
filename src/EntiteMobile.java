abstract class EntiteMobile extends Entite {
    //protected String type;\
    //protected String direction;
    protected Direction direction;

    public EntiteMobile(Direction d){
            super(3);
            direction = d;
    }
    public Direction getDirection(){return (direction);}
    public void setDirection(Direction d){
        this.direction = d;
    }
    abstract public String toString(String background);
    abstract void action(Case courante, Case cible);
    // public EntiteMobile(String s, String d){
    //     super(3);
    //     if( s.compareToIgnoreCase("personnage") == 0)
    //     {
    //         type = "P";
    //         if (d.compareToIgnoreCase("nord") == 0)
    //             direction = "^";
    //         else if (d.compareToIgnoreCase("sud") == 0)
    //             direction = "v";
    //         else if (d.compareToIgnoreCase("est") == 0)
    //             direction = ">";
    //         else if (d.compareToIgnoreCase("ouest") == 0)
    //             direction = "<";
    //     }else {
    //         type = "M";
    //         if (d.compareToIgnoreCase("nord") == 0)
    //             direction = "m";
    //         else if (d.compareToIgnoreCase("sud") == 0)
    //             direction = "w";
    //         else if (d.compareToIgnoreCase("est") == 0)
    //             direction = "»";
    //         else if (d.compareToIgnoreCase("ouest") == 0)
    //             direction = "«";

    //     }
    // }
}
