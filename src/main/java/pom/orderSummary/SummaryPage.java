package pom.orderSummary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SummaryPage {

    private enum Using {
        CHECKOUT_BUTTON(By.id("checkoutButton")),
        PURSCHASE_MESSAGE(By.cssSelector("body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-order-completion > mat-card > div:nth-child(1) > div > mat-card:nth-child(1) > div > h1"));
        public final By selector;

        Using(By selector) {
            this.selector = selector;
        }
    }

    public WebDriver driver;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkoutOrder(){
        WebElement checkoutButton = driver.findElement(Using.CHECKOUT_BUTTON.selector);
        checkoutButton.click();

    }
}
