package by.step.logbook.tests.login_page_tests;

import by.step.logbook.tests.base.BaseUITestsClass;
import by.step.logbook.tests.ConfProperties;
import by.step.logbook.tests.service.LoginService;
import by.step.logbook.tests.service.ProfileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginPageTest extends BaseUITestsClass {

    private LoginService loginService = new LoginService(driver);
    private ProfileService profileService = new ProfileService(driver);

    @BeforeEach
    public void openLoginPage() {
        driver.navigate().to(ConfProperties.getProperty("loginPage"));
    }

    @Test
    public void verifyLoginInputVisibility(){
        loginService = new LoginService(driver);

        Assertions.assertEquals(true, loginService.getLoginPage().getLoginBlock().loginField.isDisplayed());
    }

    @Test
    public void verifyLoginInvalidParameters() {
        //given
        String initialWrongLoginString = "qwerty";
        String initialPassword = "12345";
        String expectedErrorMessage = "Неверный логин или пароль";
        loginService = new LoginService(driver);
        loginService.getLoginPage().getLoginBlock().loginField.sendKeys(initialWrongLoginString);
        loginService.getLoginPage().getLoginBlock().passwordField.sendKeys(initialPassword);

        //when
        loginService.getLoginPage().getLoginBlock().loginButton.click();

        //then
        String actualErrorMessageText = loginService.getLoginPage().getLoginBlock().errorMessage.getText();
        Assertions.assertEquals(expectedErrorMessage, actualErrorMessageText);
    }

    @Test
    public void verifyLoginValidParameters() throws InterruptedException {
        String initialLoginString = ConfProperties.getProperty("login");
        String initialPassword = ConfProperties.getProperty("password");
        //String expectedProfileName = "Кузьмич Любовь Владимировна";
        String expectedProfileLink = "https://mystat.itstep.org/ru/main/dashboard/page/index";
        loginService = new LoginService(driver);
        loginService.getLoginPage().getLoginBlock().loginField.sendKeys(initialLoginString);
        loginService.getLoginPage().getLoginBlock().passwordField.sendKeys(initialPassword);

        loginService.getLoginPage().getLoginBlock().loginButton.click();


        //String actualProfileName = profileService.getProfilePage().getProfileBlock().getUserName();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        Thread.sleep(3000);
        String actualProfileLink = driver.getCurrentUrl();
        Assertions.assertEquals(expectedProfileLink, actualProfileLink);
    }
}
