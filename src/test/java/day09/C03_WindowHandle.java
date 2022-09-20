package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_WindowHandle {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown() {
        //driver.close();
    }
    @Test
    public void test01(){

        //    Amazon anasayfa adresine gidin.
        driver.get("https://amazon.com");

        //    Sayfa’nin window handle degerini String bir degiskene atayin
        String windowHandleAmazon=driver.getWindowHandle();

        //    Sayfa title’nin “Amazon” icerdigini test edin
        String  actualTitleAmazon=driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actualTitleAmazon.contains(expectedTitle));

        //    Yeni bir tab olusturup, acilan tab’da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://techproeducation.com");

        //    Sayfa title’nin “TECHPROEDUCATION” icerdigini test edin
        String actualTitleTech=driver.getTitle();
        String expectedTitleTech="TECHPROEDUCATION";
        Assert.assertFalse(actualTitleTech.contains(expectedTitleTech));

        //    Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://walmart.com");

        //    Sayfa title’nin “Walmart” icerdigini test edin
        String actualTitleWalmart=driver.getTitle();
        String expectedTitleWalmart="Walmart";
        Assert.assertTrue(actualTitleWalmart.contains(expectedTitleWalmart));

        //    Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin
        driver.switchTo().window(windowHandleAmazon);
        WebElement amazonLogo=driver.findElement(By.xpath("//*[@class='nav-logo-link nav-progressive-attribute']"));
        Assert.assertTrue(amazonLogo.isDisplayed());
    }
}
