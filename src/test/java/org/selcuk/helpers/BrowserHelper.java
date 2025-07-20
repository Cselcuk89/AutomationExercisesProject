package org.selcuk.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.IOException;

public class BrowserHelper {
    public static WebDriver doBrowserSetup() throws IOException, IOException {
        WebDriver driver = null;
        String name = PropertiesLoadHelper.loadProperty("browser.name");
        switch (name.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

                break;
            default:
                throw new IllegalStateException("INVALID BROWSER: " + name);
        }
        driver.manage().window().maximize();
        return driver;

    }

}



