# 🌍 Almosafer Test Project

Welcome to the **Almosafer Test Project**, a powerful UI test suite designed to validate the core functionalities of a travel booking website.

This suite includes tests for:
- 🌐 Website language detection
- 💱 Currency verification
- 📞 Contact information validation
- 🏨 Hotel tab behavior
- 📅 Date selections
- 🌍 Localization
- 🔍 Hotel search functionality

---

## 🚀 Technologies Used

- **Java** - Core programming language
- **Selenium WebDriver** - Browser automation
- **TestNG** - Test framework
- **ChromeDriver** - Browser driver for Chrome
- **Maven** *(optional)* - Dependency and build management


---

## 🧪 Test Suite Overview

Here’s a breakdown of all the test cases with priorities and functionality:

| Priority | ✅ Test Method                     | 🔍 What It Does |
|----------|------------------------------------|------------------|
| 1        | `CheckWebSiteLanguage()`           | Ensures the website defaults to English (`lang="en"`). |
| 2        | `CheckCurrency()`                  | Verifies displayed currency matches the expected one. |
| 3        | `CheckContactNumber()`             | Confirms the contact number is correct. |
| 4        | `CheckQitafLogo()`                 | Checks that the Qitaf logo appears in the footer. |
| 5        | `CheckHotelTabIsNotSelected()`     | Makes sure hotel tab isn’t selected by default. |
| 6        | `FLightDepatureDate()`             | Validates the default departure date is set correctly. |
| 7        | `FlightReturnDate()`               | Validates the default return date. |
| 8        | `ChangeTheWebsiteLanguage()`       | Loads a random language version and validates the change. |
| 9        | `RandomlySelectCityAndOccupancy()` | Randomly selects a city and an occupancy setting. |
| 10       | `ClickSearchHotelsButton()`        | Triggers hotel search using selected options. |
| 11       | `ValidateSearchResultsPage()`      | Confirms that search results are loaded and localized. |


Happy Testing! 🧪✨
