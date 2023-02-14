package pom.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Login {

    private enum Using {
        LOGIN(By.id("navbarLoginButton")),
        NEW_CUSTOMER_LINK(By.id("newCustomerLink")),

        CUSTOMER_EMAIL(By.id("login-form")),

        CUSTOMER_PASSWORD(By.id("password")),

        USER_EMAIL(By.id("email")),
        LOGIN_BUTTON(By.id("loginButton"));
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

    public void ClickLoginAndCreateAccountActions() throws Exception{
        clickLoginLink();
        Actions Builder = new Actions(driver);
        Builder.moveToElement(driver.findElement(Using.NEW_CUSTOMER_LINK.selector)).click().build().perform();
        CreateAccount createNewAccount = new CreateAccount(driver);
        Thread.sleep(1000);
        createNewAccount.createNewUser(driver,"at_juice003@auto.io","AT_2023_at","AT_2023_at",12, "60 seconds" );
    }
    public void ClickLoginAndCreateAccount() throws Exception{
        clickLoginLink();
        WebElement notUser = driver.findElement(Using.NEW_CUSTOMER_LINK.selector);
        notUser.click();
        //Builder.moveToElement(driver.findElement(Using.NEW_CUSTOMER_LINK.selector)).click().build().perform();
        CreateAccount createNewAccount = new CreateAccount(driver);
        Thread.sleep(1000);
        createNewAccount.createNewUser(driver,"at_juice007@auto.io","AT_2023_at","AT_2023_at",12, "60 seconds" );
    }

    public void LoginCorrect(){
       clickLoginLink();
       Actions builder = new Actions(driver);
       builder.moveToElement(driver.findElement(Using.CUSTOMER_EMAIL.selector)).sendKeys();
    }
    public void enterUserEmail(String email) {
        WebElement emailUser = driver.findElement(Using.USER_EMAIL.selector);
        emailUser.click();
        emailUser.clear();
        emailUser.sendKeys(email);
    }
    public void enterUserPWD(String pwd) {
        WebElement passwordUser = driver.findElement(Using.CUSTOMER_PASSWORD.selector);
        passwordUser.clear();
        passwordUser.sendKeys(pwd);
    }
    public void simpleLogin(){
        enterUserEmail("at_juice007@auto.io");
        enterUserPWD("AT_2023_at");
        WebElement LoginButton = driver.findElement(Using.LOGIN_BUTTON.selector);
        LoginButton.click();
    }

    public void enterCustomerEmail(String email) {
        WebElement emailCustomer = driver.findElement(Using.CUSTOMER_EMAIL.selector);
        emailCustomer.click();
        emailCustomer.clear();
        emailCustomer.sendKeys(email);
    }

    public void simpleLogin_ExistingUser(){
        enterUserEmail("at_juice007@auto.io");
        enterUserPWD("AT_2023_at");
        WebElement LoginButton = driver.findElement(Using.LOGIN_BUTTON.selector);
        LoginButton.click();
    }
}
