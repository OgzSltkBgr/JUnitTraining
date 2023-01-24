package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class M02_TumSayfaScreenShoot extends TestBaseBeforeAfter {
    @Test
    public void tumSayfa() throws IOException {
        //amazon sayfasına gidin tum sayfanın fotografini cekin

        driver.get("https://amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;

        File tumSayfaResim = new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,tumSayfaResim);


    }
}
