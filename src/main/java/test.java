import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class test {

    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to bdjobs.com
            driver.get("https://bdjobs.com");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // Click on the login link
            driver.findElement(By.cssSelector("li.hidden-xs.soca>a")).click();

            // Click on the login button
            driver.findElement(By.cssSelector(".cart-mbdj-r>.btn-wraper>.btn.slu-btn")).click();

            // Enter username
            driver.findElement(By.id("TXTUSERNAME")).sendKeys("demo");

            // Click on the next button
            driver.findElement(By.cssSelector(".btn.btn-success.btn-signin")).click();

            // Enter password
            driver.findElement(By.id("TXTPASS")).sendKeys("demo123456");

            // Click on the login button
            driver.findElement(By.cssSelector(".btn.btn-success.btn-signin.btn-block")).click();

            // Wait for the keyword search box to be present and enter "SQA"
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txtKeyword"))).sendKeys("SQA");

            // Click on the search button
            driver.findElement(By.cssSelector(".btn.btn-default[value='Search']")).click();

            // Get the current window handle
            String mainWindowHandle = driver.getWindowHandle();

            // Get all window handles
            Set<String> allWindowHandles = driver.getWindowHandles();

            // Switch to the new window
            for (String handle : allWindowHandles) {
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            // Perform multiple searches with different keywords
            performSearch(wait, "Developer");
            performSearch(wait, "@@#$%^&*");
            performSearch(wait, "Data Entry");
            performSearch(wait, "12345678");
            performSearch(wait, "Internal Audit Supervisor - SQA (Quality & Process");
            performSearch(wait, "Customer Support 123");


        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Method to perform search with different keywords
    private static void performSearch(WebDriverWait wait, String keyword) {
        // Wait for the dropdown to be clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".dropdown>a[aria-label='search by Keyword']"))).click();

        // Clear previous search
        wait.until(ExpectedConditions.elementToBeClickable(By.id("txtsearch"))).clear();

        // Type new keyword
        wait.until(ExpectedConditions.elementToBeClickable(By.id("txtsearch"))).sendKeys(keyword);

        // Click on the search button
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.done-button-s[type='button']"))).click();
    }
}
