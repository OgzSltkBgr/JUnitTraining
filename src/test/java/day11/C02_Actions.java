package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_Actions extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() {
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isim =driver.findElement(By.xpath("//input[@name='firstname']"));
        isim.sendKeys("Osbt");
        actions.sendKeys(Keys.TAB).
                sendKeys("Cimbom").
                sendKeys(Keys.TAB).
                sendKeys("osbt@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("osbt@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("123456").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Oca").
                sendKeys(Keys.TAB).
                sendKeys("2000").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
               sendKeys(Keys.TAB).
               sendKeys(Keys.TAB).
               sendKeys(Keys.TAB).
               sendKeys(Keys.TAB).
               sendKeys(Keys.TAB).sendKeys(Keys.ENTER).
                perform();

        // 4- Kaydol tusuna basalim
    }
}
