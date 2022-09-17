package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Test {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void method1() throws InterruptedException {
        //      a. Verilen web sayfasına gidin.
        //      https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        Thread.sleep(3000);
        //      b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement chechbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement chechbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Thread.sleep(3000);
        //      c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if(!chechbox1.isSelected()){
            chechbox1.click();
        }

        Thread.sleep(3000);
        //      d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if(!chechbox2.isSelected()){
            chechbox2.click();
        }


    }
    @After
    public void tearDown(){
        driver.close();
    }

}
