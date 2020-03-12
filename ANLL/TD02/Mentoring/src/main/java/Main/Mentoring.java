package Main;

import java.io.File;

/**
 *
 * @author leopoldmols
 */
public class Mentoring
{
    public static void main ( String[] args )
    {
        Mentoring m = new Mentoring();
    }
    
    public Mentoring () 
            // Il faut un constructeur car one ne peut pas faire
            // appel à des méthodes non-static dans des méthodes statics
    {
        System.out.println("Chemin courant \t" + new File(".").getAbsolutePath());
        System.out.println("Chemin classe \t" + this.getClass().getResource(".").getPath());
        System.out.println("Chemin jar \t" + new File(getClass().getClassLoader().getResource(".").getFile()));
    }
}
