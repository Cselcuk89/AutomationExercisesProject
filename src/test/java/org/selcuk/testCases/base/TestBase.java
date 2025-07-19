package org.selcuk.testCases.base;

import org.openqa.selenium.WebDriver;
import org.selcuk.helpers.BrowserHelper;
import org.selcuk.helpers.PropertiesLoadHelper;
import org.testng.annotations.*;

import java.io.IOException;

public class TestBase {
    protected static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    @BeforeMethod
    public void setup() throws IOException {
        String url = PropertiesLoadHelper.loadProperty("url");
        WebDriver driver = BrowserHelper.doBrowserSetup();
        tdriver.set(driver);
        getDriver().get(url);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        tdriver.remove();
    }
}
