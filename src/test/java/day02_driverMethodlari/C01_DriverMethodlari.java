package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMethodlari {
    public static void main(String[] args) throws InterruptedException {

        // Biz browser'lari olusturdugumuz driver sayesinde otomate edebiliyoruz
        // Bunun cn er testn basinda mutlaka driver objesi olusturacagiz
        System.setProperty("webdriver.corome.driver","src/drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.amazon.com");
        //acilan sayfanın baslıgının amozon içerdiğini test edin

        String expectedKelime="amazon";
        String actualResult=driver.getTitle();

        if (actualResult.contains(expectedKelime)) {
            System.out.println("Title testi PASSED");
        }else{
            System.out.println("Title amazon icermiyor, test FAILED");
            System.out.println(driver.getTitle());
        }


         // gittigimiz sayfanın URL'inin http://www.amazon.com/ oldugunu test edin

        String expectedUrl="http://www.amazon.com";
        String actualUrl=driver.getCurrentUrl();


        Thread.sleep(5000);
        driver.close();

    }
}
