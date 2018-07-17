package TestDemo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by hvargas on 7/11/2018.
 */
public class TestNotation {
    @BeforeClass
    public void oneTimeSetUp() {
        System.out.println(" @BeforeClass-oneTimeSetUp");
    }

    @Test
    public void one() {
        System.out.println("@Test-one");
    }
}
