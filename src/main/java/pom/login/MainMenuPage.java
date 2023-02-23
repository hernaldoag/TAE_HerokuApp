package pom.login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.base.Base;

public class MainMenuPage {

    private Base base;

    private enum Using{
        DISMISS(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted")),
        ACCOUNT(By.id("navbarAccount")),
        LOGIN_BUTTON(By.id("navbarLoginButton")),
        BASKET(By.xpath("//*[contains(text(), 'Your Basket')]"));
        public final By selector;

        Using(By selector){ this.selector = selector;}
    }

    public WebDriver driver;
    JavascriptExecutor jse;
    public MainMenuPage(WebDriver driver, JavascriptExecutor jse) {
        this.driver = driver;
        this.jse = jse;
    }

    public void startLogin() throws Exception{
        WebElement dismiss = driver.findElement(Using.DISMISS.selector);
        dismiss.click();
        WebElement account = driver.findElement(Using.ACCOUNT.selector);
        jse.executeScript("arguments[0].click()", account);
        Thread.sleep(1000);
        WebElement LoginButton = driver.findElement(Using.LOGIN_BUTTON.selector);
        LoginButton.click();
    }

    public void openBasket(){
        base = new Base(driver);

        base.click(Using.BASKET.selector);
    }

}
