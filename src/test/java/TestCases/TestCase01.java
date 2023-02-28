package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestCase01 {
    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://fleetcart.envaysoft.com/en/admin/login");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();

        WebElement email = driver.findElement(By.id("email"));
        softAssert.assertEquals(email.getAttribute("value"),"admin@email.com");
        WebElement password = driver.findElement(By.name("password"));
        softAssert.assertEquals(password.getAttribute("value"),"123456");
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        softAssert.assertTrue(loginButton.isDisplayed());
        WebElement forgotPassword = driver.findElement(By.linkText("forgot password?"));
        softAssert.assertTrue(forgotPassword.isDisplayed());
        WebElement rememberMe = driver.findElement(By.xpath("//label[@for=\"remember-me\"]"));
        softAssert.assertTrue(rememberMe.isDisplayed());

        softAssert.assertAll();
        driver.quit();
    }
}
