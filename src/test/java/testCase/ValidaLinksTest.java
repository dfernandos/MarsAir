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
import utils.BaseTest;

@RunWith(DataProviderRunner.class)
public class ValidaLinksTest extends BaseTest {

    @Test
    public void clickAtLogoLink() {
        BookATicketStep bookATicketStep = new BookATicketStep(driver);
        bookATicketStep.clickAtLogoLink();
    }

    @Test
    public void clickAtBookATicketLink() {
        BookATicketStep bookATicketStep = new BookATicketStep(driver);
        bookATicketStep.clickAtBookATicketLink();
    }

}