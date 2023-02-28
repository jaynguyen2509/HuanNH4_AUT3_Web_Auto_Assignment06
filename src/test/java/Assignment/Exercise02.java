package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Exercise02 {
    @Test
    public void test(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://demo.seleniumeasy.com/window-popup-modal-demo.html");
        SoftAssert softAssert = new SoftAssert();
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        WebElement followOnTwitter = webDriver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Twitter']"));
        followOnTwitter.click();
        // Switch to the new window and get the title
        String twitterWindow = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        System.out.println("Twitter title: " + webDriver.getTitle());
        // Switch back to the parent window
        webDriver.switchTo().window(twitterWindow);

        // Click Like us On Facebook
        WebElement likeUsOnFacebook = webDriver.findElement(By.xpath("//a[text()=\"  Like us On Facebook \"]"));
        likeUsOnFacebook.click();
        // Switch to the new window and get the title
        String facebookWindow = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            webDriver.switchTo().window(windowHandle);
        }
        String facebookTitle = webDriver.getTitle();
        System.out.println("Facebook title: " + facebookTitle);

        webDriver.quit();
    }
}
