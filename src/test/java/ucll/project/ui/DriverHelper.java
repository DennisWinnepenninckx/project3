package ucll.project.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;

public class DriverHelper {
    private static WebDriver driver;

    public static WebDriver getDriver(){

        try {
            // Tries to get the Docker version of the Chromedriver
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            driver = new RemoteWebDriver(capability);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            return driver;

            /*
                If the codeblock is returning an UnreachableBrowserException, the code is not being executed in the
                designated Docker environment, and we can assume it is being run on a local PC for development Purposes
             */
        } catch (UnreachableBrowserException e) {

            /*
                In this codeblock the config for the local Chromedriver should be placed
             */

            /*
            System.setProperty("webdriver.chrome.driver", "drivers//chromedriver.exe");
            driver = new ChromeDriver();
             */
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            Config.BASE_URL = "http://localhost:8080";
            return driver;
        }
    }
}