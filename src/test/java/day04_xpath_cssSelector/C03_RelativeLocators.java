package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C03_RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver chorme driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        //2 ) Berlin’i 3 farkli relative locator ile locate edin

        //sailor'ın ustundeki diyelim
        WebElement sailorElementi=driver.findElement(By.xpath("//p[text()='Sailor']"));
        WebElement berlin1= driver.findElement(RelativeLocator.with(By.tagName("img")).above(sailorElementi));

        //Boston'ın sağındaki diyelim
        WebElement bostonElementi=driver.findElement(By.xpath("//p[text()='Boston']"));
        //tarif etmek ıstediğiniz web elementin bir özelliğini kullanmalısınız
        //ornegin tagName=img

        WebElement berlin2=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElementi));

         //C- NYC'nin altındaki diyelim

        WebElement nyc=driver.findElement(By.xpath("//p[text()='NYC']"));
        WebElement berlin3=driver.findElement(RelativeLocator.with(By.tagName("img")).below(nyc));

        //eğer bir tane element'den tarif ettiğimizde yine de bulamazsak
        //birden fazla elementi refere edebiliriz.

        WebElement berlin4=driver.findElement(RelativeLocator.with(By.tagName("img"))
                .below(nyc)
                .toRightOf(bostonElementi)
                .above(sailorElementi));


        //3 ) Relative locator’larin dogru calistigini test edin
        // id'si pid7_thumb oldugunu test edelim

        String expectedIdDegeri="id'si pid7_thumb";
        String actualIdDegeri=berlin1.getAttribute("Id");

        if (expectedIdDegeri.equals(actualIdDegeri)) {
            System.out.println("Relative locator testi PASSED");
        }else{
            System.out.println("Relative locator testi FAILED");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
