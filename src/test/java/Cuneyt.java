

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Cuneyt {
    WebDriver driver;
    @Test
    public void test01() throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homeTusu = driver.findElement(By.xpath("//*[text()=\" Home\"]"));
        Assert.assertTrue(homeTusu.isDisplayed());
        //4. Click on 'Signup / Login' button
        WebElement singUp = driver.findElement(By.xpath("//*[text()=\" Signup / Login\"]"));
        singUp.click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=\"Login to your account\"]")).isDisplayed());
        //6. Enter correct email address and password
        WebElement email = driver.findElement(By.xpath("//*[@data-qa='login-email']"));
        email.sendKeys("kullanici1234@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@data-qa='login-password']"));
        password.sendKeys("password");
        //7. Click 'login' button
        WebElement login = driver.findElement(By.xpath("//*[@data-qa='login-button']"));
        login.click();
        //8. Verify that 'Logged in as username' is visible
        WebElement loginas = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assert.assertTrue(loginas.isDisplayed());
        //9. Click 'Delete Account' button
        WebElement delete = driver.findElement(By.xpath("//*[text()=' Delete Account']"));
        delete.click();
        Thread.sleep(2000);
        WebElement iframe = driver.findElement(By.xpath("//*[@id='aswift_1']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        WebElement closeButton = driver.findElement(By.xpath("//*[@class='btn skip']"));
        closeButton.click();
       // driver.findElement(By.xpath("//*[@class='ns-v58k3-e-14 button-common close-button']")).click();

        //10. Verify that 'ACCOUNT DELETED!' is visible
    }


    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void close(){
        // driver.close();
    }
}