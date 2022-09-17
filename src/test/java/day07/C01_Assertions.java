package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01(){
        //http://automationpractice.com/index.php adresine gidelim
        driver.get("http://automationpractice.com/index.php");

        // Sig in butonuna basalım
        driver.findElement(By.xpath("//*[@class='login']")).click();

        // Email kutusuna @ işareti olmayan bir mail yazıp enter a basın
        WebElement emailKutusu = driver.findElement(By.xpath("//*[@id='email_create']"));
        emailKutusu.sendKeys("osbt.gmail.com", Keys.ENTER);

        //
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
