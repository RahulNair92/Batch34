package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AddJobCategoryPage extends PageBase {
    public AddJobCategoryPage(WebDriver driver) {
        super(driver);
    }

    private final String jobCategoryAddBtn = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
    private final String jobCategoryName = "div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String jobCategorySaveBtn = "//button[@type='submit']";
    private final String jobCategoryCancelBtn = "//div[@class='oxd-form-actions'] /button[1]";
    private final String lblAlreadyExistsMessage = "//div[@class='oxd-form-row'] /div";
    private final String ClassCustomerTable = "oxd-table-body";

    public void addNewJobCategory(String newJobCategoryName) {
        click(By.xpath(jobCategoryAddBtn));
        setText(By.cssSelector(jobCategoryName), newJobCategoryName);
        if (isElementPresent(By.xpath(lblAlreadyExistsMessage))) {
            boolean is_Visible = getText(By.xpath(lblAlreadyExistsMessage)).contains("Already exists");
            Assert.assertTrue(is_Visible);
            click(By.xpath(jobCategoryCancelBtn));
        } else {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ClassCustomerTable)));
        }
    }
}
