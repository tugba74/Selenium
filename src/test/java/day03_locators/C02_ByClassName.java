package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_ByClassName {
    public static void main(String[] args) throws InterruptedException {
        //amazona gidip nutella için arama yapın.
        //ilk sayfada çıkan urunlerin icerisinde
        // en yuksek fiyatı bulun

        System.setProperty("webdriver.chrome.driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchteztbox"));
        aramaKutusu.sendKeys("Nutella" +Keys.ENTER);

        List<WebElement> fiyatlarListesi=driver.findElements(By.className("a-price-whole"));

        // WebElement bir obje oldugundan, direkt yazdırılamaz
        System.out.println(fiyatlarListesi);

        //
        //

        for (WebElement each: fiyatlarListesi
         ) {

            System.out.print(each.getText() + " ");

        }
        //en yuksewk fiyatı bulabilmek için java bilgimizi kullanmalıyız
        //1-web elementlerden getText ile fiyatı String olarak alın
        // 2- string fiyatı kıyaslama yapabilmek için integera cevirin
        // 3- en yuksek fiyatı bulup yazdırın.


        String fiyatStr;
        Integer fiyatInt;
        Integer enYuksekFiyat=0;
        for (WebElement each: fiyatlarListesi){

            fiyatStr=each.getText();
            fiyatInt=Integer.parseInt(fiyatStr);
            if (fiyatInt>enYuksekFiyat){
                enYuksekFiyat=fiyatInt;
            }
            System.out.println("");
            System.out.println("En yuksek urun fiyati :" +enYuksekFiyat);

        }


        Thread.sleep(3000);
        driver.close();
    }
}
