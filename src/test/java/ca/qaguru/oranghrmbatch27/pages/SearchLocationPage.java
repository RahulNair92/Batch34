package ca.qaguru.oranghrmbatch27.pages;

import ca.qaguru.oranghrmbatch27.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

    public class SearchLocationPage extends PageBase {
        public SearchLocationPage(WebDriver driver) {
            super(driver);
        }

        private final String NamefieldName = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input";
        private final String Search = "//button[@type='submit']";
        private final String locationsXpath = "//a[text()='Locations']";
        private final String recordFound = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/span";
        public String adminClickXpath = "//span[text()='Admin']";


        public String organizationsClickXpath = "//span[text()= 'Organization ']";


        public void navigateToLocations(){
            click(By.xpath(adminClickXpath));
            click(By.xpath(organizationsClickXpath));
            click(By.xpath(locationsXpath));
        }
        public void searchName(String Name) {
            setText(By.xpath(NamefieldName), Name);
            click(By.xpath(Search));
            if (isElementPresent(By.xpath(recordFound))) {
                boolean is_Visible = getText(By.xpath(recordFound)).contains("(1) Record Found");
                Assert.assertTrue(is_Visible);
                }
            else {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            }
        }
    }


