package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.SkillsPage;
import org.testng.annotations.Test;

import java.util.UUID;

public class AddSkillTest extends TestBase {

    @Test
    public void addSkill(){
        String skillName = "Selenium";
        String description = "Webpage automation";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123",true,null);
        SkillsPage skillPage = new SkillsPage(driver);
        skillPage.navigateToSkills();
        skillPage.addAndSaveSkill(skillName, description);
        skillPage.checkNewSkill(skillName, description);
    }

}
