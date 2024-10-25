package pom.address;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pom.login.AllProductsPage;

import java.util.List;

public class SelectAddress {
        private enum Using {
            SELECT_NEW(By.id("mat-radio-42")),
            SELECT_EXISTING(By.id("mat-radio-42")),
            SELECT_EXISTING_CARD(By.xpath("//*[@id='card']")),
            CONTINUE(By.xpath("//*[@id=\"card\"]/app-address/mat-card/button/span[1]/span")),

            DELIVERY(By.id("mat-radio-44")),
            CONTINUE_DELIVERY(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-delivery-method/mat-card/div[4]/button[2]/span[1]/mat-icon"));
            public final By selector;
            Using(By selector) {
            this.selector = selector;
        }
        }
        public WebDriver driver;
        private JavascriptExecutor jse;

        public SelectAddress(WebDriver driver) {
            this.driver = driver;
        }

        public void selectAndContinue(){
            WebElement selectAddress = driver.findElement(Using.SELECT_NEW.selector);
            selectAddress.click();
            WebElement continueButton = driver.findElement(Using.CONTINUE.selector);
            continueButton.click();
        }
        public void selectAndContinueExisting(){
             WebElement selectExistingAddress = driver.findElement(Using.SELECT_EXISTING.selector);
             selectExistingAddress.click();
             WebElement continueButton = driver.findElement(Using.CONTINUE.selector);
            continueButton.click();
        }

        public void selectDelivery(){
            WebElement selectDelivery = driver.findElement(Using.DELIVERY.selector);
            selectDelivery.click();
            WebElement continueDelivery = driver.findElement(Using.CONTINUE_DELIVERY.selector);
            continueDelivery.click();
        }
    public void selectExistingAddress() throws Exception{
        jse = (JavascriptExecutor)driver;
        Actions action = new Actions(driver);
        //List<WebElement> all = driver.findElements(Using.SELECT_EXISTING.selector);

        /***
        System.out.println(all.size());

        for(int i = 0; i < all.size(); i++){
            action.moveToElement(all.get(i)).build().perform();
            Thread.sleep(1000);
            action.click().build().perform();
            //all.get(i).click();

            //jse.executeScript("window.scrollBy(0,500)");
            Thread.sleep(2000);
            /*
            WebElement addReview = driver.findElement(Using.REVIEW_ALL.selector);
            addReview.click();
            addReview.sendKeys("This is a great item 02/22/2023");
            Thread.sleep(2000);
            WebElement close = driver.findElement(Using.CLOSE_VIEW.selector);
            WebElement submitReview = driver.findElement(Using.SUBMIT_APPLEJUICE.selector);
            submitReview.click();
            close.click();
            Thread.sleep(2000);
        } **/
    }
}
