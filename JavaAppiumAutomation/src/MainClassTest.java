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

    @Test
    public void testGetClassString()
    {
        String actual = main.getClassString();
        boolean containsLowerCase = actual.contains("hello");
        boolean containsUpperCase = actual.contains("Hello");
        String errorMessage = "Text doesn't contain 'hello' or 'Hello'";

        Assert.assertTrue(errorMessage, containsLowerCase || containsUpperCase);
    }
}
