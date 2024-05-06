package ca.qaguru.oranghrmbatch27.pages;


import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LanguagesPage extends PageBase {


    private WebDriverWait wait;

    public LanguagesPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    private final String languagesAddBtn = "//button[@type='button'][@class='oxd-button oxd-button--medium oxd-button--secondary']";
    private final String languagesName = "div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String languagesSaveBtn = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
    private final String languagesCancelBtn = "//div[@class='oxd-form-actions'] /button[1]";
    private final String lblAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";
    private final String ClassLanguageTable = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";
    private final String verifyLanguageList = "//div[@class='oxd-table-cell' and @role='cell' and contains(@style, 'flex-basis: 80%')]//div[@class='data' and text()='']";

    public void addNewLanguage(String newLanguageName) {
        click(By.xpath(languagesAddBtn));
        setText(By.cssSelector(languagesName), newLanguageName);
        click(By.cssSelector(languagesSaveBtn));
    }


    public boolean verifyAddedLanguage(String newLanguageName) {

        String languageXPath = "//div[@class='oxd-table-cell' and @role='cell' and contains(@style, 'flex-basis: 80%')]//div[@class='data' and text()='" + newLanguageName + "']";

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(languageXPath)));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}