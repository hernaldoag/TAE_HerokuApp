package pom.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {

    private enum Using {
        LOGIN(By.id("navbarLoginButton")),
        NEW_CUSTOMER_LINK(By.id("newCustomerLink"));

        public final By selector;

        Using(By selector){ this.selector = selector;}


    }
    public WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(Using.LOGIN.selector)).click().build().perform();

    }

    public void ClickLoginAndCreateAccount(){
        clickLoginLink();
        Actions Builder = new Actions(driver);
        Builder.moveToElement(driver.findElement(Using.NEW_CUSTOMER_LINK.selector)).build().perform();
    }
}
