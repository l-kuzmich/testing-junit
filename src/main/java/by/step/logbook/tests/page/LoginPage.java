package by.step.logbook.tests.page;

import by.step.logbook.tests.block.LoginBlock;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private LoginBlock loginBlock = new LoginBlock(driver);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginBlock getLoginBlock() {
        return loginBlock;
    }
}
