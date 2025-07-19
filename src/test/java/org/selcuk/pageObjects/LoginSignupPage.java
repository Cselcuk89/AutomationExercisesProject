package org.selcuk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.selcuk.testCases.base.TestBase;
import org.selcuk.helpers.JsonReadHelper;

import java.io.IOException;
import java.text.ParseException;

public class LoginSignupPage extends TestBase {
    @FindBy(how = How.CSS, using = "div[class='login-form'] h2")
    private WebElement loginToYourAccount;

    @FindBy(how = How.CSS, using = "input[data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(how = How.CSS, using = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(how = How.CSS, using = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "/html/body/section/div/div/div[1]/div/form/p")
    private WebElement errorLogin;

    @FindBy(how = How.CSS, using = "div[class='signup-form'] h2")
    private WebElement newUserSignup;

    @FindBy(how = How.CSS, using = "input[data-qa='signup-name']")
    private WebElement signupNameInput;

    @FindBy(how = How.CSS, using = "input[data-qa='signup-email']")
    private WebElement signupEmailInput;

    @FindBy(how = How.CSS, using = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(how = How.XPATH, using = "//section/div/div/div[3]/div/form/p")
    private WebElement emailAddressAlreadyExist;

    private WebDriver driver;

    public LoginSignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getNewUserSignup() {
        return newUserSignup;
    }

    private void fillSignup(String name, String email) {
        signupNameInput.sendKeys(name);
        signupEmailInput.sendKeys(email);
        signupButton.click();
    }

    public EnterAccountInformationPage fillCorrectSignup(String name, String email) {
        fillSignup(name, email);
        return new EnterAccountInformationPage(driver);
    }

    public LoginSignupPage fillIncorrectSignup() throws IOException, ParseException, org.json.simple.parser.ParseException {
        fillSignup(JsonReadHelper.existingUser("name"), JsonReadHelper.existingUser("email"));
        return this;
    }

    public WebElement getLoginToYourAccount() {
        return loginToYourAccount;
    }

    private void fillLogin(String email, String password) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginButton.click();
    }

    public LoggedHomePage fillCorrectLogin(String email, String password) {
        fillLogin(email, password);
        return new LoggedHomePage(driver);
    }

    public LoginSignupPage fillIncorrectLogin(String email, String password) {
        fillLogin(email, password);
        return this;
    }

    public WebElement getErrorLogin() {
        return errorLogin;
    }

    public WebElement getEmailAddressAlreadyExist() {
        return emailAddressAlreadyExist;
    }
}
