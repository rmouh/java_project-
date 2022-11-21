public class Personnage extends EntiteMobile {
    
    public String toString(String background)
    {
        String result = "";
        result = background.charAt(0) + direction + background.charAt(2);
        return (result);
    }
    public void action(Case courante, Case cible)
    {
        if (cible.estLibre())
        {
            resistence--;
            if (resistence <=0)courante.vide();
        }

        if (resistence <=0)

    }
}
