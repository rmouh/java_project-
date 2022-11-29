public class CaseIntraversable extends Case{
    public CaseIntraversable(int l, int c){super(l, c);}
    public boolean estLibre(){ return false;}
    public void     vide(){   this.contenu = null;}
    public String toString(){ return "###";}
}
