import org.junit.AfterClass;
import org.junit.Before;
import utilities.DriverManager;

public class BaseTest {
    @Before
    public void setup(){
        DriverManager.getDriver().driver.get("https://www.saucedemo.com");
        DriverManager.getDriver().driver.manage().window().maximize();
    }

    @AfterClass
    public static void cleanUP(){
        DriverManager.getDriver().driver.close();
    }
}
