package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'username')]")
    private WebElement loginField;


    @FindBy(xpath = "//*[contains(text(), 'Вход')]")
    private WebElement loginBtn;


    @FindBy(xpath = "//*[contains(@id, 'password')]")
    private WebElement passwordField;


    public void inputLogin(String login){
        loginField.sendKeys(login);
    }

    public void inputPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn (){
        loginBtn.click();
    }
}
