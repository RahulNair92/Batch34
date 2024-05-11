package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    private final String option="//span[contains(text(),'Accommodation')]";


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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(drop)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(option)));
        click(By.xpath(option));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(jobCategorySaveBtn)));
        click(By.xpath(jobCategorySaveBtn));
    }

    public void verifyclaimrecordID() {

        String final1="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span";
        boolean is_Visible = isElementPresent(By.xpath(final1));
        Assert.assertTrue(is_Visible);
        WebElement x=driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span"));
        String msg=x.getText();
        System.out.println("Got the message as "+msg);
    }
    public void verifyclaimrecordName() {
        String final2="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span";
        boolean is_Visible = isElementPresent(By.xpath(final2));
        Assert.assertTrue(is_Visible);
        WebElement x=driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span"));
        String msg=x.getText();
        System.out.println("Got the message as "+msg);

    }
}

