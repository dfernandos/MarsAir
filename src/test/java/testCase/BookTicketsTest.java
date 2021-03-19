package testCase;

import PageObject.HomePageObject;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;
import steps.BookATicketStep;
import domain.BookTicket;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(DataProviderRunner.class)
public class BookTicketsTestCase {

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

    @DataProvider
    public static Object[][] customerDataInfo() {
        return new Object[][]{
                {"December", "December (two years from now)", "Sorry, there are no more seats available."},
                {"July", "December (two years from now)", "Sorry, there are no more seats available.", "Seats available!Call now on 0800 MARSAIR to book!" },
                {"December", "December (next year)", "Sorry, there are no more seats available.", "Seats available!Call now on 0800 MARSAIR to book!"},
                {"July (next year)", "December", "Unfortunately, this schedule is not possible. Please try again.", "Unfortunately, this schedule is not possible. Please try again."},
                {"July", "December", "Unfortunately, this schedule is not possible. Please try again.", "Unfortunately, this schedule is not possible. Please try again."},
            };
        }

    @Test
    public void validateFieldsAreDisplayed(){
        HomePageObject homePageObject = new HomePageObject(driver);
        homePageObject.getReturningElement().isDisplayed();
        homePageObject.getDepartingElement().isDisplayed();

    }

    @Test
    @UseDataProvider("customerDataInfo")
    public void bookATicketToMars(String departing, String returning, String positiveFeedbackMessage, String negativeFeedbackMessage){
        BookATicketStep bookATicketStep = new BookATicketStep(driver);
        BookTicket bookTicket = new BookTicket(departing, returning);
        bookATicketStep.searchForFlightToMars(bookTicket);
        bookATicketStep.validateMessages(positiveFeedbackMessage, negativeFeedbackMessage);
        bookATicketStep.clickAtBackButton();
    }

}
