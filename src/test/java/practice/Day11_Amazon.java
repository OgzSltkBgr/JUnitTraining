package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeAfter;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.List;

public class Day11_Amazon extends TestBaseBeforeClassAfterClass {
    @Test
    public void test01() throws InterruptedException {
    driver.get("https://amazon.com");
    WebElement actionsGo=driver.findElement(By.id("nav-link-accountList-nav-line-1"));
     Actions actions=new Actions(driver);
     actions.moveToElement(actionsGo).perform();


     driver.findElement(By.xpath("//span[text()='Music Library']")).click();
         Thread.sleep(2000);
     WebElement library=driver.findElement(By.id("contextMenuHoverButton"));
     actions.moveToElement(library).perform();

     Thread.sleep(2000);
     WebElement music=driver.findElement(By.xpath("//*[@id='contextMenuOption1']"));
     music.click();

     driver.navigate().back();
     driver.navigate().refresh();
     Thread.sleep(2000);
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));

        Select select= new Select(ddm);

        select.selectByVisibleText("Computers");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("imac", Keys.ENTER);
        WebElement ilkUrun=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
        String windowHandleIlkSayfa=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        List<String> windowList= new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windowHandleIlkSayfa);
        ilkUrun.click();

        driver.switchTo().window(windowList.get(1));

        driver.get("https://mackolik.com");


    }


}
