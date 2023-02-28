package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestCase06 {
    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://fleetcart.envaysoft.com/en/admin/login");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        loginButton.submit();
        WebElement product = driver.findElement(By.linkText("Products"));
        product.click();
        WebElement catalog = driver.findElement(By.xpath("//span[text()=\"Catalog\"]"));
        catalog.click();
        WebElement createProduct = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Create Product"))));
        createProduct.click();

        WebElement nameInput = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("name"))));
        nameInput.sendKeys("Iphone");

        Select select = new Select(driver.findElement(By.id("brand_id")));
        select.selectByVisibleText("Apple");

        WebElement saveButton = driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
        saveButton.click();

        WebElement alert = webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='alert-text']"))));
        softAssert.assertEquals(alert.getText(),"This action is disabled in demo.");
        softAssert.assertTrue(alert.isDisplayed());

        driver.quit();
        softAssert.assertAll();
    }
}
