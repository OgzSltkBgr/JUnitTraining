package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class Odev1 extends TestBaseBeforeAfter {
    @Test
    public void test1() {

        //https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();

        //Username : manager  ○ Password : Manager2!
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("Manager2!",Keys.ENTER);

        //table( ) metodu oluşturun
        //Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        //Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        //printRows( ) metodu oluşturun //tr
        //table body’sinde bulunan toplam satir(row) sayısını bulun.
        //Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        //4.satirdaki(row) elementleri konsolda yazdırın.
        //printCells( ) metodu oluşturun //td
        //table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        //Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        //printColumns( ) metodu oluşturun
        //table body’sinde bulunan toplam sutun(column) sayısını bulun.
        //Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        //5.column daki elementleri konsolda yazdırın.
    }

}
