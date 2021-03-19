package testCase;

import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BookATicketStep;

@RunWith(DataProviderRunner.class)
public class ValidaLinksTest {

    static WebDriver driver;

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

    @Test
    public void clickAtLogoLink(){
        BookATicketStep bookATicketStep = new BookATicketStep(driver);
        bookATicketStep.clickAtLogoLink();
    }

    @Test
    public void clickAtBookATicketLink(){
        BookATicketStep bookATicketStep = new BookATicketStep(driver);
        bookATicketStep.clickAtBookATicketLink();
    }

}
