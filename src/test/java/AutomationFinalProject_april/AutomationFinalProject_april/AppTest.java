package AutomationFinalProject_april.AutomationFinalProject_april;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppTest extends TestData {

    @BeforeTest
    public void mySetup() {
        Setup();
    }

    @Test(priority = 1)
    public void CheckWebSiteLanguage() {
        String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
        Assert.assertEquals(ActualLanguage, "en", "Default language is not English!");
    }

    @Test(priority = 2)
    public void CheckCurrency() {
        String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
                .getText();
        Assert.assertEquals(ActualCurrency, ExpectedCurrency, "Currency mismatch!");
    }

    @Test(priority = 3)
    public void CheckContactNumber() {
        String ActualContactNumber = driver.findElement(By.linkText("+966554400000")).getText();
        Assert.assertEquals(ActualContactNumber, ExpectedContactNumber, "Contact number mismatch!");
    }

    @Test(priority = 4)
    public void CheckQitafLogo() {
        WebElement TheFooter = driver.findElement(By.tagName("footer"));
        boolean ActualImageIsDisplay = TheFooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo"))
                .findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();
        Assert.assertTrue(ActualImageIsDisplay, "Qitaf logo not displayed!");
    }

    @Test(priority = 5)
    public void CheckHotelTabIsNotSelected() {
        WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
        String ActualValue = HotelTab.getAttribute("aria-selected");
        Assert.assertEquals(ActualValue, expectedCheckHotelTabIsNotSelected, "Hotel tab is selected by default!");
    }

    @Test(priority = 6)
    public void FLightDepatureDate() {
        List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
        String ActualDepatureDate = dates.get(0).getText();
        Assert.assertEquals(ActualDepatureDate, tomorrowAsFormatedValue, "Departure date mismatch!");
    }

    @Test(priority = 7)
    public void FlightReturnDate() {
        List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
        String ActualReturnDate = dates.get(1).getText();
        Assert.assertEquals(ActualReturnDate, DayAftertomorrowAsFormatedValue, "Return date mismatch!");
    }

    @Test(priority = 8)
    public void ChangeTheWebsiteLanguage() {
        driver.get(webistes[randomIndex]);
        String ExpectedLanguage = driver.getCurrentUrl().contains("en") ? "en" : "ar";
        String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
        Assert.assertEquals(ActualLanguage, ExpectedLanguage, "Language did not update correctly!");
    }

    @Test(priority = 9)
    public void RandomlySelectCityAndOccupancy() {
        WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
        HotelTab.click();

        WebElement SearchInputField = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));

        if (driver.getCurrentUrl().contains("en")) {
            SearchInputField.sendKeys(englishCities[randomEnglishCity]);
        } else {
            SearchInputField.sendKeys(arabicCities[randomArabicCity]);
        }

        // Wait for autocomplete results
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".autocomplete-results li:first-child")))
             .click();

        // Select random occupancy option (Test 1)
        WebElement occupancyDropdown = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
        Select mySelector = new Select(occupancyDropdown);
        mySelector.selectByVisibleText(occupancyOptions[randomOccupancyIndex]);
    }

    @Test(priority = 10)
    public void ClickSearchHotelsButton() {
        // Click search button (Test 2)
        WebElement searchButton = driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk"));
        searchButton.click();
    }

    @Test(priority = 11)
    public void ValidateSearchResultsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for results to load (Test 3)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-spinner")));

        // Assert results are displayed (Test 3)
        List<WebElement> hotelResults = driver.findElements(By.cssSelector(".hotel-result"));
        Assert.assertTrue(hotelResults.size() > 0, "No hotel results found!");

        // Verify localized text (Test 3)
        String resultsText = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']")).getText();
        if (driver.getCurrentUrl().contains("en")) {
            Assert.assertTrue(resultsText.contains("found"), "English results text mismatch!");
        } else {
            Assert.assertTrue(resultsText.contains("مكان إقامة"), "Arabic results text mismatch!");
        }
    }

    @AfterTest
    public void AfterMyTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}