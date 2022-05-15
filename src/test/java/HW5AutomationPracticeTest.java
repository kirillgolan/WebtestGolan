import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HW5AutomationPracticeTest {
    WebDriver driver;
    //WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    void customerServiceTest() {
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("http://automationpractice.com/"))).click();
        driver.findElement(By.xpath("//a[@title='Contact Us']")).click();
        Select dropdown = new Select(driver.findElement(By.id("id_contact")));
        dropdown.selectByVisibleText("Customer service");
        driver.findElement(By.id("email")).sendKeys("email@domain.com");
        driver.findElement(By.id("message")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        driver.findElement(By.id("submitMessage")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//p[@class='alert alert-success']")).isDisplayed(), true);

    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }

}

