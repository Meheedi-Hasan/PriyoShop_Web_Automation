package TestRunner;

import Setup.Setup;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;
    Utils utils = new Utils();
    @Test(priority = 1)
    public void doLogin() throws IOException, ParseException, InterruptedException {
        driver.get("https://priyoshop.com/");
        loginPage = new LoginPage(driver);
        utils = new Utils();
        utils.getUserCreds(0);


    }
}