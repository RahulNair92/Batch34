package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.SkillsPage;
import org.testng.annotations.Test;
public class EditSkillTest extends TestBase{

    @Test
    public void editSkill(){

        String oldSkillName = "Python";
        String oldDescription = "Programming Language";
        String newSkillName = "Python coding";
        String newDescription = "Programming Languages";
        LoginPage loginpage = new LoginPage(driver);
        loginpage.login("Admin", "admin123", true, null);
        SkillsPage skillpage = new SkillsPage(driver);
        skillpage.navigateToSkills();
        skillpage.editSkill(oldSkillName, newSkillName, oldDescription, newDescription);
        skillpage.verifySkill(newSkillName, newDescription);

    }

}
