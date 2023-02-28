package Assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Exercise01 {
    @Test
    public void test(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        WebElement clickMeButton = webDriver.findElement(By.xpath("//button[@onclick='myAlertFunction()']"));
        clickMeButton.click();
        Alert alert = webDriver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebElement jsAlertBox = webDriver.findElement(By.xpath("//button[@onclick='myConfirmFunction()']"));
        jsAlertBox.click();
        System.out.println(alert.getText());
        alert.accept();

        WebElement textAfterClick = webDriver.findElement(By.id("confirm-demo"));
        softAssert.assertTrue(textAfterClick.getText().contains("You pressed OK!"));

        WebElement jsPromptBox = webDriver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        jsPromptBox.click();
        alert.sendKeys("Jay Nguyen");
        alert.accept();
        WebElement textAfterInput = webDriver.findElement(By.id("prompt-demo"));
        softAssert.assertTrue(textAfterInput.getText().contains("You have entered 'Jay Nguyen' !"));

        webDriver.quit();
    }
}
