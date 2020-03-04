package g53212.atlg4.intro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testSum() {
        System.out.println("testSum general case");
        //Arrange
        int nb1 = 10;
        int nb2 = 32;
        //Action
        g12345.atlg4.intro.App app    = new g12345.atlg4.intro.App();
        int                    result = app.sum(nb1, nb2);
        //Assert
        int expected = 42;
        assertEquals(expected, result);
    }

    @Test
    public void testDiv_when_divisorIsNull() {
        System.out.println("testDiv nb2 is null");
        //Arrange
        int nb1 = 10;
        int nb2 = 0;
        //Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //Action
            g12345.atlg4.intro.App app = new g12345.atlg4.intro.App();
            app.div(nb1, nb2);
        });
    }

    @Test
    public void testDivl() {
        System.out.println("testDiv general case");
        //Arrange
        int nb1 = 4;
        int nb2 = 2;
        //Action
        g12345.atlg4.intro.App app    = new g12345.atlg4.intro.App();
        int                    result = app.div(nb1, nb2);
        //Assert
        int expected = 2;
        assertEquals(expected, result);
    }
}
