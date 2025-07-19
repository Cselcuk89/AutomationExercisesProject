package org.selcuk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
    @FindBy(how = How.CSS,using = "h2[data-qa='account-created']")
    private WebElement accountCreated;

    @FindBy(how = How.CSS,using = "a[data-qa='continue-button']")
    private WebElement continueButton;

    private WebDriver driver;

    public AccountCreatedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getAccountCreated() {
        return accountCreated;
    }

    public LoggedHomePage continueButtonClick() {
        continueButton.click();
        return new LoggedHomePage(driver);
    }
}
