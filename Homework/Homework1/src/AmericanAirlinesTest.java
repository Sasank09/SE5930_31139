/**
 * Homework 1: Every instruction should be controlled by using Selenium
 * 1. Go to the aa.com website
 * 2. select the "One way" option
 * 2. select the city or airport for "from" and "to" locations (don't use "sendkeys")
 * 3. change the number of passengers (not 1)
 * 4. Select a departure date  (you can use "sendkeys")
 * 5. click the "search" button
 *
 * @Author: Venkata Lakshmi Sasank Tipparaju (700738838)
 */

// import the required libraries for the assignment
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AmericanAirlinesTest {
    public static void main(String[] args) throws InterruptedException {
        //initialized threadSleepTime variable to delay action for every step
        long threadSleepTime = 2000;
        System.out.println("Welcome to Homework 1- AmericanAirline Site Testing");

        //set webdriver property to desired browser(Chrome) for automation test
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
        //Initialize the chromeDriver instance to test aa.com in Chrome Browser
        WebDriver driver = new ChromeDriver();

        //Resize current window to the set dimension
        driver.manage().window().maximize();
        //driver.get() method is used to open or navigate a URL & it will wait till the whole page gets fully loaded.
        driver.get("https://aa.com");

        //set implicit wait timeout to 5 seconds
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Current URL: " + driver.getCurrentUrl());

        //create actions instance with the driver to perform mouseEvent actions
        Actions actions = new Actions(driver);

        //Thread.sleep to delay next action in milliseconds
        Thread.sleep(threadSleepTime);
        //Click the 'ONE WAY' option radio button
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\'flightSearchForm.tripType.oneWay\']"))).click().build().perform();


        Thread.sleep(threadSleepTime);
        //Performing click action on Reservation 'FROM' field search icon
        driver.findElement(By.xpath("//*[@id=\'reservationFlightSearchForm\']/div[3]/div[1]/div/a")).click();

        Thread.sleep(threadSleepTime);
        //Select the 'FROM COUNTRY' from dropdown and select "US" using SELECT instance
        Select countryDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"countryCode\"]")));
        countryDropDown.selectByValue("US");

        Thread.sleep(threadSleepTime);
        //Select the 'FROM STATE' from dropdown and select "MO - Missouri" using SELECT instance
        Select stateDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"stateCode\"]")));
        stateDropDown.selectByValue("MO");

        Thread.sleep(threadSleepTime);
        //Perform click action on the listed airports - CGI
        driver.findElement(By.xpath("//*[@id=\"airport_CGI\"]")).click();

        Thread.sleep(threadSleepTime);
        //Performing click action on 'TO' field search icon
        driver.findElement(By.xpath("//*[@id=\"reservationFlightSearchForm\"]/div[3]/div[2]/div/a")).click();

        Thread.sleep(threadSleepTime);
        //Select the 'TO COUNTRY' from dropdown and select "US - Missouri" using SELECT instance
        countryDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"countryCode\"]")));
        countryDropDown.selectByValue("US");

        Thread.sleep(threadSleepTime);
        //Select the "TO STATE" from dropdown and select "IL - Illionis" using SELECT instance
        stateDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"stateCode\"]")));
        stateDropDown.selectByValue("IL");

        Thread.sleep(threadSleepTime);
        //Perform click action on the listed airports - BMI
        driver.findElement(By.xpath("//*[@id=\"airport_BMI\"]")).click();

        Thread.sleep(threadSleepTime);
        //Select No. of passengers using SELECT dropdown instance and set value to 4
        Select noOfPassengers = new Select(driver.findElement(By.xpath(" //*[@id=\"flightSearchForm.adultOrSeniorPassengerCount\"]")));
        noOfPassengers.selectByValue("4");

        Thread.sleep(threadSleepTime);
        //using sendKeys set Departure date
        driver.findElement(By.xpath("//*[@id=\"aa-leavingOn\"]")).sendKeys("06/22/2023");

        Thread.sleep(threadSleepTime);
        //Perform click action to search flights with provided details
        driver.findElement(By.xpath("//*[@id=\"flightSearchForm.button.reSubmit\"]")).click();

        Thread.sleep(120000);
        //close the driver connection after 120 seconds
        driver.close();

    }
}
