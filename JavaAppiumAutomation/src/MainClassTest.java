import org.junit.Assert;
import org.junit.Test;

public class MainClassTest {

    MainClass main = new MainClass();

    @Test
    public void testGetLocalNumber()
    {
       int expected = 14;
       int actual = main.getLocalNumber();

        Assert.assertTrue("LocalNumber != 14", actual == expected);
    }

    @Test
    public void testGetClassNumber()
    {
        int actual = main.getClassNumber();
        int compared = 45;

        Assert.assertTrue("ClassNumber <= 45", actual > compared);
    }
}
