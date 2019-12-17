package ucll.project.ui;


import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class HomePageTest {

    private static WebDriver driver;

    @BeforeEach
    public  void setDriver() {
        // Setup the Chrome driver for the whole class
        driver = DriverHelper.getDriver();
    }

    @AfterClass
    public static void CloseBrowser() {
        // close it in the end, comment this away to keep chrome open
        driver.close();
    }

    /**
     * This is a sample test, remove this test and write your own!
     */
    @Test
    public void VisitHomePageTest() {
        driver.get(Config.BASE_URL);
        assertEquals("Hello world!", driver.getTitle());
    }

}
