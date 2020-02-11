/**
 * Cette classe permet de maintenir un solde bancaire
 * 
 * @author leopoldmols
 */
public class Compte
{
    private int somme;

    public Compte(int somme)
    {
        this.somme = somme;
    }
    
    public void deposerArgent(int somme)
    {
        this.somme += somme;
    }
    
    public void retirerArgent(int somme)
    {
        this.somme -= somme;
    }

    public int getSomme()
    {
        return somme;
    }
}
