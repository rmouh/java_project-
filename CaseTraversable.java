public class CaseTraversable extends Case{
    protected Entite contenu;

    public CaseTraversable(int l, int c){super(l, c);}
    public Entite   getContenu(){   return (contenu);}

    public void   setContenu(Entite e){   this.contenu = e;}
    public void     vide(){   this.contenu = null;}
    
    public boolean  estLibre(){ return true;}
    
    public void     entre (Entite e){this.contenu = e;}



}
