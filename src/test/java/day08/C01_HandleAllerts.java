package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleAllerts {


    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01() throws InterruptedException {
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click for JS Alert butonuna tıklayalım
        WebElement alert=driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        alert.click();
        Thread.sleep(2000);
        // Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        // Confirm butonuna tıklayalım
        WebElement confirm=driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirm.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
    }
    @After
    public void tearDown() {
        driver.close();
    }
}
