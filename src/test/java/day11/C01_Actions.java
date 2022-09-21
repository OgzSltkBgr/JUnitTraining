package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeClassAfterClass;

public class C01_Actions extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1(){
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        Actions actions = new Actions(driver);
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").
                sendKeys("A").
                sendKeys("7").
                sendKeys("1").perform();
        //aramanin gerceklestigini test edin
        WebElement aramaSonucu=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        Assert.assertTrue(aramaSonucu.isDisplayed());
    }
}
