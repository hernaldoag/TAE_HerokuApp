package pom.basket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.base.Base;

public class BasketPage {

    private Base base;
    private enum Using {
        CHECKOUT(By.id("checkoutButton")),

        ADD_ITEM(By.id("loginButton")),
        REDUCE_ITEM(By.id("loginButton")),
        REMOVE_ITEM(By.id("loginButton"));
        public final By selector;

        Using(By selector){ this.selector = selector;}


    }
    public WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void startCheckout() throws Exception{
        base = new Base(driver);
        base.click(Using.CHECKOUT.selector);
        Thread.sleep(1000);
    }


}
