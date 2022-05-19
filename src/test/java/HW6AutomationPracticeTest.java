import Lesson6.ContactPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HW6AutomationPracticeTest {
    WebDriver driver;
    ContactPage contactPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        contactPage = new ContactPage(driver);
    }

    @Test
    void customerServiceMessageTest() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php?controller=contact");
        new ContactPage(driver)
                .contact("email@domain.com","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        Assertions.assertAll(
                () -> Assertions.assertEquals(driver.findElement(By.xpath("//p[@class='alert alert-success']")).isDisplayed(), true),
                () -> Assertions.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Home']")).isDisplayed(),true)
        );
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
