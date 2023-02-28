package Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Exercise04 {
    @Test
    public void test(){
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://webdevable.com/w3schools/tags/tryit5b70.html?filename=tryhtml_frame_cols");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.manage().window().maximize();

        // Switch to frame A
        webDriver.switchTo().frame(0);

        // Get the expected text and check if it is displayed
        String expectedText = "Note: The frameset, frame, and noframes elements are not supported in HTML5.";
        if (webDriver.getPageSource().contains(expectedText)) {
            System.out.println("Expected text is displayed");
        } else {
            System.out.println("Expected text is not displayed");
        }

        // Switch back to the main frame
        webDriver.switchTo().defaultContent();
    }
}
