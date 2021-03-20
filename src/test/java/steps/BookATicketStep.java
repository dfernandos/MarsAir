package steps;

import pageObject.HomePageObject;
import domain.BookTicket;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Log;

import java.io.IOException;
import java.util.List;

public class BookATicketStep {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private Log log;

    public BookATicketStep(WebDriver driver) {
        try {
            this.driver = driver;
            this.homePageObject = new HomePageObject(driver);
            this.log = new Log("LogTest");
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void searchForFlightToMars(BookTicket bookTicket){
        log.logger.info("Pesquisa voo disponível para Marte");
        homePageObject.getDepartingElement().sendKeys(bookTicket.getDepartingDate());
        homePageObject.getReturningElement().sendKeys(bookTicket.getReturningDate());
        if(bookTicket.getPromotionalCode() != null){
            homePageObject.getPromotionalCodeElement().sendKeys(bookTicket.getPromotionalCode());
        }
        homePageObject.getButtonSearcElement().submit();
    }

    public void validateMessages(String positiveReturnMessage, String negativeReturnMessage){
        log.logger.info("Valida feedback na pesquisa de voo");
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
        log.logger.info("Valida feedback do promotional code");
        String promotionalCodeMessage = homePageObject.getPromotionalCodeMessage().getText();
        Assert.assertEquals(promotionalCodeMessage, message);
    }

    public void clickAtBackButton(){
        log.logger.info("Clica no botão back");
        homePageObject.getBackLinkElement().click();
    }

    public void clickAtLogoLink(){
        log.logger.info("Clica no link do logo");
        homePageObject.getLogoLink().click();
    }

    public void clickAtBookATicketLink(){
        log.logger.info("Clica na mensagem: Book a ticket for Mars");
        homePageObject.getBookATicketLink().click();
    }

}
