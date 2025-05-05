# Almosafer Test Project

This project is an automated UI test suite for a travel booking website using **Java**, **Selenium WebDriver**, and **TestNG**. The suite includes a variety of functional checks including UI language, currency, date selection, localization, and search functionality.

---

## 🛠️ Technologies Used

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **ChromeDriver**
- **Maven** (optional for dependency management)

---

## 📁 Project Structure



AutomationFinalProject\_april/
├── AutomationFinalProject\_april/
│   ├── AppTest.java           # Main test class with test cases
│   └── TestData.java          # Contains test data used in AppTest



---

## ✅ Test Cases Overview

| Priority | Test Name                         | Description |
|----------|-----------------------------------|-------------|
| 1        | `CheckWebSiteLanguage`            | Verifies default language is English (`lang="en"`). |
| 2        | `CheckCurrency`                   | Checks if the default currency matches the expected one. |
| 3        | `CheckContactNumber`              | Verifies that the displayed contact number is correct. |
| 4        | `CheckQitafLogo`                  | Confirms that the Qitaf logo is visible in the footer. |
| 5        | `CheckHotelTabIsNotSelected`      | Ensures the hotel tab is not selected by default. |
| 6        | `FLightDepatureDate`              | Checks that the default departure date is correct. |
| 7        | `FlightReturnDate`                | Checks that the default return date is correct. |
| 8        | `ChangeTheWebsiteLanguage`        | Opens a random localized version of the site and checks the language. |
| 9        | `RandomlySelectCityAndOccupancy`  | Selects a city and occupancy randomly for hotel search. |
| 10       | `ClickSearchHotelsButton`         | Clicks the search button to look for hotels. |
| 11       | `ValidateSearchResultsPage`       | Verifies search results are shown and contain correct localized messages. |

---


