 /**
  * Cette classe simule, dans une thread,
  * une succession infinie d’opérations
  * ajoutant et retirant une même somme
  * sur un compte donné,
  * puis affichant le solde du compte.
  *
  * @author leopoldmols
  */
public class Operation extends Thread
{
    private Compte compte;
    
    public Operation(Compte compte)
    {
        this.compte = compte;
    }
    
    
    @Override
    public void run()
    {
        try
        {
            synchronized(compte)
            {
                compte.deposerArgent(200);
                System.out.println("Somme du compte après avoir ajouté 200€ : " + compte.getSomme());
                compte.retirerArgent(200);
                System.out.println("Somme du compte après avoir retiré 200€ : " + compte.getSomme());
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e)
        {
        }
    }
}