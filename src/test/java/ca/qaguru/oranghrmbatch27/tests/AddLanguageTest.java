package ca.qaguru.oranghrmbatch27.tests;

import ca.qaguru.oranghrmbatch27.library.TestBase;
import ca.qaguru.oranghrmbatch27.pages.*;
import org.testng.annotations.Test;

import java.util.UUID;

public class AddLanguageTest extends TestBase {
    @Test
    public void addNewLanguage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123", true, null);
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.selectMenu(MenuOptions.LANGUAGES);
        LanguagesPage languagesPage = new LanguagesPage(driver);
        String newLanguageName = "Malayalam";
        languagesPage.addNewLanguage(newLanguageName);
        languagesPage.verifyAddedLanguage(newLanguageName);
    }
}


