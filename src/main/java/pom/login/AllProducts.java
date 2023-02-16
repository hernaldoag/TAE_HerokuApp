package pom.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class AllProducts {
    private enum Using {
        APPLE_JUICE_VIEW(By.cssSelector("body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-search-result > div > div > div.ng-star-inserted > mat-grid-list > div > mat-grid-tile:nth-child(1) > div > mat-card > div.mat-tooltip-trigger.product")),
        APPLE_JUICE_BASKET(By.id("passwordControl")),
        REVIEW_APPLEJUICE(By.cssSelector("#mat-dialog-1 > app-product-details > mat-dialog-content > div > div:nth-child(5) > mat-form-field > div > div.mat-form-field-flex.ng-tns-c118-18 > div.mat-form-field-infix.ng-tns-c118-18")),
        //REVIEW_APPLEJUICE(By.xpath("//*[@id=\"mat-dialog-2\"]/app-product-details/mat-dialog-content/div/div[2]/mat-form-field/div/div[1]/div[3]")),
        SUBMIT_APPLEJUICE(By.id("submitButton")),
        CLOSE_APPLE_JUICE_VIEW(By.cssSelector("#mat-dialog-1 > app-product-details > mat-dialog-content > div > div:nth-child(5) > mat-dialog-actions > button.mat-focus-indicator.close-dialog.buttons.mat-stroked-button.mat-button-base")),
        REPEAT_USER_PWD(By.id("repeatPasswordControl")),
        //SECURITY_QUESTION(By.name("mat-select-2-panel")),
        SECURITY_QUESTION(By.name("securityQuestion")),

        QUESTIONS_14(By.id("mat-option-14")),
        ANSWER(By.id("securityAnswerControl")),
        REGISTER(By.id("registerButton"));
        public final By selector;
        Using(By selector) {
            this.selector = selector;
        }
    }
    public WebDriver driver;

    public AllProducts(WebDriver driver) {
        this.driver = driver;
    }


    public void viewAppleJuice() throws Exception{
        //WebElement AppleJuice = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button/span[1]/span"));
        WebElement viewAppleJ = driver.findElement(Using.APPLE_JUICE_VIEW.selector);
        viewAppleJ.click();

    }
    public void closeView()throws Exception{
        WebElement closeView = driver.findElement(Using.CLOSE_APPLE_JUICE_VIEW.selector);
        Thread.sleep(2000);
        closeView.click();
    }

    public void AddReviewAppleJuice() throws Exception{
        //WebElement AppleJuice = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button/span[1]/span"));
        //WebElement viewAppleJ = driver.findElement(Using.APPLE_JUICE_VIEW.selector);
        //viewAppleJ.click();
        WebElement reviewJ = driver.findElement(Using.REVIEW_APPLEJUICE.selector);
        Actions action = new Actions(driver);
        action.moveToElement(reviewJ).click().build().perform();
        Thread.sleep(1000);
        action.moveToElement(reviewJ).sendKeys("This is a nice item");
        //action.sendKeys(reviewJ,"This is a nice item");
        //reviewJ.click();
        //reviewJ.sendKeys("This is a nice item");

        WebElement submitReview = driver.findElement(Using.SUBMIT_APPLEJUICE.selector);
        submitReview.click();
        //WebElement closeView = driver.findElement(Using.CLOSE_APPLE_JUICE_VIEW.selector);
        Thread.sleep(2000);

    }

}
