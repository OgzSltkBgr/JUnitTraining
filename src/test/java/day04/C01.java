package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1- https://www.amazon.com/ sayfasina gidelim
        driver.get("https://amazon.com");

        //       2- arama kutusunu locate edelim
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));

        //       3- “Samsung headphones” ile arama yapalim

        searchBox.sendKeys("Samsung headfones", Keys.ENTER);


        //       4- Bulunan sonuc sayisini yazdiralim
        List<WebElement> sonucSayisi = driver.findElements(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucSayisiS=sonucSayisi.get(0).getText();

        String [] sonucSayisiArr = sonucSayisiS.split(" ");
        System.out.println(sonucSayisiArr[2]);


        //       5- Ilk urunu tiklayalim
       WebElement ilkUrun= driver.findElement(By.xpath("(//img[@src='https://m.media-amazon.com/images/I/61xTy482IpL._AC_UY218_.jpg'])[1]"));
       ilkUrun.click();

        //       6- Sayfadaki tum basliklari yazdiralim
        WebElement sayfadakiBasliklar=driver.findElement(By.id("nav-xshop-container"));
        System.out.println(sayfadakiBasliklar.getText());
    }
}
