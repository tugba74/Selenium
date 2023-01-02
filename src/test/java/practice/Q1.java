package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    /*...Exercise1...
    Create a new class under Q1 create main method
    Set Path
    Create chrome driver
    Maximize the window
    Open google home page https://www.google.com/.
    On the same class, Navigate to amazon home page https://www.amazon.com/
    Navigate back to google
    Navigate forward to amazon
    Refresh the page
    Close/Quit the browser
    And last step : print "All Ok" on console
     */

        //1- Create a new class under Q1 create main method
         public static void main(String[] args) throws InterruptedException {

        //2-Set Path, Create chrome driver, Maximize the window

         System.setProperty("webdriver chrome driver","src/drivers/chromedriver.exe");
         WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //işlem için max 15 sn boyunca şu işlemi
                                                                            // yapmayı dene olmazsa bırak
        //3-Open google home page https://www.google.com/.
          driver.get("https://www.google.com/");
          Thread.sleep(1000);
        // 4-On the same class, Navigate to amazon home page https://www.amazon.com/
          driver.navigate().to("https://www.amazon.com/");
          Thread.sleep(1000);
        //5- Navigate back to google
          driver.navigate().back();
          Thread.sleep(1000);
        //6- Navigate forward to amazon
          driver.navigate().forward();
          Thread.sleep(1000);
        //7- Refresh the page
          driver.navigate().refresh();
          Thread.sleep(1000);
        //8- Close/Quit the browser close sadece olduğu sekmeyi kapatır, quit tüm page i kapatır.
          driver.quit();
        //9-And last step : print "All Ok" on console
          System.out.println("All Ok");

    }

}
