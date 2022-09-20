package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {
    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        // 3- Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziliAlan).perform();


        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
       String actualAllert=driver.switchTo().alert().getText();
       String expectedAllert="You selected a context menu";
       Assert.assertEquals(expectedAllert,actualAllert);
       Thread.sleep(2000);

       //Tamam diyerek alert’i kapatalim
       driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);


       //Elemental Selenium linkine tiklayalim
       driver.findElement(By.xpath("(//a)[2]")).click();
       List<String>windowList= new ArrayList<String>(driver.getWindowHandles());
       driver.switchTo().window(windowList.get(1));

       //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
      // driver.switchTo().window(driver.getWindowHandles());
      // driver.findElement(By.xpath("//h1['Elemental Selenium']")).click();
       String actualElemantalSel=driver.findElement(By.xpath("//h1['Elemental Selenium']")).getText();
       String expectedElemantalSel="Elemental Selenium";
       Assert.assertEquals(actualElemantalSel,expectedElemantalSel);
    }
}
