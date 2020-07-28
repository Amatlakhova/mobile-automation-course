package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.ScreenOrientation;
import java.time.Duration;

public class CoreTestCase extends TestCase {


    protected AppiumDriver driver;
    protected Platform Platform;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        this.Platform = new Platform();
        driver = this.Platform.getDriver();
        this.rotateScreenPortrait();
    }

    @Override
    protected void tearDown() throws Exception
    {
        if (driver.getOrientation() != ScreenOrientation.PORTRAIT) {
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
        driver.quit();

        super.tearDown();
    }

    protected void rotateScreenPortrait()
    {
        driver.rotate(ScreenOrientation.PORTRAIT);
    }

    protected void rotateScreenLandscape()
    {
        driver.rotate(ScreenOrientation.LANDSCAPE);
    }

    protected void backgroundAp(int seconds)
    {
        driver.runAppInBackground(Duration.ofSeconds(seconds));
    }

}
