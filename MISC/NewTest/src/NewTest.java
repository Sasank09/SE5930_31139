import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.InterruptedIOException;

public class NewTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello Selenium");
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://facebook.com");

        System.out.println("URL: "+driver.getCurrentUrl());
        Thread.sleep(1000);
        driver.get("http://ucmo.edu");
        driver.navigate().back();
    }
}
