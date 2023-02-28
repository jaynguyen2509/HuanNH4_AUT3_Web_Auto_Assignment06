package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestCase03 {
    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://fleetcart.envaysoft.com/en/admin/login");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();
        Actions action = new Actions(driver);

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        loginButton.submit();

        WebElement product = driver.findElement(By.linkText("Products"));
        product.click();
        WebElement catalog = driver.findElement(By.xpath("//span[text()=\"Catalog\"]"));
        catalog.click();
        WebElement productList = driver.findElement(By.xpath("//div[@id = \"products-table\"]"));
        softAssert.assertTrue(productList.isDisplayed());

        softAssert.assertAll();
        driver.quit();
    }
}
