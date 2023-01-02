package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver chorme driver","src/drivers/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin

        driver.get ("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        WebElement addElement=driver.findElement(By.xpath("//*[text()='Add Element']"));
        addElement.click();
        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu=driver.findElement(By.xpath("//*[text()='Add Element']"));

        if (deleteButonu.isDisplayed()) {
            System.out.println("Delete butonu görüntüleme testi PASSED");
        }else {
            System.out.println("Delete butonu görüntüleme testi FAILED");
        }

        //4- Delete tusuna basin
        deleteButonu.click();
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveYaziElementi= driver.findElement(By.xpath("//*[text()='Add Element']"));
        if (addRemoveYaziElementi.isDisplayed()) {
            System.out.println("Add/remove yazı testi PASSED");
        }else{
            System.out.println("Add/remove yazı testi FAILED");
        }


        Thread.sleep(3000);
        driver.close();
        /*
        sorunsuz çalıştı 1. hatanız ilk tıklama olayında webelement oluşturmadığınız için elementin görününmesi için gerekli
        süreyi beklemiyor direk tıklamaya çalışıyor
        2. hatanız xpath kopyalarken '' işaretlerini düzeltmeniz gerekiyor
         */
    }
}
