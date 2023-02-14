package pom.address;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectAddress {
        private enum Using {
            SELECT(By.id("mat-radio-43")),
            CONTINUE(By.xpath("//*[@id=\"card\"]/app-address/mat-card/button/span[1]/span")),

            DELIVERY(By.id("mat-radio-49-input")),
            CONTINUE_DELIVERY(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-delivery-method/mat-card/div[4]/button[2]/span[1]/mat-icon"));
            public final By selector;
            Using(By selector) {
            this.selector = selector;
        }
        }
        public WebDriver driver;

        public SelectAddress(WebDriver driver) {
            this.driver = driver;
        }

        public void selectAndContinue(){
            WebElement selectAddress = driver.findElement(Using.SELECT.selector);
            selectAddress.click();
            WebElement continueButton = driver.findElement(Using.CONTINUE.selector);
            continueButton.click();
        }

        public void selectDelivery(){
            WebElement selectDelivery = driver.findElement(Using.DELIVERY.selector);
            selectDelivery.click();
            WebElement continueDelivery = driver.findElement(Using.CONTINUE_DELIVERY.selector);
            continueDelivery.click();
        }
}
