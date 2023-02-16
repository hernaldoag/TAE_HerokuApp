package pom.payment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pom.address.Address;
import pom.address.SelectAddress;
import pom.login.CreateAccount;

import java.util.List;

public class PaymentOptions {
    private enum Using {
        ADD_NEW_CARD(By.id("mat-expansion-panel-header-0")),
        CARD_NAME(By.id("mat-input-3")),
        CARD_NUMBER(By.id("mat-input-4")),
        CARD_MONTH(By.id("mat-input-5")),
        CARD_YEAR(By.id("mat-input-6")),
        SUBMIT_CARD(By.id("submitButton")),
        SELECT_CARD(By.id("mat-radio-50")),
        CONTINUE_BUTTON(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-payment/mat-card/div/div[2]/button[2]/span[1]/mat-icon"));

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

    public void enterMonth() {
        /**
        WebElement cardMonth = driver.findElement(Using.CARD_MONTH.selector);
        cardMonth.click();
        String str1 = Integer.toString(month);
        cardMonth.sendKeys(str1);
        */
        WebElement cardMonth = driver.findElement(Using.CARD_MONTH.selector);
        Select selection = new Select(cardMonth);
        selection.selectByIndex(5);

    }
    public void enterYear() {
        //WebElement cardYear = driver.findElement(Using.CARD_YEAR.selector);
        //cardYear.clear();
        //String str1 = Integer.toString(year);
        //cardYear.sendKeys(str1);
        WebElement cardYear = driver.findElement(Using.CARD_YEAR.selector);
        Select selection = new Select(cardYear);
        selection.selectByIndex(5);
    }

    public void addNewCard_1(WebDriver driver,String name, String cardNumber, int cardMonth, int cardYear){
        WebElement addNewCardOption = driver.findElement(Using.ADD_NEW_CARD.selector);
        addNewCardOption.click();
        enterName(name);
        enterCardNumber(cardNumber);
        //enterMonth(cardMonth);
        //enterYear(cardYear);
        WebElement submitCardB = driver.findElement(Using.SUBMIT_CARD.selector);
        submitCardB.click();
    }

    public void addNewCard(WebDriver driver,String name, String cardNumber){
        WebElement addNewCardOption = driver.findElement(Using.ADD_NEW_CARD.selector);
        addNewCardOption.click();
        enterName(name);
        enterCardNumber(cardNumber);
        enterMonth();
        enterYear();
        WebElement submitCardB = driver.findElement(Using.SUBMIT_CARD.selector);
        submitCardB.click();
    }

     public void selectCardAndContinue(){

        WebElement selectCard = driver.findElement(Using.SELECT_CARD.selector);
        selectCard.click();

        WebElement cardContinueButton = driver.findElement(Using.CONTINUE_BUTTON.selector);
        cardContinueButton.click();

     }
}
