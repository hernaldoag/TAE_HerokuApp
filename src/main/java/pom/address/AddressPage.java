package pom.address;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.base.Base;

public class AddressPage {

    private enum Using{
        ADD_NEW_ADRESS(By.cssSelector("button[aria-label='Add a new address']")),
        COUNTRY(By.id("mat-input-3")),
        NAME(By.id("mat-input-4")),
        MOBILE_NUMBER(By.id("mat-input-5")),
        ZIP_CODE(By.id("mat-input-6")),
        ADDRESS(By.id("address")),
        CITY(By.id("mat-input-8")),
        STATE(By.id("mat-input-9")),
        SUBMIT(By.id("submitButton"));
        public final By selector;

        Using(By selector){ this.selector = selector;}
    }

    public WebDriver driver;

    private Base base;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
    }

   // public void addNewAddress(WebDriver driver, String country, String name, int mobile, int zipCode, String address, String city, String state){}

    public void addNewAddress(){
        base = new Base(driver);
        base.click(Using.ADD_NEW_ADRESS.selector);
    }
    public void enterCountry(String country) {
        WebElement countryInput = driver.findElement(Using.COUNTRY.selector);
        countryInput.clear();
        countryInput.sendKeys(country);
    }
    public void enterName(String name) {
        WebElement nameInput = driver.findElement(Using.NAME.selector);
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterMobile(String mobile) {
        WebElement mobileInput = driver.findElement(Using.MOBILE_NUMBER.selector);
        mobileInput.clear();
        mobileInput.sendKeys(mobile);
    }

    public void enterZipCode(String zipCode) {
        WebElement zipCodeInput = driver.findElement(Using.ZIP_CODE.selector);
        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);
    }
    public void enterAddress(String zipCode) {
        WebElement addressInput = driver.findElement(Using.ADDRESS.selector);
        addressInput.clear();
        addressInput.sendKeys(zipCode);
    }
    public void enterCity(String city) {
        WebElement cityInput = driver.findElement(Using.CITY.selector);
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void enterState(String state) {
        WebElement stateInput = driver.findElement(Using.STATE.selector);
        stateInput.clear();
        stateInput.sendKeys(state);
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(Using.SUBMIT.selector);
        submit.click();
    }


    public void addNewAddress(WebDriver driver, String country, String name, String mobile, String zipCode, String address, String city, String state){
        enterCountry(country);
        enterName(name);
        enterMobile(mobile);
        enterZipCode(zipCode);
        enterAddress(address);
        enterCity(city);
        enterState(state);
        clickSubmit();

    }
}
