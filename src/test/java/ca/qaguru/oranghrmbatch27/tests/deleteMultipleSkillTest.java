package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.LoginPage;
import ca.qaguru.oranghrmbatch27.pages.SkillsPage;
import org.testng.annotations.Test;

public class deleteMultipleSkillTest extends TestBase {
    @Test
    public void deleteMultipleSkill(){
        String[] skillNames = {"Random1", "Random2", "Random3"};
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123",true,null);
        SkillsPage skillPage = new SkillsPage(driver);
        skillPage.navigateToSkills();
        for(String skill:skillNames){
            String description = "Test" + skill.charAt(skill.length()-1);
            skillPage.addAndSaveSkill(skill, description);
            skillPage.verifySkill(skill, description);
        }
        skillPage.deleteMultipleSkills(skillNames);
        for(String skill:skillNames){
            skillPage.verifySkillNotPresent(skill);
        }
    }
}
