package ca.qaguru.oranghrmbatch27.pages;
import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class NationalityPage extends PageBase {
    public NationalityPage(WebDriver driver) {
        super(driver);
    }
    private final String nationalityAddBtn = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
    public final String nationalityName = "div[class='oxd-form-row'] input[class*='oxd-input']";
    private final String nationalitySaveBtn = "//button[@type='submit']";
    private final String lblAlreadyExistsMsg = "//div[@class='oxd-form-row'] /div";
    private final String nationalityCancelBtn = "//div[@class='oxd-form-actions'] /button[1]";
    private final String ClassCustomerTable = "oxd-table-body";
    private final String nationalityEditBtn = "(//i[contains(@class,'pencil')])[1]";
    private final String txtNameField = "//div[@class='oxd-input-group__label-wrapper']//following::input";
    private final String nationalityDeleteBtn = "(//i[contains(@class,'trash')])[1]";
    private final String nationalityConfDeleteBtn = "(//i[contains(@class,'oxd-icon bi-trash oxd-button-icon')])";
    private final String deleteSelectedBtn = "(//i[contains(@class,'oxd-icon bi-trash-fill oxd-button-icon')])";
    private final String nationalitySelectionChkBox = "(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[2]";

    public void addNewNationality(String newNationalityName) {
        click(By.xpath(nationalityAddBtn));
        setText(By.cssSelector(nationalityName), newNationalityName);
        click(By.xpath(nationalitySaveBtn));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ClassCustomerTable)));
    }

    public void editNationality() {
        click(By.xpath(nationalityEditBtn));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(txtNameField)));
        WebElement textField = driver.findElement(By.xpath(txtNameField));
        textField.sendKeys("-Edited");
        click(By.xpath(nationalitySaveBtn));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ClassCustomerTable)));
    }

    public void deleteNationality() {
        click(By.xpath(nationalityDeleteBtn));
        click(By.xpath(nationalityConfDeleteBtn));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ClassCustomerTable)));
    }

    public void deleteNationalityUsingChkBox() {
        click(By.xpath(nationalitySelectionChkBox));
        click(By.xpath(deleteSelectedBtn));
        click(By.xpath(nationalityConfDeleteBtn));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(ClassCustomerTable)));

    }
}




