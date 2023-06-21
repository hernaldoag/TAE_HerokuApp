import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.address.AddressPage;
import pom.address.SelectAddress;
import pom.basket.BasketPage;
import pom.constants.Credentials;
import pom.login.AllProductsPage;
import pom.login.LoginPage;
import pom.login.MainMenuPage;
import pom.orderSummary.SummaryPage;
import pom.payment.PaymentOptionsPage;
import utilities.useful.RandomStrings;

import java.io.File;
import java.time.Duration;

import static utilities.base.BaseURL.getBaseUrl;

public class InitialTests {

    WebDriver driver;
    JavascriptExecutor jse;
    MainMenuPage mainPage;
    AllProductsPage allProductsPage;

    BasketPage basketPage;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();


        driver = new ChromeDriver();
        options.addArguments("--remote-allow-origins=*");
        jse = (JavascriptExecutor)driver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        RandomStrings ssName= new RandomStrings();
        String filename = ssName.getRandomString(10) + ".png";
        String directory = System.getProperty("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + filename));
        //driver.quit();

    }

    @Test
    public void AssertTitleNotMatching(){
        getBaseUrl(driver);
        String expectedTitle = "Free QA Automation Tools For Everyone";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");


    }
    @Test
    public void AssertTitleMatching()  {
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
        WebElement LoginButton = driver.findElement(By.id("navbarLoginButton"));
        LoginButton.click();
        WebElement newCustomerLink = driver.findElement(By.id("newCustomerLink"));
        newCustomerLink.click();
        Thread.sleep(1000);

    }


    @Test
    public void createAccountAndLoginRefactor() throws Exception {
        getBaseUrl(driver);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();
        LoginPage testLogin = new LoginPage(driver);
        testLogin.ClickLoginAndCreateAccount();
        testLogin.simpleLogin();
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

        WebElement customerPwd = driver.findElement(By.id("password"));
        customerPwd.sendKeys(Credentials.DEFAULT_USER.getCustomer_password());
        WebElement loginButton = driver.findElement(By.id("loginButton"));
        loginButton.click();
        System.out.println("Login successfull");
        Thread.sleep(1000);
        //ALl Products
        WebElement AppleJuice = driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[1]/div/mat-card/div[2]/button/span[1]/span"));
        AppleJuice.click();
        Thread.sleep(1000);
        WebElement basket = driver.findElement(By.xpath("//*[contains(text(), 'Your Basket')]"));
        //span[(@class='mat-button-wrapper')]//[text(),"Your Basket"]
        basket.click();
        Thread.sleep(1000);
        System.out.println("Basket was openened");

        WebElement checkout = driver.findElement(By.id("checkoutButton"));
        checkout.click();
        Thread.sleep(1000);
        /**
        WebElement addNewAddress = driver.findElement(By.xpath("//*[@id=\"card\"]/app-address/mat-card/div/button/span[1]/span"));
        addNewAddress.click();
        Address address = new Address(driver);
        address.addNewAddress(driver, "Mexico","Testy", "4141046137","90210","403 Forbiden Av", "Tequis", "El Marques");
        Thread.sleep(1000);
         **/
        SelectAddress selectAddress = new SelectAddress(driver);
        selectAddress.selectAndContinue();
        selectAddress.selectDelivery();

        PaymentOptionsPage payment = new PaymentOptionsPage(driver);
        //payment.addNewCard(driver, "Tris Alvarez", "4700000100020003");
        payment.selectCardAndContinue();
        SummaryPage orderSummaryPage = new SummaryPage(driver);
        orderSummaryPage.checkoutOrder();

    }

    @Test
    public void LoginNewAndStartPurchase() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();

        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin();

        Thread.sleep(2000);
        //ALl Products
        AllProductsPage allProductsPage1 = new AllProductsPage(driver);
        allProductsPage1.addApplePomace();

        Thread.sleep(1000);
        mainPage.openBasket();

        Thread.sleep(1000);
        basketPage = new BasketPage(driver);
        basketPage.startCheckout();
        Thread.sleep(1000);


        AddressPage address = new AddressPage(driver);
        address.addNewAddress();
        address.addNewAddress(driver, "Mexico","Testy", "4141046137","90210","403 Forbiden Av", "Tequis", "El Marques");

        SelectAddress selectAddress = new SelectAddress(driver);
        selectAddress.selectAndContinue();
        selectAddress.selectDelivery();

