package TestCases;

import com.google.auto.common.Visibility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestCase04 {
    @Test
    public void test() throws InterruptedException {
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

        WebElement searchBox = driver.findElement(By.xpath("//input[@type= \"search\"]"));
        searchBox.sendKeys("Apple iPhone XS Max");
        WebElement productResult = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//td[contains(text(),\"Apple iPhone XS Max\")])[1]")));
        productResult.click();

        WebElement productName = driver.findElement(By.id("name"));
        softAssert.assertTrue(productName.getAttribute("value").contains("Apple iPhone XS Max, 64GB -white"));
        WebElement description = driver.findElement(By.xpath("//div[@class=\"tox-edit-area\"]"));
        softAssert.assertTrue(description.isDisplayed());
        WebElement brand = driver.findElement(By.xpath("//select[@name=\"brand_id\"]/option[@selected]"));
        softAssert.assertEquals(brand.getText(),"Apple");

        WebElement categories = driver.findElement(By.xpath("(//div[@class=\"selectize-input items not-full has-options has-items\"])[1]"));
        softAssert.assertTrue(categories.isDisplayed());

        WebElement tag = driver.findElement(By.xpath("(//div[@class=\"selectize-input items not-full has-options has-items\"])[2]"));
        softAssert.assertTrue(tag.isDisplayed());

        WebElement priceTab = driver.findElement(By.linkText("Price"));
        priceTab.click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//label[@for=\"price\"]"))));
        WebElement price = driver.findElement(By.xpath("//input[@name=\"price\"]"));
        softAssert.assertEquals(price.getAttribute("value"),"1400.0000");

        softAssert.assertAll();
        driver.quit();
    }
}
