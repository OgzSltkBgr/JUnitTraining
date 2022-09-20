package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C03_Action extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");
        Actions actions=new Actions(driver);
        WebElement nav = driver.findElement(By.cssSelector("#nav-link-accountList"));
        actions.moveToElement(nav).perform();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();
    }
}
