package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforeAfter;
import java.io.File;
import java.io.IOException;

public class M03_IstenenWebElementSS extends TestBaseBeforeAfter {
    @Test
    public void webElementSS() throws IOException {
        // amazon a gidip nutella aratalim
        // Ilk urunun oldugu web elementin fotografının cekelim

        driver.get("https://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella", Keys.ENTER);

        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[1]"));

        //TakesScreenshot ts = (TakesScreenshot) driver;

        File ilkUrunSS = new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");

        File geciciResim = ilkUrun.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,ilkUrunSS);
    }
}
