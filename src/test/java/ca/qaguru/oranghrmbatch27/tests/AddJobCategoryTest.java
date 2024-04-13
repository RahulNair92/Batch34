package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.AddJobCategoryPage;
import ca.qaguru.oranghrmbatch27.pages.HeaderPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.MenuOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.UUID;

public class AddJobCategoryTest extends TestBase {
    @Test
    public void addJobCategory(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
        AddJobCategoryPage addJobCategoryPage = new AddJobCategoryPage(driver);
        addJobCategoryPage.addNewJobCategory("Quality Assurance");
    }
}
