package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {

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
    public void test1(){

    // Bir class olusturun: IframeTest
    // https://the-internet.herokuapp.com/iframe adresine gidin.
    // Bir metod olusturun: iframeTest

        driver.get("https://the-internet.herokuapp.com/iframe");

        //  ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi=driver.findElement(By.xpath("//h3['An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());

        //  ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(textBox);
        WebElement textBoxFrame= driver.findElement(By.xpath("//p"));
        textBoxFrame.clear();
        textBoxFrame.sendKeys("\"Merhaba Dunya\"");

        //  ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //    dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        WebElement elemantalSel=driver.findElement(By.xpath("//a[@href=\"http://elementalselenium.com/\"]"));
        Assert.assertTrue(elemantalSel.isDisplayed());
        System.out.println(elemantalSel.getText());


    }
}
