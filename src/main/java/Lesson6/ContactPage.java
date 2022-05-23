package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContactPage extends BaseView {
    public ContactPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "message")
    public WebElement messageField;

    @FindBy(id = "submitMessage")
    public WebElement submitMessageButton;

    @FindBy(xpath = "//select[@id='id_contact']/option[@value='2']")
    public WebElement customerServiceSubjectClick;

    @Step("Вводим сообщение и отправляем его")
    public void contact(String email, String message) {
        emailField.sendKeys(email);
        messageField.sendKeys(message);
        customerServiceSubjectClick.click();
        submitMessageButton.click();
    }


}
