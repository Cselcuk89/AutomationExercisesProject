package org.selcuk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.selcuk.helpers.WaitHelper;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {

    @FindBy(how = How.XPATH, using = "//td[contains(@class, 'cart_description')]//a")
    private List<WebElement> productName;

    @FindBy(how = How.XPATH, using = "//td[contains(@class, 'cart_price')]/p")
    private List<WebElement> price;

    @FindBy(how = How.XPATH, using = "//td[contains(@class, 'cart_quantity')]/button")
    private List<WebElement> quantity;

    @FindBy(how = How.XPATH, using = "//p[contains(@class, 'cart_total_price')]")
    private List<WebElement> totalPrice;

    @FindBy(how = How.CSS, using = "li[class='active']")
    private WebElement shoppingCart;

    @FindBy(how = How.CSS, using = "a[class='btn btn-default check_out']")
    private WebElement proceedToCheckoutButton;

    @FindBy(how = How.CSS, using = "a[href='/login'] u")
    private WebElement registerLoginButton;

    @FindBy(how = How.CSS, using = "a[data-product-id='1']")
    private WebElement xButton1;

    @FindBy(how = How.CSS, using = "a[data-product-id='2']")
    private WebElement xButton2;

    @FindBy(how = How.ID, using = "empty_cart")
    private WebElement emptyCartSpan;

    @FindBy(how = How.CSS, using = "a[class='cart_quantity_delete']")
    private List<WebElement> xButtons;

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<String> getProductsNames() {
        return productName
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getPrices() {
        return price
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getQuantity() {
        return quantity
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getTotalPrices() {
        return totalPrice
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public CartPage proceedToCheckoutButtonClick() {
        proceedToCheckoutButton.click();
        return this;
    }

    public CheckoutPage proceedToCheckoutLoggedButtonClick() {
        proceedToCheckoutButton.click();
        return new CheckoutPage(driver);
    }

    public LoginSignupPage registerLoginButtonClick() {
        registerLoginButton.click();
        return new LoginSignupPage(driver);
    }

    public CartPage xButtonClick() {
        xButton1.click();
        xButton2.click();
        return this;
    }

    public WebElement getEmptyCartSpan() {
        WaitHelper.waitForElementToBeVisible(driver, emptyCartSpan);
        return emptyCartSpan;
    }

    public CartPage deleteAllAddedProducts() throws InterruptedException {
        int xButtonsSize = xButtons.size();
        for (int i = 0; i < xButtonsSize; i++) {
            xButtons.get(0).click();
            Thread.sleep(500);
        }
        return this;
    }
}