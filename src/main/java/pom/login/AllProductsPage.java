package pom.login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.base.Base;

import java.util.List;

public class AllProductsPage {

    Base base;
    private enum Using {
        COOKIE(By.xpath("//*[@class='cc-compliance']//a[contains (text(),'Me want it!')]")),
        APPLE_JUICE_VIEW(By.cssSelector("body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-search-result > div > div > div.ng-star-inserted > mat-grid-list > div > mat-grid-tile:nth-child(1) > div > mat-card > div.mat-tooltip-trigger.product")),

        APPLE_POMACE_ADD_TO_BASKET(By.cssSelector("body > app-root > div > mat-sidenav-container > mat-sidenav-content > app-search-result > div > div > div.ng-star-inserted > mat-grid-list > div > mat-grid-tile:nth-child(2) > div > mat-card > div:nth-child(2) > button > span.mat-button-wrapper > span")),
        BANANA_JUICE_ADD_TO_BASKET(By.cssSelector("")),
        CARROT_JUICE_ADD_TO_BASKET(By.cssSelector("")),
        ADD_TO_BASKET(By.cssSelector("button[aria-label='Add to Basket']")),
        EGGFRUIT_JUICE_VIEW(By.cssSelector("//img[@src='assets/public/images/products/eggfruit_juice.jpg']")),
        REVIEW_APPLEJUICE(By.cssSelector("#mat-dialog-1 > app-product-details > mat-dialog-content > div > div:nth-child(5) > mat-form-field > div > div.mat-form-field-flex.ng-tns-c118-18 > div.mat-form-field-infix.ng-tns-c118-18")),
        //REVIEW_APPLEJUICE(By.xpath("//*[@id=\"mat-dialog-2\"]/app-product-details/mat-dialog-content/div/div[2]/mat-form-field/div/div[1]/div[3]")),
        REVIEW_ALL(By.cssSelector("textarea[placeholder='What did you like or dislike?']")),
        SUBMIT_APPLEJUICE(By.id("submitButton")),
        CLOSE_APPLE_JUICE_VIEW(By.cssSelector("#mat-dialog-1 > app-product-details > mat-dialog-content > div > div:nth-child(5) > mat-dialog-actions > button.mat-focus-indicator.close-dialog.buttons.mat-stroked-button.mat-button-base")),
        CLOSE_VIEW(By.xpath("//*[(@type='button' and @class='mat-focus-indicator close-dialog buttons mat-stroked-button mat-button-base')]"));
        public final By selector;
        Using(By selector) {
            this.selector = selector;
        }
    }
    public WebDriver driver;
    public JavascriptExecutor jse;

    public AllProductsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void viewAppleJuice() throws Exception{
        //WebElement AppleJuice = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button/span[1]/span"));
        WebElement viewAppleJ = driver.findElement(Using.APPLE_JUICE_VIEW.selector);
        viewAppleJ.click();

    }

    public void viewItemEggFruit() throws Exception{
        base = new Base(driver);
        base.click(Using.EGGFRUIT_JUICE_VIEW.selector);

    }


    public void closeView()throws Exception{
        WebElement closeView = driver.findElement(Using.CLOSE_APPLE_JUICE_VIEW.selector);
        Thread.sleep(2000);
        closeView.click();
    }
    public void addApplePomace(){
        Base base = new Base(driver);
        base.findElement(Using.APPLE_POMACE_ADD_TO_BASKET.selector);
        base.click(Using.APPLE_POMACE_ADD_TO_BASKET.selector);
    }

    public void AddReviewAppleJuice() throws Exception{
        WebElement reviewJ = driver.findElement(Using.REVIEW_APPLEJUICE.selector);
        Actions action = new Actions(driver);
        action.moveToElement(reviewJ).click().build().perform();
        Thread.sleep(1000);
        action.sendKeys("This is a nice item").build().perform();
        WebElement submitReview = driver.findElement(Using.SUBMIT_APPLEJUICE.selector);
        submitReview.click();
        Thread.sleep(2000);

    }

    public void AddReview(By item,By button) throws Exception{
        WebElement reviewJ = driver.findElement(item);
        Actions action = new Actions(driver);
        action.moveToElement(reviewJ).click().build().perform();
        Thread.sleep(1000);
        action.sendKeys("This is a nice item").build().perform();
        WebElement submitReview = driver.findElement(button);
        submitReview.click();
        Thread.sleep(2000);

    }

    public void allElements() throws Exception{
       // WebElement cards = driver.findElement(By.xpath("/mat-card"));

        List<WebElement> all = driver.findElements(By.cssSelector("mat-grid-tile"));
        System.out.println(all.size());

        for(int i = 0; i < all.size(); i++){

                all.get(i).click();
                Thread.sleep(2000);
                WebElement close = driver.findElement(Using.CLOSE_VIEW.selector);
                close.click();
                Thread.sleep(2000);
        }
    }


    public void addReviewALL() throws Exception{

        List<WebElement> all = driver.findElements(By.cssSelector("mat-grid-tile"));
        System.out.println(all.size());

        for(int i = 0; i < all.size(); i++){

            all.get(i).click();
            WebElement addReview = driver.findElement(Using.REVIEW_ALL.selector);
            addReview.click();
            addReview.sendKeys("This is a great item 02/22/2023");
            Thread.sleep(2000);
            WebElement close = driver.findElement(Using.CLOSE_VIEW.selector);
            WebElement submitReview = driver.findElement(Using.SUBMIT_APPLEJUICE.selector);
            submitReview.click();
            close.click();
            Thread.sleep(2000);
        }
    }

    public void addAllToBasket() throws Exception{
        jse = (JavascriptExecutor)driver;

        List<WebElement> all = driver.findElements(Using.ADD_TO_BASKET.selector);
        System.out.println(all.size());

        for(int i = 0; i < all.size(); i++){

            all.get(i).click();
            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,500)");
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
            Thread.sleep(2000);*/
        }
    }

    public void addAllToBasketAction() throws Exception{
        jse = (JavascriptExecutor)driver;
        Actions action = new Actions(driver);
        List<WebElement> all = driver.findElements(Using.ADD_TO_BASKET.selector);
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
            Thread.sleep(2000);*/
        }
    }

}
