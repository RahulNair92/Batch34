package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.HeaderPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.MenuOptions;
import ca.qaguru.oranghrmbatch27.pages.NationalityPage;
import org.testng.annotations.Test;

public class EditNationalityTest extends TestBase
{
    @Test
    public void editNationality()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.NATIONALITIES);
        NationalityPage nationalityPage = new NationalityPage(driver);
        nationalityPage.editNationality();
    }
}
