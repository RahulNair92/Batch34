package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.ClaimPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import org.testng.annotations.Test;

public class SearchRecordwithNameTest extends TestBase {
    @Test
    public void SearchrecordwithNameTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        ClaimPage search = new ClaimPage(driver);
        search.get_menu();
        search.searchRecordName();
        search.verifyclaimrecordName();

    }
}
