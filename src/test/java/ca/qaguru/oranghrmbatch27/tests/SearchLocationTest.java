package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.*;
import org.testng.annotations.Test;

public class SearchLocationTest extends TestBase {
    @Test
    public void searchLocationName(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);

        SearchLocationPage searchLocationPage= new SearchLocationPage(driver);
        searchLocationPage.navigateToLocations();
        searchLocationPage.searchName("Canadian Regional HQ");
    }
}


