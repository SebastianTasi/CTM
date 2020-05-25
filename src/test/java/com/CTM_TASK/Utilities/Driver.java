package com.CTM_TASK.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Utility Class that initialize WebDriver instance
 * Singleton Pattern
 */

public class Driver {
    private Driver() {
    }

    static final Logger logger = LogManager.getLogger(Driver.class);
    private static WebDriver driver;


    public static WebDriver get() {

            if (driver == null) {
                switch (ConfigurationReader.get("browser")) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    default:
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                }
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();

                logger.info("Starting WebDriver.");

            }
            return driver;

    }
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            logger.info("Closing WebDriver");
        }
    }
}