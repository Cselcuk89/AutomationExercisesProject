package org.selcuk.pageObjects;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.selcuk.helpers.JsonReadHelper;
import org.selcuk.helpers.WaitHelper;

import java.io.IOException;

public class ProductDetailPage {
    @FindBy(how = How.CSS, using = "div[class='product-information'] h2")
    private WebElement productName;

    @FindBy(how = How.XPATH, using = "//section/div/div/div[2]/div[2]/div[2]/div/p[1]")
    private WebElement productCategory;

    @FindBy(how = How.CSS, using = "div[class='product-information'] span span")
    private WebElement productPrice;

    @FindBy(how = How.XPATH, using = "//section/div/div/div[2]/div[2]/div[2]/div/p[2]")
    private WebElement productAvailability;

    @FindBy(how = How.XPATH, using = "//section/div/div/div[2]/div[2]/div[2]/div/p[3]")
    private WebElement productCondition;

    @FindBy(how = How.XPATH, using = "//section/div/div/div[2]/div[2]/div[2]/div/p[4]")
    private WebElement productBrand;

    @FindBy(how = How.ID, using = "quantity")
    private WebElement quantityInput;

    @FindBy(how = How.CSS, using = "button[class='btn btn-default cart']")
    private WebElement addToCartButton;

    @FindBy(how = How.CSS, using = "a[href='/view_cart'] u")
    private WebElement viewCartButton;

    @FindBy(how = How.CSS, using = "a[href='#reviews']")
    private WebElement writeYourReview;

    @FindBy(how = How.ID, using = "name")
    private WebElement yourNameInput;

    @FindBy(how = How.ID, using = "email")
    private WebElement emailAddress;

    @FindBy(how = How.ID, using = "review")
    private WebElement addReviewHere;

    @FindBy(how = How.ID, using = "button-review")
    private WebElement submitButton;

    @FindBy(how = How.CSS, using = "div[class='alert-success alert'] span")
    private WebElement successMessage;

    private WebDriver driver;

    public ProductDetailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getProductName() {
        return productName;
    }

    public WebElement getProductCategory() {
        return productCategory;
    }

    public WebElement getProductPrice() {
        return productPrice;
    }

    public WebElement getProductAvailability() {
        return productAvailability;
    }

    public WebElement getProductCondition() {
        return productCondition;
    }

    public WebElement getProductBrand() {
        return productBrand;
    }

    public ProductDetailPage increaseQuantity(String value) {
        quantityInput.clear();
        quantityInput.sendKeys(value);
        return this;
    }

    public ProductDetailPage addToCartButtonClick() {
        addToCartButton.click();
        return this;
    }

    public CartPage viewCartButtonClick() {
        WaitHelper.waitForElementToBeClickable(driver, viewCartButton);
        viewCartButton.click();
        return new CartPage(driver);
    }

    public WebElement getWriteYourReview() {
        return writeYourReview;
    }

    public ProductDetailPage fillReview() throws IOException, ParseException, IOException, ParseException {
        yourNameInput.sendKeys(JsonReadHelper.existingUser("name"));
        emailAddress.sendKeys(JsonReadHelper.existingUser("email"));
        addReviewHere.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                " Sed viverra, elit quis interdum feugiat, mi urna aliquam est, at venenatis quam odio et nisl." +
                " In at massa sit amet dui hendrerit mattis ac sit amet erat.");
        submitButton.click();
        return this;
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }
}
