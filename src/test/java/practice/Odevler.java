package practice;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;
import utilities.TestBaseBeforeClassAfterClass;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class Odevler extends TestBaseBeforeAfter{
    @Test
    public void test1()  {
       /*
      Ödev 1
"http://webdriveruniversity.com/Actions" sayfasina gidin
"Hover over Me First" kutusunun ustune gelin
"Link 1" e tiklayin
Popup mesajini yazdirin
Popup'i tamam diyerek kapatin
"Click and hold" kutusuna basili tutun
"Click and hold" kutusunda cikan yaziyi yazdirin
"Double click me" butonunu cift tiklayin
     */
        //"http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //"Hover over Me First" kutusunun ustune gelin

        //"Link 1" e tiklayin

        //Popup mesajini yazdirin

        //Popup'i tamam diyerek kapatin

        //"Click and hold" kutusuna basili tutun

        //"Click and hold" kutusunda cikan yaziyi yazdirin

        //"Double click me" butonunu cift tiklayin

    }
    @Test
    public void test2() throws InterruptedException {
        /*
        Ödev 2
"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
"Our Products" butonuna basin
"Cameras product"i tiklayin
Popup mesajini yazdirin
"close" butonuna basin
"WebdriverUniversity.com (IFrame)" linkini tiklayin
"http://webdriveruniversity.com/index.html" adresine gittigini test edin
         */
        //"http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //"Our Products" butonuna basin

        WebElement ourProductsFrame=driver.findElement(By.cssSelector("#frame"));
        driver.switchTo().frame(ourProductsFrame);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();


        //"Cameras product"i tiklayin
        driver.findElement(By.xpath("(//p)[2]")).click();

        //Popup mesajini yazdirin
        WebElement popUp=driver.findElement(By.xpath("//*[@class='modal-body']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='modal-body']")));

        System.out.println("popUp.getText() = " + popUp.getText());

        //"close" butonuna basin
        driver.findElement(By.xpath("//*[text()='Close']")).click();

        //"WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()='WebdriverUniversity.com (IFrame)']")).click();

        //"http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String actualURL=driver.getCurrentUrl();
        String expectedURL="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(expectedURL,actualURL);

    }
    @Test
    public void test3() {
        /*
        Ödev 3
1."http://webdriveruniversity.com/" adresine gidin
2."Login Portal" a  kadar asagi inin
3."Login Portal" a tiklayin
4.Diger window'a gecin
5."username" ve  "password" kutularina deger yazdirin
6."login" butonuna basin
7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
8.Ok diyerek Popup'i kapatin
Ilk sayfaya geri donun
Ilk sayfaya donuldugunu test edin
   */
        //1."http://webdriveruniversity.com/" adresine gidin

        //2."Login Portal" a  kadar asagi inin

        //3."Login Portal" a tiklayin

        //4.Diger window'a gecin

        //5."username" ve  "password" kutularina deger yazdirin
        //username

        //password

        //6."login" butonuna basin

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin

        //8.Ok diyerek Popup'i kapatin

        //Ilk sayfaya geri donun

        //Ilk sayfaya donuldugunu test edin

    }
}
