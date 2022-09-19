package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class Day08_2Dd {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void method() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement ilkButon=driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        ilkButon.click();
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        WebElement confirm=driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirm.click();
        System.out.println(driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        WebElement prompt=driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        prompt.click();
        driver.switchTo().alert().sendKeys("oguz");


    }
    @After
    public void tearDown(){
        //driver.quit();
    }
}
