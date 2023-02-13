import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.constants.Credentials;
import pom.login.Login;

import java.time.Duration;

import static utilities.base.BaseURL.getBaseUrl;

public class InitialTests {

    WebDriver driver;
    JavascriptExecutor jse;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        jse = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterMethod
    public void tearDown() throws Exception {
        //driver.quit();

    }

    @Test
    public void AssertTitleNotMatching() throws Exception {
        getBaseUrl(driver);
        String expectedTitle = "Free QA Automation Tools For Everyone";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");


    }
    @Test
    public void AssertTitleMatching() throws Exception {
        getBaseUrl(driver);
        String expectedTitle = "OWASP Juice Shop";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");


    }


    @Test
    public void LoginAndCreateAccount() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        WebElement dismiss = driver.findElement(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted"));
        dismiss.click();

        WebElement account = driver.findElement(By.id("navbarAccount"));
        jse.executeScript("arguments[0].click()", account);
        //Actions action = new Actions(driver);
        //action.moveToElement(account).perform();
        //WebDriverWait(driver, 90).until(EC.element_to_be_clickable((By.id, "navbarAccount"))).click()
        WebElement LoginButton = driver.findElement(By.id("navbarLoginButton"));
        LoginButton.click();
        WebElement newCustomerLink = driver.findElement(By.id("newCustomerLink"));
        //jse.executeScript("arguments[0].click()", newCustomerLink);
        newCustomerLink.click();
        Thread.sleep(1000);

    }

    @Test
    public void LoginAndCreateAccount_Login() throws Exception {
        getBaseUrl(driver);
        WebElement dismiss = driver.findElement(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted"));
        //Alert alert = driver.switchTo().alert();
        dismiss.click();
        //alert.dismiss();
        WebElement account = driver.findElement(By.id("navbarAccount"));
        jse.executeScript("arguments[0].click()", account);
        Login testlogin = new Login(driver);
        testlogin.ClickLoginAndCreateAccount();
    }

    @Test
    public void LoginCorrect() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        WebElement dismiss = driver.findElement(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted"));
        dismiss.click();
        WebElement account = driver.findElement(By.id("navbarAccount"));
        jse.executeScript("arguments[0].click()", account);
        WebElement LoginButton = driver.findElement(By.id("navbarLoginButton"));
        LoginButton.click();
        WebElement customerEmail = driver.findElement(By.id("login-form"));
        Actions action = new Actions(driver);
        action.moveToElement(customerEmail).sendKeys(Credentials.DEFAULT_USER.getCustomer_email()).perform();
        //customerEmail.sendKeys(Credentials.DEFAULT_USER.getCustomer_email());
        WebElement customerPwd = driver.findElement(By.id("password"));
        customerPwd.sendKeys(Credentials.DEFAULT_USER.getCustomer_password());
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        System.out.println("Login successfull");

    }


    @Test
    public void LoginAndStartPurchase() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        WebElement dismiss = driver.findElement(By.cssSelector("#mat-dialog-0 > app-welcome-banner > div > div:nth-child(3) > button.mat-focus-indicator.close-dialog.mat-raised-button.mat-button-base.mat-primary.ng-star-inserted"));
        dismiss.click();
        WebElement account = driver.findElement(By.id("navbarAccount"));
        jse.executeScript("arguments[0].click()", account);
        WebElement LoginButton = driver.findElement(By.id("navbarLoginButton"));
        LoginButton.click();
        WebElement customerEmail = driver.findElement(By.id("login-form"));
        customerEmail.click();
        WebElement custom_email = driver.findElement(By.name("email"));
        custom_email.sendKeys(Credentials.DEFAULT_USER.getCustomer_email());
        //Actions action = new Actions(driver);
        //action.moveToElement(customerEmail).build().perform();
        //action.sendKeys(Credentials.DEFAULT_USER.getCustomer_email()).perform();
        //customerEmail.sendKeys(Credentials.DEFAULT_USER.getCustomer_email());
        WebElement customerPwd = driver.findElement(By.id("password"));
        customerPwd.sendKeys(Credentials.DEFAULT_USER.getCustomer_password());
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        System.out.println("Login successfull");
        Thread.sleep(1000);
        //ALl Products
        WebElement AppleJuice = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button/span[1]/span"));
        AppleJuice.click();

        WebElement basket = driver.findElement(By.xpath("//span[(@class='mat-button-wrapper')]//[text(),\"Your Basket\"]"));
        //span[(@class='mat-button-wrapper')]//[text(),"Your Basket"]
        basket.click();
        System.out.println("BAsket was openened");

        WebElement checkout = driver.findElement(By.id("checkoutButton"));
        checkout.click();
        WebElement addNewAddress = driver.findElement(By.linkText("/address/create"));




    }


}
