package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day13_GenelTekrar {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");
        System.out.println("Sayfa basligi : "+driver.getTitle());
        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        Thread.sleep(1000);
        driver.manage().window().minimize();
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);

        String sayfaBirHandle=driver.getWindowHandle();
        System.out.println("sayfaBirHandle = " + sayfaBirHandle);

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Galatasaray");
        Thread.sleep(1000);
        searchBox.submit();



    }
}
