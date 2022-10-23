package org.example;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup(){
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));

        //создание экземпляра драйвера
        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        //окно разворачивается на полный экран
        driver.manage().window().maximize();

        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginPage"));
    }

    @Test
    public void loginTest(){
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPassword(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        String user = profilePage.getUserName();
        Assert.assertEquals("Кузьмич Любовь Владимировна", user);
    }

    @AfterClass
    public  static void tearDown(){
        profilePage.userLogout();
        driver.quit();
    }


}
