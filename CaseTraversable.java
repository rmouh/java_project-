public class CaseTraversable extends Case{
    protected Entite contenu;

    public Entite getContenu()
    {   return (contenu);}

    public void vide()
    {   contenu.resistence = 0;}

    public void entre (Entite e)
    {contenu = e;}



}
