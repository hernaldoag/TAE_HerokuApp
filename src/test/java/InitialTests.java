import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InitialTests {

    WebDriver driver;
    String baseURl = "https://juice-shop.herokuapp.com/";


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();

    }

    @Test
    public void AssertTitleNotMatching() throws Exception {
        driver.get(baseURl);
        String expectedTitle = "Free QA Automation Tools For Everyone";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");


    }
    @Test
    public void AssertTitleMatching() throws Exception {
        driver.get(baseURl);
        String expectedTitle = "OWASP Juice Shop";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, expectedTitle, "Titles of the website do not match");


    }
}
