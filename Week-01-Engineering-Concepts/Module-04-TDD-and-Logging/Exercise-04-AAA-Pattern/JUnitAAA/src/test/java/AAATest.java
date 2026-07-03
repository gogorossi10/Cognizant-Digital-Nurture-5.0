import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AAATest {

    private int number;

    @Before
    public void setUp() {

        System.out.println("Setup executed");

        number = 10;

    }

    @After
    public void tearDown() {

        System.out.println("Teardown executed");

    }

    @Test
    public void testAddition() {

        // Arrange
        int value = number;

        // Act
        int result = value + 5;

        // Assert
        assertEquals(15, result);

    }

}