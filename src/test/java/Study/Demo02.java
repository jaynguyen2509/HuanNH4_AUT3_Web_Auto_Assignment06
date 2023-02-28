package Study;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo02 {
    @Test
    public void test(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://demoqa.com/frames");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().window().maximize();

        webDriver.switchTo().frame("frame1");
        WebElement title = webDriver.findElement(By.id("sampleHeading"));
        System.out.println(title.getText());

    }
}
