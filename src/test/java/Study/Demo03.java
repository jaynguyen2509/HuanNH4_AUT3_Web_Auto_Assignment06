package Study;

import Assignment.Exercise01;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Demo03 {
    @Test
    public void test(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/browser-windows");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().window().maximize();

        WebElement newTabButton = webDriver.findElement(By.id("tabButton"));
        newTabButton.click();
        Set<String> ls = webDriver.getWindowHandles();
        for (String windowID : ls){
            webDriver.switchTo().window(windowID);
            try{
                WebElement title = webDriver.findElement(By.id("sampleHeading"));
                break;
            }catch (Exception e){}
        }
        System.out.println(webDriver.findElement(By.id("sampleHeading")).getText());

    }
}
