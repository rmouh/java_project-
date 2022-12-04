public class CaseIntraversable extends Case{
    public CaseIntraversable(int l, int c){super(l, c);}
    public boolean estLibre(){ return false;}
    public String toString(){ return "###";}
    @Override
    public void vide() {        
    }
    @Override
    public void entre(Entite e) {
    }
    @Override
    // public Entite getContenu() {
    //     return (null);
    // }
}