public class Cases {

    abstract class Case {
        public final int lig;
        public final int col;

        public Case(int l, int c) {
            this.lig = l;
            this.col = c;
        }

        public abstract String toString();
        public abstract boolean estLibre();
    }

    abstract class Entite {
        private int resistance;

        public Entite(int r) { this.resistance = r;}

        public abstract String toString(String background);
    }

    class CaseTraversable extends Case {
        private Entite contenu;

        public Entite getContenu(){ return this.contenu;}
        public void vide(){ this.contenu = null;}
        public void entre(Entite e){ this.contenu = e;}
    }

    class CaseIntraversable extends Case {
        public boolean estLibre(){ return false;}
        public String toString(){ return "###";}
    }

    class CaseLibre extends CaseTraversable {
        public boolean estLibre(){
            if (getContenu() == null) {
                return true;
            } else {
                return false;
            }
        }
        public String toString(){
            if (getContenu() == null) {
                return "   ";
            } else {
                getContenu().toString("   ");
            }
        }
    }

    class Sortie extends CaseTraversable {
        public boolean estLibre() { return true;}
        public String toString(){
            if (getContenu() == null) {
                return "( )";
            } else {
                getContenu().toString("( )");
            }
        }
    }

    public class Obstacle extends Entite{

        public Obstacle(){super(3);}
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

    abstract class EntiteMobile extends Entite {
        protected String type;
        protected String direction;

        public EntiteMobile(String s, String d){
            super(0);
            if( s.compareToIgnoreCase("personnage") == 0)
            {
                type = "P";
                if (d.compareToIgnoreCase("nord") == 0)
                    direction = "^";
                else if (d.compareToIgnoreCase("sud") == 0)
                    direction = "v";
                else if (d.compareToIgnoreCase("est") == 0)
                    direction = ">";
                else if (d.compareToIgnoreCase("ouest") == 0)
                    direction = "<";
            }else {
                type = "M";
                if (d.compareToIgnoreCase("nord") == 0)
                    direction = "m";
                else if (d.compareToIgnoreCase("sud") == 0)
                    direction = "w";
                else if (d.compareToIgnoreCase("est") == 0)
                    direction = "»";
                else if (d.compareToIgnoreCase("ouest") == 0)
                    direction = "«";

            }
        }
        abstract public String toString(String background);
        abstract void action(Case courante, Case cible);

    }

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
                cible.contenu
                if (resistence <=0)courante.vide();
            }

            if (resistence <=0)

        }
        if (resistence <=0)courante.vide();
    }

    public class Monstre extends EntiteMobile {

        public String toString(String background) {
            String result = "";
            result = background.charAt(0) + direction + background.charAt(2);
            return (result);
        }
        public void action(Case courante, Case cible){

        }

    }
}