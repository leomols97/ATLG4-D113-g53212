public class App
{
    public static void main(String[] args)
    {
        App app = new App();
        int result = app.sum(30, 12);
        System.out.println("Le résultat est " + result);
    }
    public int sum(int nb1, int nb2)
    {
        return nb1 + nb2;
    }
}