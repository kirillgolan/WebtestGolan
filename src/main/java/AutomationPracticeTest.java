import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPracticeTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        //WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[@title='Contact Us']")).click();
        Select dropdown = new Select(driver.findElement(By.id("id_contact")));
        dropdown.selectByVisibleText("Customer service");
        driver.findElement(By.id("email")).sendKeys("email@domain.com");
        driver.findElement(By.id("message")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        driver.findElement(By.id("submitMessage")).click();
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("http://automationpractice.com/"))).click();
        driver.findElement(By.xpath("//span[normalize-space()='Home']")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.xpath("//button[@name='submit_search']")).click();
        //Thread.sleep(5000);
        driver.quit();
    }
}
