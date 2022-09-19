package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Day08_1 {
WebDriver driver;
@Before
    public void setup(){
    WebDriverManager.chromedriver().setup();
    driver= new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    driver.get("https://trendyol.com");
}
@Test
public void test() throws InterruptedException {
    System.out.println("Test calisti");
    WebElement acceptButton =driver.findElement(By.xpath("//*[text()='KABUL ET']"));
    acceptButton.click();
    Thread.sleep(2000);
    //driver.switchTo().alert().dismiss();
    WebElement searchBox=driver.findElement(By.xpath("//input[@class='search-box']"));
    searchBox.sendKeys("Kaban", Keys.ENTER);

    // Cinsiyeti erkek seç
    WebElement menCheckBox=driver.findElement(By.xpath("(//div[@class='chckbox'])[2]"));
    menCheckBox.click();

    // Marka Bershka seç
    WebElement markaDd=driver.findElement(By.xpath("(//div[@class='i-dropdown-arrow'])[3]"));
   // Select select = new Select(markaDd);
   // select.selectByIndex(5);
    markaDd.click();
    WebElement markaSearchBox=driver.findElement(By.xpath("//*[@class='fltr-srch-inpt']"));
    markaSearchBox.sendKeys("Bershka");
    driver.findElement(By.xpath("(//*[@class='chckbox'])[3]")).click();

    // Urun seç
    driver.findElement(By.xpath("(//div[@class='image-overlay-body'])[2]")).click();


}
@After
    public void teardown() throws InterruptedException {
    Thread.sleep(2000);
    //driver.close();
}
}
