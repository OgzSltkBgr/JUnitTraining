package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
public class CS_Soru2 {
    // Tarayıcıyı başlatın
    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void teardown() {
        //    driver.close();
    }
    //2. 'http://automationexercise.com' url'sine gidin
    @Test
    public void test1(){
        driver.get("http://automationexercise.com");
    } // Ana sayfanın başarıyla görünür olduğunu doğrulayın
    @Test
    public void test2(){
        WebElement baslik= driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(baslik.isDisplayed());
    }
    //4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
    @Test
    public void test3(){
        driver.findElement(By.xpath("// a[text()=' Signup / Login']")).click();
    }//5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
    @Test
    public void test4(){
        WebElement hesabaGiris= driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(hesabaGiris.isDisplayed());
    } //6. Doğru e-posta adresini ve şifreyi girin
    @Test
    public void test5(){
        WebElement email=driver.findElement(By.xpath("//*[@data-qa='login-email']"));
        email.click();
        email.sendKeys("kayacalis@gmail.com");
        WebElement isim=driver.findElement(By.xpath("//*[@data-qa='login-password']"));
        isim.click();
        isim.sendKeys("aslında");
    }  //7. 'Giriş' düğmesini tıklayın
    @Test
    public void test6(){
      driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
  } //8. 'Kullanıcı adı olarak oturum açıldı' ifadesinin görünür olduğunu doğrulayın
    @Test
    public void test7(){
      WebElement oturum=driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
      Assert.assertTrue(oturum.isDisplayed());
  }
} //9. 'Hesabı Sil' düğmesini tıklayın
//10. 'HESAP SİLİNDİ!' görünür
