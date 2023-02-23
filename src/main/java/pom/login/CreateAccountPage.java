package pom.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateAccountPage {
    private enum Using {
        USER_EMAIL(By.id("emailControl")),
        USER_PWD(By.id("passwordControl")),

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

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserEmail(String name) {
        WebElement userEmail = driver.findElement(Using.USER_EMAIL.selector);
        userEmail.clear();
        userEmail.sendKeys(name);
    }

    public void enterUserPWD(String pwd) {
        WebElement userPwd = driver.findElement(Using.USER_PWD.selector);
        userPwd.clear();
        userPwd.sendKeys(pwd);
    }

    public void repeatUserPWD(String pwd) {
        WebElement repeatPwd = driver.findElement(Using.REPEAT_USER_PWD.selector);
        repeatPwd.clear();
        repeatPwd.sendKeys(pwd);
    }

    public void selectSecurityQuestion(int option) {
        WebElement selectQuestion = driver.findElement(Using.SECURITY_QUESTION.selector);
        selectQuestion.click();
        //Actions Builder = new Actions(driver);
        //Builder.moveToElement(driver.findElement(Using.SECURITY_QUESTION.selector)).click().build().perform();

        Select selection = new Select(selectQuestion);
        List<WebElement> options = selection.getOptions();
        selection.selectByIndex(options.indexOf(option));


    }
    public void selectSecurityQuestionList() {
        WebElement selectQuestion = driver.findElement(Using.SECURITY_QUESTION.selector);
        selectQuestion.click();
        WebElement questions = driver.findElement(Using.QUESTIONS_14.selector);
        //Actions Builder = new Actions(driver);
        //Builder.moveToElement(driver.findElement(Using.SECURITY_QUESTION.selector)).click().build().perform();
        questions.click();
        /**
        Select selection = new Select(questions);
        System.out.println(selection.getOptions());
        List<WebElement> options = selection.getOptions();
        for (int i =0; i< options.size(); i++){
            //String OptionName = options.get(i).getText();
            System.out.println("    Option Name: " +  options.get(option).getText());
        }
        */




    }

    public void enterSecurityAnswer(String answer) {
        WebElement repeatPwd = driver.findElement(Using.ANSWER.selector);
        repeatPwd.clear();
        repeatPwd.sendKeys(answer);
    }

    public void createNewUser(WebDriver driver, String userEmail, String pwd, String repPwd, int option, String answer){
        enterUserEmail(userEmail);
        enterUserPWD(pwd);
        repeatUserPWD(repPwd);
        selectSecurityQuestionList();
        enterSecurityAnswer(answer);
        WebElement register = driver.findElement(Using.REGISTER.selector);
        register.click();
    }
}
