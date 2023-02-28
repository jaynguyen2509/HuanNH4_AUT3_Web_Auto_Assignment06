package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Exercise03 {
    @Test
    public void test(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.switchTo().frame("iframeResult");
        WebElement frameText = webDriver.findElement(By.xpath("//h1"));
        System.out.println(frameText.getText());
        softAssert.assertEquals(frameText.getText(),"This page is displayed in an iframe");

        softAssert.assertAll();
    }
}
