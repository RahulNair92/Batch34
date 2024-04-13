package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.EditJobCategoryPage;
import ca.qaguru.oranghrmbatch27.pages.HeaderPage;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.MenuOptions;
import org.testng.annotations.Test;

public class EditJobCategoryTest extends TestBase {

    @Test
    public void editJobCategory(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin","admin123",true,null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.JOB_CATEGORIES);
        EditJobCategoryPage editJobCategoryPage = new EditJobCategoryPage(driver);
        editJobCategoryPage.editFirstJobCategory();
        editJobCategoryPage.verifyEditCustomer();
    }
}
