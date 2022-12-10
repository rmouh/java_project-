public class Obstacle extends Entite{
    private int C_degree;
    
    public Obstacle(){
        super(3);
        C_degree = 64;
    }

    public int get_Color(){return (this.C_degree);}
    public void set_Color(int n){
        this.C_degree = this.C_degree + n;
    }
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
