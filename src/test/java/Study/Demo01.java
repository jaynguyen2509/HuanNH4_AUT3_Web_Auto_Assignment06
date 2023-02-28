package Study;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo01 {
    @Test
    public void test(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/alerts");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().window().maximize();

        //Button 1
        WebElement alertButton = webDriver.findElement(By.id("alertButton"));
        alertButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();
        alert.accept();

        //Button 2
        WebElement alertTimer = webDriver.findElement(By.id("timerAlertButton"));
        alertTimer.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        //Button 3
        WebElement confirmButton = webDriver.findElement(By.id("confirmButton"));
        confirmButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();

        //Button 4
        WebElement promptButton = webDriver.findElement(By.id("promtButton"));
        promptButton.click();
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Thay LamNS3 number 1");
        alert.accept();
    }
}
