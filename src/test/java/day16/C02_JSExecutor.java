package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C02_JSExecutor extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        //Aşağıdaki carrers butonun görünceye kadar js ile scroll yapalım

        WebElement careers=driver.findElement(By.xpath("//*[text()='Careers']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true);",careers);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));




        //Carrers butonuna js ile click yapalım
        js.executeScript("arguments[0].click()",careers);
        //careers.click();

    }
}
