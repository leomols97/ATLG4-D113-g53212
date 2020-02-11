
import java.util.ArrayList;

/**
 *
 * @author leopoldmols
 */
public class Main
{
    public static void main(String[] args)
    {
        Compte compte = new Compte(0);
        ArrayList<Operation> l = new ArrayList();
        for(int i = 0; i < 20; i++){
            Operation op = new Operation(compte);
            l.add(op);
            op.start();
        }
    }
}