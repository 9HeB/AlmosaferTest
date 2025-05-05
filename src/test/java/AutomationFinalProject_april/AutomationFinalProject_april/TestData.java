package AutomationFinalProject_april.AutomationFinalProject_april;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {
    String TheWebSiteUrl = "https://www.almosafer.com/en";
    WebDriver driver = new ChromeDriver();
    String ExpectedCurrency = "SAR";
    String ExpectedContactNumber = "+966554400000";
    String expectedCheckHotelTabIsNotSelected = "false";

    LocalDate date = LocalDate.now();
    int tomorrow = date.plusDays(1).getDayOfMonth();
    String tomorrowAsFormatedValue = String.format("%02d", tomorrow);

    int dayAfterTomrrow = date.plusDays(2).getDayOfMonth();
    String DayAftertomorrowAsFormatedValue = String.format("%02d", dayAfterTomrrow);

    String[] webistes = { "https://www.almosafer.com/en", "https://www.almosafer.com/ar" };
    Random rand = new Random();

    int randomIndex = rand.nextInt(webistes.length);

    // Cities
    String[] englishCities = { "dubai", "jeddah", "riyadh" };
    int randomEnglishCity = rand.nextInt(englishCities.length);

    String[] arabicCities = { "دبي", "جدة" };
    int randomArabicCity = rand.nextInt(arabicCities.length);

    // Occupancy options (Test 1)
    String[] occupancyOptions = { "1 room, 2 adults, 0 children", "1 room, 1 adult, 0 children" };
    int randomOccupancyIndex = rand.nextInt(occupancyOptions.length);

    public void Setup() {
        driver.get(TheWebSiteUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        try {
            WebElement SettingButtonEn = driver
                .findElement(By.cssSelector(".sc-jTzLTM.cta__button.cta__saudi.btn.btn-primary"));
            SettingButtonEn.click();
        } catch (Exception e) {
            // Handle cookie/banner absence
        }
    }
}