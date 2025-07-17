package org.selcuk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.selcuk.helpers.JsonReadHelper;
import org.selcuk.helpers.WaitHelper;

import java.io.IOException;
import java.text.ParseException;

public class PaymentPage {
    @FindBy(css = "input[data-qa='name-on-card']")
    private WebElement nameOnCardInput;

    @FindBy(css = "input[data-qa='card-number']")
    private WebElement cardNumberInput;

    @FindBy(css = "input[data-qa='cvc']")
    private WebElement cvcInput;

    @FindBy(css = "input[data-qa='expiry-month']")
    private WebElement expirationMonthInput;

    @FindBy(css = "input[data-qa='expiry-year']")
    private WebElement expirationYearInput;

    @FindBy(css = "button[data-qa='pay-button']")
    private WebElement payAndConfirmOrderButton;

    @FindBy(xpath = "//div[contains(@id, 'success_message')]/div") //correct xpath but unable to locate an element
    private WebElement alertSuccess;

    @FindBy(css = "div[class='col-sm-9 col-sm-offset-1'] p")
    private WebElement successMessage;

    @FindBy(css = "a[class='btn btn-default check_out']")
    private WebElement downloadInvoiceButton;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public PaymentPage fillPaymentDetails() throws IOException, ParseException, IOException, ParseException, org.json.simple.parser.ParseException {
        nameOnCardInput.sendKeys(JsonReadHelper.paymentDetails("nameOnCard"));
        cardNumberInput.sendKeys(JsonReadHelper.paymentDetails("cardNumber"));
        cvcInput.sendKeys(JsonReadHelper.paymentDetails("cvc"));
        expirationMonthInput.sendKeys(JsonReadHelper.paymentDetails("expirationMonth"));
        expirationYearInput.sendKeys(JsonReadHelper.paymentDetails("expirationYear"));
        payAndConfirmOrderButton.click();
        return this;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public PaymentPage downloadInvoiceButtonClick() {
        downloadInvoiceButton.click();
        return this;
    }

    public HomePage continueButtonClick() {
        WaitHelper.waitForElementToBeClickable(driver, continueButton);
        continueButton.click();
        return new HomePage(driver);
    }
}
