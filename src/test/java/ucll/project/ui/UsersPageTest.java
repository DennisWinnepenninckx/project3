package ucll.project.ui;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class UsersPageTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setDriver() {
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void CloseBrowser() {
        // close it in the end, comment this away to keep chrome open
        driver.close();
    }

    @Test
    public void VisitUsersPageTest() {
        driver.get(Config.BASE_URL);
        WebElement link = driver.findElement(By.xpath("//a[text() = 'Users']"));
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        link.click();
        assertEquals("All users", driver.getTitle());
    }
}