package org.selcuk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.selcuk.testCases.base.TestBase;
import org.selcuk.helpers.DateTimeHelper;
import org.selcuk.helpers.JsonReadHelper;

import java.io.IOException;
import java.text.ParseException;

public class EnterAccountInformationPage extends TestBase {
    @FindBy(how = How.XPATH, using = "//b[contains(.,'Enter Account Information')]")
    private WebElement enterAccountInformation;

    @FindBy(how = How.ID, using = "id_gender1")
    private WebElement titleMrCheckbox;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordInput;

    @FindBy(how = How.ID, using = "days")
    private WebElement daysSelect;

    @FindBy(how = How.ID, using = "months")
    private WebElement monthsSelect;

    @FindBy(how = How.ID, using = "years")
    private WebElement yearsSelect;

    @FindBy(how = How.ID, using = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(how = How.ID, using = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(how = How.ID, using = "first_name")
    private WebElement firstNameInput;

    @FindBy(how = How.ID, using = "last_name")
    private WebElement lastNameInput;

    @FindBy(how = How.ID, using = "company")
    private WebElement companyInput;

    @FindBy(how = How.ID, using = "address1")
    private WebElement address1Input;

    @FindBy(how = How.ID, using = "address2")
    private WebElement address2Input;

    @FindBy(how = How.ID, using = "country")
    private WebElement countrySelect;

    @FindBy(how = How.ID, using = "state")
    private WebElement stateInput;

    @FindBy(how = How.ID, using = "city")
    private WebElement cityInput;

    @FindBy(how = How.ID, using = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(how = How.ID, using = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(how = How.CSS, using = "button[data-qa='create-account']")
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
