/**
 * Cette classe crée un deadlock
 *
 * @author leopoldmols
 */
public class TD01 extends Thread
{
    private static String philo1 = "Philosophe 1";
    private static String philo2 = "Philosophe 2";
    
    public static void main (String [] args)
    {
        Thread t1 = new Thread()
        {
            public void run()
            {
                synchronized (philo1)
                {
                    System.out.println("Thread 1 : Philosophe 1 bloqué !");
                    
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (Exception e)
                    {
                    }
                    
                    synchronized (philo2)
                    {
                        System.out.println("Thread 1 : Philosophe 2 bloqué !");
                    }
                }
            }
        };
        
        Thread t2 = new Thread()
        {
            public void run()
            {
                synchronized (philo2)
                {
                    System.out.println("Thread 2 : Philosophe 2 bloqué !");
                    
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (Exception e)
                    {
                    }
                    
                    synchronized (philo1)
                    {
                        System.out.println("Thread 2 : Philosophe 1 bloqué !");
                    }
                }
            }
        };
        
        t1.start();
        t2.start();
    }
}