public class CaseTraversable extends Case{
    protected Entite contenu;

    abstruct public Entite   getContenu(){   return (contenu);}

    public void     vide(){   this.contenu = null;}
    
    public boolean  estLibre(){ return true;}
    
    public void     entre (Entite e){this.contenu = e;}



}
