package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase05 {
    @Test
    public void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://fleetcart.envaysoft.com/en/admin/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SoftAssert softAssert = new SoftAssert();

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
        loginButton.submit();
        WebElement product = driver.findElement(By.linkText("Products"));
        product.click();
//        WebElement brand = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//span[text()=\"Brands\"]"))));
        WebElement brand = driver.findElement(By.xpath("//span[text()=\"Brands\"]"));
        brand.click();
//        driver.navigate().to("https://fleetcart.envaysoft.com/en/admin/brands");
        wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//tbody/tr"))));
//        Thread.sleep(3000);
        WebElement nokia = driver.findElement(By.xpath("//td[text() = 'NOKIA']"));
        softAssert.assertTrue(nokia.isDisplayed());
        WebElement sony = driver.findElement(By.xpath("//td[text() = 'SONY']"));
        softAssert.assertTrue(sony.isDisplayed());
        WebElement nike = driver.findElement(By.xpath("//td[text() = 'NIKE']"));
        softAssert.assertTrue(nike.isDisplayed());
        WebElement microsoft = driver.findElement(By.xpath("//td[text() = 'Microsoft']"));
        softAssert.assertTrue(microsoft.isDisplayed());
        WebElement huawei = driver.findElement(By.xpath("//td[text() = 'Huawei']"));
        softAssert.assertTrue(huawei.isDisplayed());
        WebElement apple = driver.findElement(By.xpath("//td[text() = 'Apple']"));
        softAssert.assertTrue(apple.isDisplayed());



        softAssert.assertAll();
    }
}


//        WebElement tableListBrand = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table")));
//        List<WebElement> tableListTr = tableListBrand.findElements(By.tagName("tr"));
//        String[] expectedBrands = {"NOKIA", "SONY", "NIKE", "Microsoft", "Huawei", "Apple"};
//        for (String item : expectedBrands) {
//            List<String> actualBrand = new ArrayList<>();
//            boolean itemFound = false;
//            for (WebElement tr : tableListTr) {
//                List<WebElement> listTd = tr.findElements(By.xpath("td"));
//                for (WebElement td : listTd) {
//                    if (td.getText().contains(item)) {
//                        actualBrand.add(td.getText());
//                        itemFound = true;
//                        break;
//                    }
//                }
//            }
//            if (actualBrand.contains(expectedBrands)) {
//                System.out.println("true");
//            } else {
//                System.out.println("False");
//            }
//        }