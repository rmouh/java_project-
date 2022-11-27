public class Obstacle extends Entite{
    
    public Obstacle(){super(3);}
    public Obstacle(int r){super(r);}
    public String toString(String background){
        String result = "";

        if(resistence >= 3)
            result = "@@@";
        else if (resistence == 1)
            result = background.charAt(0) + "@" + background.charAt(2);
        else if (resistence == 2)
            result = background.charAt(0) + background.charAt(2) + "@";
        return (result);
    }
}