        PaymentOptionsPage payment = new PaymentOptionsPage(driver);
        payment.addNewCard(driver, "Tris Alvarez", "4700000100020003");
        payment.selectCardAndContinue();
        SummaryPage orderSummaryPage = new SummaryPage(driver);
        orderSummaryPage.checkoutOrder();
    }
    //Existing User
    @Test
    public void LoginExistingAndStartPurchase() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();

        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin();

        Thread.sleep(2000);
        //ALl Products
        AllProductsPage allProductsPage1 = new AllProductsPage(driver);
        allProductsPage1.addApplePomace();

        Thread.sleep(1000);
        mainPage.openBasket();

        Thread.sleep(1000);
        basketPage = new BasketPage(driver);
        basketPage.startCheckout();
        Thread.sleep(1000);


        AddressPage address = new AddressPage(driver);
        address.addNewAddress();
        address.addNewAddress(driver, "Mexico","Testy", "4141046137","90210","403 Forbiden Av", "Tequis", "El Marques");

        SelectAddress selectAddress = new SelectAddress(driver);
        selectAddress.selectAndContinue();
        selectAddress.selectDelivery();

        PaymentOptionsPage payment = new PaymentOptionsPage(driver);
        //payment.addNewCard(driver, "Tris Alvarez", "4700000100020003");
        payment.selectCardAndContinue();
        SummaryPage orderSummaryPage = new SummaryPage(driver);
        orderSummaryPage.checkoutOrder();
    }

    @Test
    public void LoginExistingAndStartPurchaseMultipleItems() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();

        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin_ExistingUser();

        Thread.sleep(2000);
        //ALl Products
        AllProductsPage allProductsPage1 = new AllProductsPage(driver);
        allProductsPage1.addApplePomace();

        Thread.sleep(1000);
        mainPage.openBasket();

        Thread.sleep(1000);
        basketPage = new BasketPage(driver);
        basketPage.startCheckout();
        Thread.sleep(1000);

        //AddressPage address = new AddressPage(driver);
        //address.addNewAddress();
        //address.addNewAddress(driver, "Mexico","Testy", "4141046137","90210","403 Forbiden Av", "Tequis", "El Marques");

        SelectAddress selectAddress = new SelectAddress(driver);
        selectAddress.selectAndContinue();
        selectAddress.selectDelivery();

        PaymentOptionsPage payment = new PaymentOptionsPage(driver);
        payment.addNewCard(driver, "Tris Alvarez", "4700000100020003");
        payment.selectCardAndContinue();
        SummaryPage orderSummaryPage = new SummaryPage(driver);
        orderSummaryPage.checkoutOrder();
    }


    @Test
    public void PurchaseMultipleItems() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();

        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin();

        Thread.sleep(2000);
        //ALl Products
        AllProductsPage allProductsPage1 = new AllProductsPage(driver);
        allProductsPage1.addAllToBasketAction();
        Thread.sleep(1000);

        mainPage.openBasket();

        Thread.sleep(2000);
        basketPage = new BasketPage(driver);
        basketPage.startCheckout();
        Thread.sleep(1000);

        //AddressPage address = new AddressPage(driver);
        //address.addNewAddress();
        //address.addNewAddress(driver, "Mexico","Testy", "4141046137","90210","403 Forbiden Av", "Tequis", "El Marques");

        SelectAddress selectAddress = new SelectAddress(driver);
        selectAddress.selectAndContinue();
        selectAddress.selectDelivery();

        PaymentOptionsPage payment = new PaymentOptionsPage(driver);
        //payment.addNewCard(driver, "Tris Alvarez", "4700000100020003");
        payment.selectCardAndContinue();
        SummaryPage orderSummaryPage = new SummaryPage(driver);
        orderSummaryPage.checkoutOrder();
    }

    @Test
    public void AddReview() throws Exception {
        getBaseUrl(driver);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();
        Thread.sleep(1000);
        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin_ExistingUser();
        Thread.sleep(1000);
        AllProductsPage landing = new AllProductsPage(driver);
        landing.viewAppleJuice();
        Thread.sleep(1000);
        landing.AddReviewAppleJuice();
        landing.closeView();

    }

    @Test
    public void LoginOpenViewAndClose() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();
        Thread.sleep(1000);
        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin_ExistingUser();
        Thread.sleep(1000);
        AllProductsPage landing = new AllProductsPage(driver);
        landing.viewAppleJuice();
        landing.closeView();
        Thread.sleep(1000);
    }

    @Test
    public void LoginOpenViewEgg() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();
        Thread.sleep(1000);
        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin_ExistingUser();
        Thread.sleep(1000);
        AllProductsPage landing = new AllProductsPage(driver);
        landing.viewItemEggFruit();
        //landing.viewAppleJuice();
        //landing.closeView();
        Thread.sleep(1000);
    }

    @Test
    public void testAllProductPage() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();

        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin_ExistingUser();

        System.out.println("Login successful");
        Thread.sleep(2000);
        //ALl Products
        allProductsPage = new AllProductsPage(driver);
        allProductsPage.addApplePomace();
    }


    @Test
    public void testAllProductPageText() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();
        Thread.sleep(1000);
        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin_ExistingUser();
        Thread.sleep(1000);
        AllProductsPage landing = new AllProductsPage(driver);
        landing.allElements();
        //landing.viewAppleJuice();
        //landing.closeView();
        Thread.sleep(1000);
    }

    @Test
    public void testAddReviewAllProductPage() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();
        Thread.sleep(1000);
        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin_ExistingUser();
        Thread.sleep(1000);
        AllProductsPage landing = new AllProductsPage(driver);
        landing.addReviewALL();
        Thread.sleep(1000);
    }

    @Test
    public void AddAllToBasket() throws Exception {
        getBaseUrl(driver);
        Thread.sleep(1000);
        mainPage = new MainMenuPage(driver, jse);
        mainPage.startLogin();
        Thread.sleep(1000);
        LoginPage existingUser = new LoginPage(driver);
        existingUser.simpleLogin_ExistingUser();
        Thread.sleep(1000);
        AllProductsPage landing = new AllProductsPage(driver);
        landing.addAllToBasketAction();
        Thread.sleep(1000);
    }
}
