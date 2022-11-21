abstract class Case {
    private final int lig;
    private final int col;

    public Case(int l, int c)
    {
        lig = l;
        col = c;
    }

    public abstract boolean estLibre();
    public abstract void vide();
    public abstract void entre (Entite e);




    
}
