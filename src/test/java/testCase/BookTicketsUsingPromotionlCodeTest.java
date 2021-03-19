package testCase;

import PageObject.HomePageObject;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import domain.BookTicket;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BookATicketStep;

@RunWith(DataProviderRunner.class)
public class BookTicketsUsingPromotionlCodeTestCase {

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
                {"July","December (two years from now)","AF2-FJK-417","Promotional code AF2-FJK-417 used: 20% discount!"},
                {"July","December (two years from now)","YG7-OLI-119","Promotional code YG7-OLI-119 used: 70% discount!"},
                {"July","December (two years from now)","CO6-MBI-118","Promotional code CO6-MBI-118 used: 60% discount!"}
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
    public void bookATicketToMarsaUsingPromotionalCode(String departing, String returning, String promotionalCode, String promotionalCodeMessage){
        BookATicketStep bookATicketStep = new BookATicketStep(driver);
        BookTicket bookTicket = new BookTicket(departing, returning, promotionalCode);
        bookATicketStep.searchForFlightToMars(bookTicket);
        bookATicketStep.validatePromotionalCodeMessage(promotionalCodeMessage);
        bookATicketStep.clickAtBackButton();
    }

}
