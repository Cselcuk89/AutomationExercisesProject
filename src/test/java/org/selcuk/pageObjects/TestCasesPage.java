package org.selcuk.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.selcuk.helpers.WaitHelper;

public class TestCasesPage {
    @FindBy(how = How.CSS, using = "h2[class='title text-center'] b")
    private WebElement testCases;

    private WebDriver driver;

    public TestCasesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getTestCases() {
        WaitHelper.waitForElementToBeVisible(driver, testCases);
        return testCases;
    }
}
