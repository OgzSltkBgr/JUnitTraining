package practiceMehmetHoca;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        driver.switchTo().frame("emoojis");

        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement secondEmoji = driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        secondEmoji.click();

        // tüm hayvan emojilerine tıklayın
        List<WebElement> emojiOgeler= driver.findElements(By.xpath("//div[@id='nature']/div/img"));
        emojiOgeler.forEach(x->x.click());

        // formu doldurun (dilediğinizi yazabilirsiniz)
        driver.switchTo().defaultContent();
        List<WebElement>metinList=driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String>metin=new ArrayList<>(Arrays.asList("Türkiyenin","en","büyük","klübü","Galatasaray'ın","harika","forveti","Icardi","Cok iyi degil mi?","",""));

        for (int i = 0; i <metinList.size() ; i++) {
            metinList.get(i).sendKeys(metin.get(i));}

        // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();


    }
}
