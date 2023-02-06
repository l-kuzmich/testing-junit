package by.step.logbook.tests.service;

import by.step.logbook.tests.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginService extends BaseService {

    private LoginPage loginPage = new LoginPage(driver);

    public LoginService(WebDriver driver) {
        super(driver);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }
}
