package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePageObject {

    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDepartingElement(){
        return driver.findElement(By.id("departing"));
    }

    public WebElement getReturningElement(){
        return driver.findElement(By.id("returning"));
    }

    public WebElement getPromotionalCodeElement(){
        return driver.findElement(By.id("promotional_code"));
    }

    public WebElement getButtonSearcElement(){
        return driver.findElement(By.xpath("//input[@type='submit']"));
    }

    public List<WebElement> getMessages(String elementName){
        return driver.findElements(By.tagName(elementName));
    }
    public WebElement getMessageSeatAvailable(){
        return driver.findElement(By.xpath("//p[text()='Seats available!']"));
    }

    public WebElement getMessageMoreInformation(){
        return driver.findElement(By.xpath("//p[text()='Call now on 0800 MARSAIR to book!']"));
    }

    public WebElement getBackLinkElement(){
        return driver.findElement(By.xpath("//a[text()=' Back']"));
    }

    public WebElement getNotValidDateMessage(){
        return driver.findElement(By.xpath("//p[text()='Unfortunately, this schedule is not possible. Please try again.']"));
    }







}
