package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_locators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.ramazon.com");
        // WebElement giftCardLinki =driver.findElement(By.linkText("Today's Deals"));

        Thread.sleep(4000);
        WebElement giftCardLinki=driver.findElement(By.partialLinkText("Gift"));
        giftCardLinki.click();

        //istenen sayfaya gittiğini test etmek için
        //title'ın Gift Carrd icerdiğini test edebiliriz

        String expectedKelime="Gift Cards";
        String actualTitle=driver.getTitle();

        if(actualTitle.contains(expectedKelime)) {
            System.out.println("Gift Cards testi PASSED");
        }else{
            System.out.println("Gift Cards testi FAILED");

        }
    }
}
