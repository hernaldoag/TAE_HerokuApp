package pom.payment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.address.Address;
import pom.address.SelectAddress;

public class PaymentOptions {
    private enum Using {
        ADD_NEW_CARD(By.id("mat-expansion-panel-header-0")),
        CARD_NAME(By.id("mat-input-3")),
        CARD_NUMBER(By.id("mat-input-4")),
        CARD_MONTH(By.id("mat-input-5")),
        CARD_YEAR(By.id("mat-input-6")),
        SUBMIT_CARD(By.id("//*[@id=\"submitButton\"]/span[1]")),
        DELIVERY(By.id("mat-radio-49-input")),
        CONTINUE_DELIVERY(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-delivery-method/mat-card/div[4]/button[2]/span[1]/mat-icon"));
        public final By selector;

        Using(By selector) {
            this.selector = selector;
        }
    }

    public WebDriver driver;

    public PaymentOptions(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        WebElement cardName = driver.findElement(Using.CARD_NAME.selector);
        cardName.clear();
        cardName.sendKeys(name);
    }

    public void enterCardNumber(String cardNo) {
        WebElement cardNumber = driver.findElement(Using.CARD_NUMBER.selector);
        cardNumber.clear();
        //String str1 = Long.toString(cardNo);
        cardNumber.sendKeys(cardNo);
    }

    public void enterMonth(int month) {
        WebElement cardMonth = driver.findElement(Using.CARD_MONTH.selector);
        cardMonth.clear();
        String str1 = Integer.toString(month);
        cardMonth.sendKeys(str1);
    }
    public void enterYear(int year) {
        WebElement cardYear = driver.findElement(Using.CARD_YEAR.selector);
        cardYear.clear();
        String str1 = Integer.toString(year);
        cardYear.sendKeys(str1);
    }

    public void addNewCard(WebDriver driver,String name, String cardNumber, int cardMonth, int cardYear){
        WebElement addNewCardOption = driver.findElement(Using.ADD_NEW_CARD.selector);
        addNewCardOption.click();
        enterName(name);
        enterCardNumber(cardNumber);
        enterMonth(cardMonth);
        enterYear(cardYear);
        WebElement submitCardB = driver.findElement(Using.SUBMIT_CARD.selector);
        submitCardB.click();
    }
}
