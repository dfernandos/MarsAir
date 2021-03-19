package utils;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

    public static WebDriver driver;

    @BeforeClass
    public static void beforeClass() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();
    }

    @Before
    public void setup() {
        driver.get("https://marsair.thoughtworks-labs.net/DanielSilva");
        new WebDriverWait(driver, 15);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Mars Airlines: Home");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
