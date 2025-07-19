package org.selcuk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoggedHomePage {
    @FindBy(how = How.XPATH, using = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    private WebElement username;

    @FindBy(how = How.XPATH, using = "//header/div/div/div/div[2]/div/ul/li[5]/a")
    private WebElement deleteAccountButton;

    @FindBy(how = How.XPATH, using = "//header/div/div/div/div[2]/div/ul/li[4]/a")
    private WebElement logoutButton;

    private WebDriver driver;

    public LoggedHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getUsername() {
        return username;
    }

    public AccountDeletedPage deleteAccountButtonClick() {
        deleteAccountButton.click();
        return new AccountDeletedPage(driver);
    }

    public LoginSignupPage logoutButtonClick() {
        logoutButton.click();
        return new LoginSignupPage(driver);
    }
}
