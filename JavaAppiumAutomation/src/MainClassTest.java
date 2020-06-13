import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {

    @Test
    public void testGetLocalNumber()
    {
       MainClass main = new MainClass();

       int expected = 14;
       int actual = main.getLocalNumber();

        Assert.assertTrue("LocalNumber != 14", actual == expected);
    }
}
