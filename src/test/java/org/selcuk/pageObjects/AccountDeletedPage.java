package org.selcuk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountDeletedPage {
    @FindBy(how = How.CSS, using = "h2[data-qa='account-deleted']")
    private WebElement accountDeleted;

    @FindBy(how = How.CSS, using = "a[data-qa='continue-button']")
    private WebElement continueButton;

    private WebDriver driver;

    public AccountDeletedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getAccountDeleted() {
        return accountDeleted;
    }

    public HomePage continueButtonClick() {
        continueButton.click();
        return new HomePage(driver);
    }
}
