package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.SkillsPage;
import org.testng.annotations.Test;

public class DeleteSkillTest extends TestBase {
    @Test
    public void deleteSkill(){
        String skillName = "Random";
        String description = "Test";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123",true,null);
        SkillsPage skillPage = new SkillsPage(driver);
        skillPage.navigateToSkills();
        skillPage.addAndSaveSkill(skillName, description);
        skillPage.verifySkill(skillName, description);
        skillPage.deleteASkill(skillName);
        skillPage.verifySkillNotPresent(skillName);
    }
}
