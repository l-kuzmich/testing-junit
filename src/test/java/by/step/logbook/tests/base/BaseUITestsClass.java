package by.step.logbook.tests.base;

import by.step.logbook.tests.ConfProperties;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseUITestsClass {

    public static WebDriver driver;

    @BeforeAll
    public void prepareWebDriver() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));

        //создание экземпляра драйвера
        driver = new ChromeDriver();

        //окно разворачивается на полный экран
        driver.manage().window().maximize();

        //неявное ожидание появления элементов на странице
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @AfterAll
    public void quitWebDriver(){
        //profilePage.userLogout();
        driver.quit();
    }
}
