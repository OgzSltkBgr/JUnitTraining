package practiceMuratHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

public class C01_LoginTest extends TestBaseBeforeClassAfterClass {
    //https://www.koalaresorthotels.com/ sayfasına gidiniz.
    @Test
    public void test1(){
        driver.get("https://www.koalaresorthotels.com/");

        //Login butonuna tıklayınız
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
    }

}
