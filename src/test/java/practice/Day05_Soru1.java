package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day05_Soru1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //  2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //  3. Login alanine “username” yazdirin
        WebElement logIn =driver.findElement(By.xpath("//input[@id='user_login']"));
        logIn.sendKeys("username");

        //  4. Password alanine “password” yazdirin
        WebElement password =driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");

        //  5. Sign in buttonuna tiklayin
        WebElement sıgnIn =driver.findElement(By.xpath("//input[@value='Sign in']"));
        sıgnIn.click();

        //  6. Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();


        //  7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount=driver.findElement(By.xpath("//input[@id='sp_amount']"));
        amount.sendKeys("5000",Keys.ENTER);

        //  8. tarih kismina “2020-09-10” yazdirin
        WebElement date =driver.findElement(By.xpath("//input[@id='sp_date']"));
        date.sendKeys("2020-09-14");

        //  9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //  10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        WebElement payment =driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        if (payment.isDisplayed()){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
