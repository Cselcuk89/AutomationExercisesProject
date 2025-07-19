package org.selcuk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.selcuk.helpers.WaitHelper;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {
    @FindBy(how = How.CSS, using = ".title.text-center")
    private WebElement titleTextCenter;

    @FindBy(how = How.CSS, using = "a[href='/product_details/1']")
    private WebElement viewProductOfFirstProductButton;

    @FindBy(how = How.ID, using = "search_product")
    private WebElement searchProductInput;

    @FindBy(how = How.ID, using = "submit_search")
    private WebElement submitSearchInput;

    @FindBy(how = How.XPATH, using = "//div[contains(@class, 'productinfo text-center')]//p")
    private List<WebElement> searchResultsNames;

    @FindBy(how = How.CSS, using = "a[data-product-id='1']")
    private WebElement addToCartButton1;

    @FindBy(how = How.CSS, using = "a[data-product-id='2']")
    private WebElement addToCartButton2;

    @FindBy(how = How.CSS, using = "button[data-dismiss='modal']")
    private WebElement continueShoppingButton;

    @FindBy(how = How.CSS, using = "a[href='/view_cart'] u")
    private WebElement viewCartButton;

    @FindBy(how = How.CSS, using = "a[href='#Men']")
    private WebElement menCategory;

    @FindBy(how = How.CSS, using = "a[href='/category_products/3']")
    private WebElement tShirtsCategory;

    @FindBy(how = How.CSS, using = "div[class='brands-name']")
    private WebElement brands;

    @FindBy(how = How.CSS, using = "a[href='/brand_products/Polo']")
    private WebElement poloBrand;

    @FindBy(how = How.CSS, using = "a[href='/brand_products/Madame']")
    private WebElement madameBrand;

    @FindBy(how = How.CSS, using = "a[class='btn btn-default add-to-cart']")
    List<WebElement> addButtons;

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getTitleTextCenter() {
        return titleTextCenter;
    }

    public ProductDetailPage viewProductOfFirstProductButtonClick() {
        viewProductOfFirstProductButton.click();
        return new ProductDetailPage(driver);
    }

    public ProductsPage fillSearchProductInput(String searchProduct) {
        searchProductInput.sendKeys(searchProduct);
        submitSearchInput.click();
        return this;
    }

    public List<String> getProductsSearchNames() {
        return searchResultsNames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public CartPage addProductsToCart() {
        WaitHelper.waitForElementToBeClickable(driver, addToCartButton1);
        addToCartButton1.click();
        WaitHelper.waitForElementToBeClickable(driver, continueShoppingButton);
        continueShoppingButton.click();
        WaitHelper.waitForElementToBeClickable(driver, addToCartButton2);
        addToCartButton2.click();
        WaitHelper.waitForElementToBeClickable(driver, viewCartButton);
        viewCartButton.click();
        return new CartPage(driver);
    }

    public ProductsPage menCategoryClick() {
        menCategory.click();
        return this;
    }

    public ProductsPage tShirtsCategoryClick() {
        tShirtsCategory.click();
        return this;
    }

    public WebElement getBrands() {
        return brands;
    }

    public ProductsPage poloBrandClick() {
        poloBrand.click();
        return this;
    }

    public ProductsPage madameBrandClick() {
        madameBrand.click();
        return this;
    }

    public ProductsPage addAllProducts() {
        for (int i = 0; i < addButtons.size(); i = i + 2) {
            WaitHelper.waitForElementToBeClickable(driver, addButtons.get(i));
            addButtons.get(i).click();
            WaitHelper.waitForElementToBeClickable(driver, continueShoppingButton);
            continueShoppingButton.click();
        }
        return this;
    }
}
