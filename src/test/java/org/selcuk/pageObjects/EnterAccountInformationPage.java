package org.selcuk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.selcuk.base.TestBase;
import org.selcuk.helpers.DateTimeHelper;
import org.selcuk.helpers.JsonReadHelper;

import java.io.IOException;
import java.text.ParseException;

public class EnterAccountInformationPage extends TestBase {
    @FindBy(xpath = "//b[contains(.,'Enter Account Information')]")
    private WebElement enterAccountInformation;

    @FindBy(id = "id_gender1")
    private WebElement titleMrCheckbox;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysSelect;

    @FindBy(id = "months")
    private WebElement monthsSelect;

    @FindBy(id = "years")
    private WebElement yearsSelect;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    private WebDriver driver;

    public EnterAccountInformationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getEnterAccountInformation() {
        return enterAccountInformation;
    }

    public AccountCreatedPage fillAccountDetails() throws IOException, ParseException, org.json.simple.parser.ParseException {
        String password = "pass" + DateTimeHelper.generateCurrentDateAndTime();
        titleMrCheckbox.click();
        passwordInput.sendKeys(password);
        Select days = new Select(daysSelect);
        days.selectByValue(JsonReadHelper.accountDetails("day"));
        Select months = new Select(monthsSelect);
        months.selectByValue(JsonReadHelper.accountDetails("month"));
        Select years = new Select(yearsSelect);
        years.selectByValue(JsonReadHelper.accountDetails("year"));
        newsletterCheckbox.click();
        specialOffersCheckbox.click();
        firstNameInput.sendKeys(JsonReadHelper.accountDetails("firstName"));
        lastNameInput.sendKeys(JsonReadHelper.accountDetails("lastName"));
        companyInput.sendKeys(JsonReadHelper.accountDetails("company"));
        address1Input.sendKeys(JsonReadHelper.accountDetails("address1"));
        address2Input.sendKeys(JsonReadHelper.accountDetails("address2"));
        Select countrySelector = new Select(countrySelect);
        countrySelector.selectByValue(JsonReadHelper.accountDetails("country"));
        stateInput.sendKeys(JsonReadHelper.accountDetails("state"));
        cityInput.sendKeys(JsonReadHelper.accountDetails("city"));
        zipcodeInput.sendKeys(JsonReadHelper.accountDetails("zipcode"));
        mobileNumberInput.sendKeys(JsonReadHelper.accountDetails("mobileNumber"));
        createAccountButton.click();
        return new AccountCreatedPage(driver);
    }
}
