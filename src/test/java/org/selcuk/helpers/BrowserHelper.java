package org.selcuk.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class BrowserHelper {
    public static WebDriver doBrowserSetup() throws IOException, IOException {
        WebDriver driver = null;
        String name = PropertiesLoadHelper.loadProperty("browser.name");
        if (name.equalsIgnoreCase("Chrome")) {

            String pathExtension = PropertiesLoadHelper.loadProperty("chrome.extension.adblock.path");

            System.setProperty("webdriver.chrome.silentOutput", "true");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("load-extension=" + pathExtension); //uBlock Origin
            chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);

        } else if (name.equalsIgnoreCase("Firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--private");
            driver = new FirefoxDriver(firefoxOptions);
        }
        return driver;
    }
}
