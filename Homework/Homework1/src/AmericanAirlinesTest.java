import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmericanAirlinesTest {
    public static void main(String[] args) {
        System.out.println("Welcome to Homework 1- AmericanAirline Site Testing");
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://aa.com");
        System.out.println("Current URL: "+driver.getCurrentUrl());

    }
}
