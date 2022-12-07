class CaseTraversable extends Case {
    protected Entite contenu;

    public CaseTraversable(int l, int c)
    {
        super(l, c);
        //contenu = null;
    }
    public Entite getContenu(){ return this.contenu;}
    public void setContenu(Entite e){ this.contenu = e;}
    public void vide(){ this.contenu = null;}
    public void entre(Entite e){ this.contenu = e;}
    public String toString(){return (contenu.toString());}
//    public boolean estLibre() { return ( (contenu == null) ? true : false);}
    public boolean estLibre() {
        if (contenu!= null)
            return (false);
        else
            return(true);
    }

}
