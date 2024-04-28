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


    public void get_menu()
    {

        click(By.xpath(mainmenu));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(mymenu)));
        click(By.xpath(mymenu));

    }
    public void searchRecord() throws InterruptedException {
        click(By.xpath(Droplist));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtNameField)));
        WebElement textField = driver.findElement(By.xpath(txtNameField));
        textField.sendKeys("202307180000003");
        click(By.xpath(jobCategorySaveBtn));

    }

    public void verifyclaimrecord() {
        String finalXpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span";
        boolean is_Visible = isElementPresent(By.xpath(finalXpath));
        Assert.assertTrue(is_Visible);
        WebElement x=driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span"));
        String msg=x.getText();
        System.out.println("Got the message as "+msg);
    }
}

