package utilities.base;

import org.openqa.selenium.WebDriver;

public interface BaseURL {


    String TAE_URL = "https://juice-shop.herokuapp.com/#/";

    static void getBaseUrl(WebDriver driver) {
        driver.get(TAE_URL);
        driver.getCurrentUrl();
    }
}
