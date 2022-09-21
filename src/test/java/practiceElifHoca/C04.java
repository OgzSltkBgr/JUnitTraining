package practiceElifHoca;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04 {
    /* note:
    JavaScriptExecutor  nedir?
    JavaScriptExecutor, JavaScript'i Selenium Web sürücüsü araciligiyla calistirmaya yardimci olan bir arayuzdur.
    JavaScriptExecutor, javascript'i secilen pencerede veya gecerli sayfada calistirmak icin "executescript" ve "executeAsyncScript"
    olmak uzere iki yontem sunar.

    JavaScriptExecutor'a neden ihtiyacimiz var?
    Selenium Webdriver'da, bir web sayfasindaki islemleri tanimlamak ve gerceklestirmek icin
    XPath,CSS vb. gibi konum belirliyiciler kullanilir.
    Bu konum belirliyicilerin calismamasi durumunda JavaScriptExecutor'i kullanabilirsiniz.
    Bir web ogesinde istenen bir islemi gerceklestirmek icin JavaScriptExecutor'i kullanabilirsiniz
    Selenium javaScriptExecutor'i destekler.Ekstra bir eklenti veya eklentiye gerek yoktur.
    JavaScriptExecutor kullanmak icin komut dosyasinda(org.openqa.selenium.JavascriptExecutor) ice aktarmaniz yeterlidir.
          executeScript araciligiyla sayfayi 1000 piksel kaydirin.
          Javascript yontemi ScrollBy(), web sayfasini belirli piksel sayisina kaydirir.

          ScrollBy()  yontemlerinin sozdizimi soyledir:
          executeScript("window.scrollBy(x-piksel,y-piksel)"); ya da js.executeScript("scroll(x,y);");
          x-piksel x eksenindeki sayidir,sayi pozitifse sola,sayi negatifse saga hareket eder.
          y-piksel y eksenindeki sayidir,sayi pozitifse asagidogru,sayi negatifse yukari dogru hareket eder.

          Ornek:
          js.executeScript("window.scrollBy(0,1000)");  // Dikey olarak 1000 piksel asagi kaydir.
     */
    /*=====================================================================================================================================================*/
    // ...Exercise4...

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().deleteAllCookies();

        // https://www.teknosa.com/ adresine gidiniz
        driver.get("https://teknosa.com");


        // Search box senKeys "oppo" and keys Enter
        WebElement searchBox =driver.findElement(By.xpath("//button[@class='search-button js_search_button sbx-fake btn-search']"));
        searchBox.click();
        //driver.switchTo().alert().dismiss();
        searchBox.sendKeys("oppo", Keys.ENTER);

        // sonuc sayisini yazdiriniz
        System.out.println(driver.findElement(By.xpath("//div[@class='plp-info']")).getText());

        // cikan ilk urune tiklayiniz
        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,200)");

        // sepete ekleyiniz
        // sepetime git 'e tiklayiniz
        // consaol'da "Siparis Özeti" webelementinin text'ini yazdiriniz
        // Alisverisi tamamlayiniz
        // son olarak da "Teknosa'ya hos geldiniz" webelementinin text 'ini yazdiriniz
        // driver'i kapatiniz






    }
}
