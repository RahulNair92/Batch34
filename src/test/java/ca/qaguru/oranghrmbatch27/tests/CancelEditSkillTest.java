package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.SkillsPage;
import org.testng.annotations.Test;

public class CancelEditSkillTest extends TestBase {
    @Test
    public void cancelEditSkill(){

        String oldSkillName = "Python";
        String oldDescription = "Programming Language";
        String newSkillName = "Python coding";
        String newDescription = "Programming Languages";
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("Admin", "admin123", true, null);
        SkillsPage skillpage = new SkillsPage(driver);
        skillpage.navigateToSkills();
        skillpage.cancelEditingSkill(oldSkillName, newSkillName, oldDescription, newDescription);
        skillpage.verifySkill(oldSkillName, oldDescription);

    }
}
