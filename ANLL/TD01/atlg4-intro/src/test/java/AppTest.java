/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author leopoldmols
 */
public class AppTest {
    
    public AppTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of sum method, of class App.
     */
    @Test
    public void testSum() {
        System.out.println("testSum general case"); //Arrange
        int nb1 = 10;
        int nb2 = 32;
        //Action
        g12345.atlg4.intro.App app    = new g12345.atlg4.intro.App();
        int                    result = app.sum(nb1, nb2);
        //Assert
        int expected = 42;
        assertEquals(expected, result);
    }
    
}
