package testCase;

import pageObject.HomePageObject;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import domain.BookTicket;
import org.junit.*;
import org.junit.runner.RunWith;
import steps.BookATicketStep;
import utils.BaseTest;

@RunWith(DataProviderRunner.class)
public class BookTicketsUsingPromotionlCodeTest extends BaseTest {

    @DataProvider
    public static Object[][] customerDataInfo() {
        return new Object[][]{
                {"July","December (two years from now)","AF2-FJK-417","Promotional code AF2-FJK-417 used: 20% discount!"},
                {"July","December (two years from now)","YG7-OLI-115","Sorry, code YG7-OLI-115 is not valid"},
                {"July","December (two years from now)","CO6-MBI-118","Promotional code CO6-MBI-118 used: 60% discount!"},
                {"Select...", "Selecting...", "CO6-MBI-118", "Unfortunately, this schedule is not possible. Please try again."},
                {"Select...", "Selecting...", "", "Unfortunately, this schedule is not possible. Please try again."},

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
