package day08;

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

public class C02_Allerts {
    /*
bir web sitesine girdigimizde karsımıza bir uyarı mesajı yada bir buttona tıkladığımızda bir uyarı cıkabilir
eğer bu uyarıya incele(mause sağ-tik inspect) yapabiliyorsak bu tür alert lere html alert denir.
ve istedigimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdahale (sağ tik inspect ile) edemiyorsak
bu tür alertlere  js alert denir.
js alert'lere müdahale edebilmek icin

-- tamam ya da ok icin
driver.switchTo().alert().accept();

--iptal icin
driver.switchTo().alert().dismiss();

--alert icindeki mesajı almak icin
driver.switchTo().alert().getText();

--alert bizden bir metin istiyorsa
driver.switchTo().alert().sendKeys("");

methodları kullanilir!!

 */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
        // Bir class olusturun: Alerts
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        WebElement ilkButon=driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        ilkButon.click();

        driver.switchTo().alert().accept();

        WebElement mesaj=driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
        String expectedMessage= "You successfully clicked an alert";
        Assert.assertEquals(mesaj.getText(),expectedMessage);


    }
    @Test
    public void dismissAlert() throws InterruptedException {
        //2. butona tıklayın,
        WebElement confirm=driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        confirm.click();
        Thread.sleep(2000);

        // Alert üzerindeki mesajı yazdırın
        System.out.println(driver.switchTo().alert().getText());

        // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        //result mesajının “successfuly” icermedigini test edin.

        WebElement actualMessage=driver.findElement(By.xpath("//p[text()='You clicked: Cancel']"));
        String expectedMessage="successfuly";

        Assert.assertFalse(actualMessage.getText().contains(expectedMessage));


    }
    @Test
    public void sendKeysAlert(){
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın,
        WebElement prompt=driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        prompt.click();

        // uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın

        driver.switchTo().alert().sendKeys("oguz");
        driver.switchTo().alert().accept();

        WebElement actualMessage=driver.findElement(By.xpath("//p[text()='You entered: oguz']"));
        String expectedMessage="oguz";
        Assert.assertTrue(actualMessage.getText().contains(expectedMessage));

    }

    @After
    public void teardown(){
        driver.close();
    }
}
