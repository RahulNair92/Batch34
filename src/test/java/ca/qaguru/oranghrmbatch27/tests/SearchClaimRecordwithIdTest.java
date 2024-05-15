package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.*;
import org.testng.annotations.Test;

public class SearchClaimRecordwithIdTest extends TestBase {
    @Test
    public void searchClaimRecordwithId() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        ClaimPage search = new ClaimPage(driver);
        search.get_menu();
        search.searchRecordId();
        search.verifyclaimrecordID();

    }
}