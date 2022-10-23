package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    public WebDriver driver;

    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //menu *[@id="gb"]/div[2]/div[3]/div[1]/div[2]/div/a
    //username *[@id="yDmH0d"]/c-wiz/div/div/div/div/div[2]/div/div/div[2]/c-wiz[1]/div/div/div/div[2]/div[1]
    ///html/body/mystat/ng-component/ng-component/div/div[3]/div[1]/top-pane/nav/div[1]/span[2]/span[1]/a
    @FindBy(xpath = "/html/body/mystat/ng-component/ng-component/div/div[3]/div[1]/top-pane/nav/div[1]/span[2]/span[1]/a")
    private WebElement userFio;

    @FindBy(xpath = "//*[contains(@class, 'logout-link align-self-end')]")
    private WebElement logoutBtn;

    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/mystat/ng-component/ng-component/div/div[3]/div[1]/top-pane/nav/div[1]/span[2]/span[1]/a")));
        return userFio.getText();
    }

    public void userLogout() {
        logoutBtn.click();
    }
}
