package day15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class M04_JS_Executor extends TestBaseBeforeAfter {
    @Test
    public void JSExecutorTest() {
        // amazona gidelim
        driver.get("https://amazon.com");

        // aşağıdaki sign in butonu görünene kadar js ile scrool yapalim
        WebElement signInButton=driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",signInButton);

        // sign in butonuna js ile click yapalım
        js.executeScript("arguments[0].click()",signInButton);
    }
}
