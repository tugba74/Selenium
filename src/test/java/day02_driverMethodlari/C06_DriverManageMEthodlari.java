package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverManageMEthodlari {

    public static void main(String[] args) {

        System.setProperty("webdriver.chorme.driver", "src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //implicitlyWait gittiğimiz sayfa açılıncaya veya aradığımız webelement bulununcaya kadar
        // driverın bekleyebileceği maximum süreyi belirler

        //Bu dörtlü her test methodunun başına yazılacak.

    }
}
