package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class EditJobCategoryPage extends PageBase {
    public EditJobCategoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private final String jobCategorySaveBtn = "//button[@type='submit']";
    private final String jobCategoryCancelBtn = "//div[@class='oxd-form-actions'] /button[1]";
    private final String jobCategoryEditBtn = "(//i[contains(@class,'pencil')])[1]";
    private final String txtNameField = "//div[@class='oxd-input-group__label-wrapper']//following::input";
    private final String lblAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";
    private final String tblJobCategories = ".oxd-table-body";
    private final String jobCategories = "//div[@class='oxd-table-body'] /div[@class='oxd-table-card']";
    @FindBy(xpath = jobCategories)
    private List<WebElement> listJobCategories;

    public void editFirstJobCategory() {
        click(By.xpath(jobCategoryEditBtn));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtNameField)));
        WebElement textField = driver.findElement(By.xpath(txtNameField));
        textField.sendKeys("-Sample Edit");
        if (getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists")) {
            click(By.xpath(jobCategoryCancelBtn));
        } else {
            click(By.xpath(jobCategorySaveBtn));
        }
    }

    public void verifyEditCustomer() {
        String finalXpath = "//div[contains(text(),'-Sample Edit')]";
        boolean is_Visible = isElementPresent(By.xpath(finalXpath));
        Assert.assertTrue(is_Visible);
    }
}


