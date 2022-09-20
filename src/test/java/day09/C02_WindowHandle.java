package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {

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
    public void test01() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("https://amazon.com");
        String amazonWH=driver.getWindowHandle();
        Thread.sleep(2000);

//2- Url'nin amazon içerdiğini test edelim
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="amazon";

        Assert.assertTrue(actualUrl.contains(expectedUrl));

//3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWH=driver.getWindowHandle();
        Thread.sleep(2000);

//4- title'in BestBuy içerdiğini test edelim
        String actualTitle=driver.getTitle();
        String expectedTitle="Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Thread.sleep(2000);

//5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWH);
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("java", Keys.ENTER);
        Thread.sleep(2000);

//6- Arama sonuclarının java içerdiğini test edelim
        WebElement java=driver.findElement(By.xpath("//*[text()='\"java\"']"));
        String expectedResult="java";
        Assert.assertTrue(java.getText().contains(expectedResult));
        Thread.sleep(2000);

//7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWH);
        Thread.sleep(2000);

//8- Logonun görünürlüğünü test edelim
        WebElement bestBuyLogo= driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(bestBuyLogo.isDisplayed());
        Thread.sleep(2000);

//9- Sayfaları Kapatalım
        driver.quit();
    }
}
