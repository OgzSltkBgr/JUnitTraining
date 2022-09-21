package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExists extends TestBaseBeforeClassAfterClass {
    // Tests packagenin altina bir class oluşturalim : C04_FileDownload
    //Iki tane metod oluşturun : isExist( ) ve downloadTest( )
    //downloadTest ( ) metodunun icinde aşağıdaki testi yapalim:
    //https://the-internet.herokuapp.com/download adresine gidelim.
    //test.txt dosyasını indirelim
    //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void isExists() {
        String dosyaYolu="C:\\Users\\pc\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void downloadTest() {
        driver.get("https://the-internet.herokuapp.com/download");
        //driver.findElement(By.xpath("//*[text()='test.txt']")).click();



    }
}
