abstract class Case {
    private final int lig;
    private final int col;

    public Case(int l, int c)
    {
        lig = l;
        col = c;
    }
    public int getLig_Y(){return (lig);}
    public int getCol_X(){return (col);}

    public abstract String toString();
    public abstract boolean estLibre();
    public abstract void vide();
    public abstract void entre (Entite e);
    public abstract Entite getContenu(); 
}
