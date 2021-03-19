package steps;

import pageObject.HomePageObject;
import domain.BookTicket;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookATicketStep {

    private WebDriver driver;
    private HomePageObject homePageObject;

    public BookATicketStep(WebDriver driver) {
        this.driver = driver;
        this.homePageObject = new HomePageObject(driver);
    }

    public void searchForFlightToMars(BookTicket bookTicket){
        homePageObject.getDepartingElement().sendKeys(bookTicket.getDepartingDate());
        homePageObject.getReturningElement().sendKeys(bookTicket.getReturningDate());
        if(bookTicket.getPromotionalCode() != null){
            homePageObject.getPromotionalCodeElement().sendKeys(bookTicket.getPromotionalCode());
        }
        homePageObject.getButtonSearcElement().submit();
    }

    public void validateMessages(String positiveReturnMessage, String negativeReturnMessage){

        List<WebElement> elements = homePageObject.getMessages("p");
        String fullMessage = "";
        for(WebElement webElement: elements){
            String actualElement = webElement.getText();

            if(!actualElement.equals("Back")){
                fullMessage = fullMessage + actualElement;
            }
        }
        Assert.assertTrue(fullMessage.equals(positiveReturnMessage) || fullMessage.equals(negativeReturnMessage));
    }

    public void validatePromotionalCodeMessage(String message){
        String promotionalCodeMessage = homePageObject.getPromotionalCodeMessage().getText();
        Assert.assertEquals(promotionalCodeMessage, message);
    }

    public void clickAtBackButton(){
        homePageObject.getBackLinkElement().click();
    }

    public void clickAtLogoLink(){
        homePageObject.getLogoLink().click();
    }

    public void clickAtBookATicketLink(){
        homePageObject.getBookATicketLink().click();
    }

}
