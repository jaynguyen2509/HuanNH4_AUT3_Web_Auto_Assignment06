package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestCase02 {
    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://fleetcart.envaysoft.com/en/admin/login");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        loginButton.submit();

        //left Menu
        WebElement leftMenu = driver.findElement(By.xpath("//div[@class=\"left-side\"]"));
        softAssert.assertTrue(leftMenu.isDisplayed());
        //Total Sales
        WebElement totalSales = driver.findElement(By.xpath("//div[@class=\"single-grid total-sales\"]"));
        softAssert.assertTrue(totalSales.isDisplayed());
        //Total Order
        WebElement totalOrder = driver.findElement(By.xpath("//div[@class=\"single-grid total-orders\"]"));
        softAssert.assertTrue(totalOrder.isDisplayed());
        //Total Products
        WebElement totalProducts = driver.findElement(By.xpath("//div[@class=\"single-grid total-products\"]"));
        softAssert.assertTrue(totalProducts.isDisplayed());
        //Total customers
        WebElement totalCustomers = driver.findElement(By.xpath("//div[@class=\"single-grid total-customers\"]"));
        softAssert.assertTrue(totalCustomers.isDisplayed());

        softAssert.assertAll();
        driver.quit();
    }
}
