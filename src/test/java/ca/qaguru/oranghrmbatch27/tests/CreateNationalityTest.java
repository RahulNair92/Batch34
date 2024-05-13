package ca.qaguru.oranghrmbatch27.tests;
import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.*;
import org.testng.annotations.Test;

public class CreateNationalityTest extends TestBase {
    @Test
    public void createNationality() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.NATIONALITIES);
        NationalityPage nationalityPage = new NationalityPage(driver);
        nationalityPage.addNewNationality("AndorranTest");
    }
}
