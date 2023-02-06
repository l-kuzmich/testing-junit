package by.step.logbook.tests.block;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginBlock extends BaseBlock{

    public LoginBlock(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='username']")
    public WebElement loginField;

    @FindBy(id ="password")
    public WebElement passwordField;

    @FindBy(className = "flaw")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@class='login-action']")
    public WebElement loginButton;


    //= driver.findElement(By.xpath("//*[contains(@id, 'username')]")); without pageFactory!


//    @FindBy(xpath = "//*[contains(@id, 'username')]") //*[@id='login']
//    private WebElement loginField;
//
//
//    @FindBy(xpath = "//*[contains(text(), 'Вход')]")
//    private WebElement loginBtn;
//
//
//    @FindBy(xpath = "//*[contains(@id, 'password')]")
//    private WebElement passwordField;
}
