package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C02_FileExistsUpload extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // Tests packagenin altina bir class oluşturun : C05_UploadFile
        //  https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //  chooseFile butonuna basalim/ //  Yuklemek istediginiz dosyayi secelim.
        WebElement chooseFile=driver.findElement(By.xpath("//*[@id='file-upload']"));
        String dosyaYolu ="C:\\Users\\pc\\OneDrive\\Masaüstü\\Yeni Metin Belgesi.txt";
        chooseFile.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@class='button']")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
        WebElement fileuploadf= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(fileuploadf.isDisplayed());
    }

}
