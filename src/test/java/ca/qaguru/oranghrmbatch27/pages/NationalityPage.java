package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class NationalityPage extends PageBase
{
    public NationalityPage(WebDriver driver)
    {
        super(driver);
    }
    private final String nationalityAddBtn = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
    public final String nationalityName = "div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String nationalitySaveBtn = "//button[@type='submit']";
    private final String lblAlreadyExistsMsg = "//div[@class='oxd-form-row'] /div";
    private final String nationalityCancelBtn = "//div[@class='oxd-form-actions'] /button[1]";
    private final String ClassCustomerTable = "oxd-table-body";

    public void addNewNationality(String newNationalityName)
    {
        click(By.xpath(nationalityAddBtn));
        setText(By.cssSelector(nationalityName), newNationalityName);
        click(By.xpath(nationalitySaveBtn));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ClassCustomerTable)));
    }
}
