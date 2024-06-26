package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ClaimPage extends PageBase {
    WebDriver driver;

    public ClaimPage(WebDriver _driver) {

        super(_driver);
        driver=_driver;
        PageFactory.initElements(driver, this);
    }

    private final String Droplist = "(//i[contains(@class,'oxd-icon bi-caret-down-fill')])[2]";
    private final String txtNameField = "(//div[@class='oxd-autocomplete-text-input--before']//following::input)[1]";
    private final String jobCategorySaveBtn = "//button[@type='submit']";
    private final String mainmenu = "//span[text()='Claim']";
    private final String mymenu="(//div[@class='oxd-topbar-body']/nav/ul/li/a)[2]";
    private final String drop="(//div[@class='oxd-select-text--after']//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]";
    private final String drop1="(//div[@class='oxd-select-text--after']//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]";
    private final String option="//span[contains(text(),'Accommodation')]";
    private final String option2="//span[contains(text(),'Submitted')]";
    private final String final1="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span";
    private final String z="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span";
    private final String final2="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span";
    private final String zz="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span";
    private final String final3="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span";
    private final String viewDetails="(//button[@class='oxd-button oxd-button--medium oxd-button--text oxd-table-cell-action-space'])[2]";
    private final String heading="//h6[text()='Submit Claim']";
    private final String submitBtn="(//button//i[contains(text(),'')])[4]";
    private final String heading1="//h6[text()='Create Claim Request']";

    public void get_menu()
    {

        click(By.xpath(mainmenu));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mymenu)));
        click(By.xpath(mymenu));

    }
    public void searchRecordId() throws InterruptedException {
        click(By.xpath(Droplist));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtNameField)));
        WebElement textField = driver.findElement(By.xpath(txtNameField));
        textField.sendKeys("202307180000003");
        click(By.xpath(jobCategorySaveBtn));
    }
    public void searchRecordName() throws InterruptedException {
        click(By.xpath(Droplist));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(drop)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(option)));
        click(By.xpath(option));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobCategorySaveBtn)));
        click(By.xpath(jobCategorySaveBtn));
    }
    public void searchRecordStatus() throws InterruptedException {
        click(By.xpath(drop1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(option2)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobCategorySaveBtn)));
        click(By.xpath(jobCategorySaveBtn));
    }
    public void viewDetails() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewDetails)));
        click(By.xpath(viewDetails));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(heading)));
    }
    public void submitclaim() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(submitBtn)));
        click(By.xpath(submitBtn));
    }

    public void verifyclaimrecordID() {

        boolean is_Visible = isElementPresent(By.xpath(final1));
        Assert.assertTrue(is_Visible);
        WebElement x=driver.findElement(By.xpath(z));
        String msg=x.getText();
        System.out.println("Got the message as "+msg);
    }
    public void verifyclaimrecordName() {

        boolean is_Visible = isElementPresent(By.xpath(final2));
        Assert.assertTrue(is_Visible);
        WebElement x=driver.findElement(By.xpath(zz));
        String msg=x.getText();
        System.out.println("Got the message as "+msg);
    }
    public void verifyclaimrecordStatus() {

        boolean is_Visible = isElementPresent(By.xpath(final3));
        Assert.assertTrue(is_Visible);
        WebElement x = driver.findElement(By.xpath(final3));
        String msg = x.getText();
        System.out.println("Got the message as " + msg);
    }
    public void verifyViewDetails() {
        boolean is_Visible = isElementPresent(By.xpath(heading));
        Assert.assertTrue(is_Visible);
        WebElement x = driver.findElement(By.xpath(heading));
        String msg = x.getText();
        System.out.println("Got the Heading as " + msg);
    }
    public void verifySubmit() {
        boolean is_Visible = isElementPresent(By.xpath(heading1));
        Assert.assertTrue(is_Visible);
        WebElement x = driver.findElement(By.xpath(heading1));
        String msg = x.getText();
        System.out.println("Got the Page Heading as " + msg);
    }

}

