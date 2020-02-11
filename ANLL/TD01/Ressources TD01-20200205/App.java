package g12345.atlg4.intro;

public class App {

    public static void main(String[] args) {
        App app = new App();
        int result = app.sum(30, 12);
        System.out.println("Le résultat est " + result);
    }

    public int sum(int nb1, int nb2) {
        return nb1 + nb2;
    }

    public int div(int nb1, int nb2) {
        if (nb1 == 0 || nb2 == 0) {
            throw new IllegalArgumentException("Un des nombres vaut 0 " + nb1 + " " + nb2);
        }
        return nb1 - nb2;
    }
}
