package org.selcuk.pageObjects;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.selcuk.testCases.base.TestBase;
import org.selcuk.helpers.JsonReadHelper;
import org.selcuk.helpers.WaitHelper;

import java.io.IOException;

public class HomePage extends TestBase {
    @FindBy(how = How.CSS, using = "div[class='item active'] img[alt='demo website for practice']")
    private WebElement girlImgResponsive;

    @FindBy(how = How.CSS, using = "a[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(how = How.CSS, using = "a[href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(how = How.CSS, using = "a[href='/test_cases']")
    private WebElement testCasesButton;

    @FindBy(how = How.CSS, using = "a[href='/products']")
    private WebElement productsButton;
    @FindBy(how = How.CSS, using = "a[href='/view_cart']")
    private WebElement cartButton;

    @FindBy(how = How.CSS, using = "a[href='/product_details/1']")
    private WebElement viewProduct1Button;

    @FindBy(how = How.ID, using = "accordian")
    private WebElement categories;

    @FindBy(how = How.XPATH, using = "//*[@id='accordian']/div[1]/div[1]/h4/a/span/i")
    private WebElement womenCategory;

    @FindBy(how = How.CSS, using = "a[href='/category_products/1']")
    private WebElement dressCategory;

    @FindBy(how = How.CSS, using = "div[class='recommended_items'] h2")
    private WebElement recommendedItems;

    @FindBy(how = How.CSS, using = "div[id='recommended-item-carousel'] a[class='btn btn-default add-to-cart']")
    private WebElement blueTopAddToCartButton;

    @FindBy(how = How.CSS, using = "div[class='modal-content'] a[href='/view_cart']")
    private WebElement viewCartButton;

    @FindBy(how = How.ID, using = "scrollUp")
    private WebElement scrollUpButton;

    @FindBy(how = How.XPATH, using = "//section[1]/div/div/div/div/div/div[1]/div[1]/h2")
    private WebElement fullFledgedPracticeWebsiteForAutomationEngineers;

    //footer
    @FindBy(how = How.CSS, using = "div[class='single-widget'] h2")
    private WebElement subscription;

    @FindBy(how = How.ID, using = "susbscribe_email")
    private WebElement subscribeEmailInput;

    @FindBy(how = How.ID, using = "subscribe")
    private WebElement subscribeButton;

    @FindBy(how = How.ID, using = "success-subscribe")
    private WebElement alertSuccessSubscribe;


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement homePageIsVisible() {
        return girlImgResponsive;
    }

    public LoginSignupPage signupLoginClick() {
        signupLoginButton.click();
        return new LoginSignupPage(driver);
    }

    public ContactUsPage contactUsButtonClick() {
        contactUsButton.click();
        return new ContactUsPage(driver);
    }

    public TestCasesPage testCasesButtonClick() {
        testCasesButton.click();
        return new TestCasesPage(driver);
    }

    public ProductsPage productsButtonClick() {
        productsButton.click();
        return new ProductsPage(driver);
    }

    public CartPage cartButtonClick() {
        cartButton.click();
        return new CartPage(driver);
    }

    public ProductDetailPage viewProduct1ButtonClick() {
        WaitHelper.waitForElementToBeClickable(driver, viewProduct1Button);
        viewProduct1Button.click();
        return new ProductDetailPage(driver);
    }

    public WebElement getCategories() {
        return categories;
    }

    public HomePage womenCategoryClick() {
        WaitHelper.waitForElementToBeClickable(driver, womenCategory);
        womenCategory.click();
        return this;
    }

    public ProductsPage dressCategoryClick() {
        WaitHelper.waitForElementToBeClickable(driver, dressCategory);
        dressCategory.click();
        return new ProductsPage(driver);
    }

    public WebElement getRecommendedItems() {
        return recommendedItems;
    }

    public HomePage blueTopAddToCartButtonClick() {
        WaitHelper.waitForElementToBeClickable(driver, blueTopAddToCartButton);
        blueTopAddToCartButton.click();
        return this;
    }

    public CartPage viewCartButtonClick() {
        WaitHelper.waitForElementToBeVisible(driver, viewCartButton);
        viewCartButton.click();
        return new CartPage(driver);
    }

    public HomePage scrollUpButtonClick() {
        scrollUpButton.click();
        return this;
    }

    public WebElement getFullFledgedPracticeWebsiteForAutomationEngineers() {
        WaitHelper.waitForElementToBeVisible(driver, fullFledgedPracticeWebsiteForAutomationEngineers);
        return fullFledgedPracticeWebsiteForAutomationEngineers;
    }


    //footer
    public WebElement getSubscription() {
        return subscription;
    }

    public HomePage fillSubscribe() throws IOException, ParseException, IOException, ParseException {
        subscribeEmailInput.sendKeys(JsonReadHelper.existingUser("email"));
        WaitHelper.waitForElementToBeClickable(driver, subscribeButton);
        subscribeButton.click();
        return this;
    }

    public WebElement getAlertSuccessSubscribe() {
        return alertSuccessSubscribe;
    }
}
