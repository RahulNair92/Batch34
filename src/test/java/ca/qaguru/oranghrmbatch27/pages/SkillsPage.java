package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SkillsPage extends PageBase{

    WebDriver driver;
    public SkillsPage(WebDriver _driver){
        super(_driver);
        driver = _driver;
    }
    public String skillsTextXpath = "//h6[text()='Skills']";
    public String adminClickXpath = "//span[text()='Admin']";
    public String qualificationsClickXpath = "//span[text()='Qualifications ']";
    public String skillsLinkXpath = "//a[text()='Skills']";
    public String addButtonXpath = "//button[@type='button'][@class='oxd-button oxd-button--medium oxd-button--secondary']";
    public String nameFieldXpath = "(//input[@class='oxd-input oxd-input--active'])[2]";
    public String descriptionFieldXpath = "//textarea[@placeholder='Type description here']";

    public String saveButtonId = "button[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']";
    public String checkSkillPartialXpath = "//div[@style='flex: 2 1 0%;']//following::div[text()='";
    public String checkdescPartialXpath = "//div[@style='flex: 4 1 0%;']//following::div[text()='";

    public String editButtonXPathLastPart = "']//following::i[@class='oxd-icon bi-pencil-fill']";
    public String deleteButtonXPathLastPart = "']//following::i[@class='oxd-icon bi-trash']";
    public String yesDeleteID = "button[class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";
    public String skillCheckBoxXPathLastPart = "']//ancestor::div[@class='oxd-table-row oxd-table-row--with-border']//descendant::span[contains(@class,'label-right oxd-checkbox-input')]";
    public String deleteSelectedButtonID = "i[class='oxd-icon bi-trash-fill oxd-button-icon']";
    public String cancelButtonID = "button[class='oxd-button oxd-button--medium oxd-button--ghost']";



    public void navigateToSkills(){
        click(By.xpath(adminClickXpath));
        click(By.xpath(qualificationsClickXpath));
        click(By.xpath(skillsLinkXpath));
    }

    public void addAndSaveSkill(String skillName, String skillDescription) {
        String checkskillXpath = checkSkillPartialXpath + skillName + "']";
        if(!isElementVisible(By.xpath(checkskillXpath))){
            click(By.xpath(addButtonXpath));
            setText(By.xpath(nameFieldXpath), skillName);
            setText(By.xpath(descriptionFieldXpath), skillDescription);
            click(By.cssSelector(saveButtonId));

        }
        else{
            System.out.println("Skill already present");
        }

    }

    public void verifySkill(String skillName, String skillDescription){
        String checkskillXpath = checkSkillPartialXpath + skillName + "']";
        String checkdescripXPath = checkdescPartialXpath + skillDescription + "']";
        Assert.assertTrue(isElementVisible(By.xpath(checkskillXpath)));
        Assert.assertTrue(isElementVisible(By.xpath(checkdescripXPath)));

    }
    public void verifySkillNotPresent(String skillName){
        String checkskillXpath = checkSkillPartialXpath + skillName + "']";
        Assert.assertFalse(isElementVisible(By.xpath(checkskillXpath)));

    }

    public void editSkill(String oldSkillName, String newSkillName, String oldSkillDescription, String newSkillDescription){
        String checkSkillXpath = checkSkillPartialXpath + oldSkillName + "']";
        String editbuttonXpath = checkSkillPartialXpath + oldSkillName + editButtonXPathLastPart;
        if (isElementPresent(By.xpath(checkSkillXpath))){
            click(By.xpath(editbuttonXpath));
            clearAndEnterText(By.xpath(nameFieldXpath), newSkillName);
            clearAndEnterText(By.xpath(descriptionFieldXpath), newSkillDescription);
            click(By.cssSelector(saveButtonId));


        }
        else{
            System.out.println("Skill not present");
        }

    }
    public void cancelEditingSkill(String oldSkillName, String newSkillName, String oldSkillDescription, String newSkillDescription){
        String checkSkillXpath = checkSkillPartialXpath + oldSkillName + "']";
        String editbuttonXpath = checkSkillPartialXpath + oldSkillName + editButtonXPathLastPart;
        if (isElementPresent(By.xpath(checkSkillXpath))){
            click(By.xpath(editbuttonXpath));
            clearAndEnterText(By.xpath(nameFieldXpath), newSkillName);
            clearAndEnterText(By.xpath(descriptionFieldXpath), newSkillDescription);
            click(By.cssSelector(cancelButtonID));


        }
        else{
            System.out.println("Skill not present");
        }

    }
    public void deleteASkill(String skillName){
        String checkSkillXpath = checkSkillPartialXpath + skillName + "']";
        String deletebuttonXpath = checkSkillPartialXpath + skillName + deleteButtonXPathLastPart;
        if (isElementPresent(By.xpath(checkSkillXpath))){
            click(By.xpath(deletebuttonXpath));
            click(By.cssSelector(yesDeleteID));
        }
        else{
            System.out.println("Skill not present");
        }

    }
    public void deleteMultipleSkills(String[] skillNames){
        for(String skillName : skillNames){
            String checkSkillXpath = checkSkillPartialXpath + skillName + "']";
            String skillCheckBoxXpath = checkSkillPartialXpath + skillName + skillCheckBoxXPathLastPart;
            if (isElementPresent(By.xpath(checkSkillXpath))){
                scrollInToView(By.xpath(checkSkillXpath));
                click(By.xpath(skillCheckBoxXpath));
            }
            else{
                System.out.println(skillName + ", not present.");
            }
        }

        scrollInToView(By.xpath(skillsTextXpath));
        click(By.cssSelector(deleteSelectedButtonID));
        click(By.cssSelector(yesDeleteID));
    }

}
