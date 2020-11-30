import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;


public class projectThreeTestCode {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/Users/BERKYILDIZ/Downloads/chromedriver_win32/chromedriver.exe");
        WebDriver driverChrome = new ChromeDriver();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        String message;
        String message1;

        //ENTER COORDINATES


       //Valid input
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/enterCoordinates.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("40, 40");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message1 = driverChrome.findElement(By.xpath("//*[@id=\"map\"]/div/div/div[1]/div[3]/div/div[4]/div/div/div/div")).getText();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.findElement(By.cssSelector("#msg")).getText();
        if (message.equals("Erzincan") || message1.equals("Erzincan")) System.out.println("Valid Input Test: Passed");
        else System.out.println("Valid Input Test: Failed");

       //Invalid input
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/enterCoordinates.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("aaa, aaa");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Geocoder failed due to: INVALID_REQUEST")) System.out.println("Invalid Input Test: Passed");
        else System.out.println("Invalid Input Test: Failed");

        //Existence of elements
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/enterCoordinates.html");
        boolean exist1 = driverChrome.findElement(By.cssSelector("#latlng")).isDisplayed();
        boolean exist2 = driverChrome.findElement(By.cssSelector("#submit")).isDisplayed();
        boolean exist3 = driverChrome.findElement(By.cssSelector("#map")).isDisplayed();
        if(exist1 && exist2 && exist3) System.out.println("Existence Of Elements: Passed");
        else System.out.println("Existence Of Elements: Failed");

        //Zero Input
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/enterCoordinates.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("0, 0");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Geocoder failed due to: ZERO_RESULTS")) System.out.println("Zero Input Test: Passed");
        else System.out.println("Zero Input Test: Failed");

        //Blank Input
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/enterCoordinates.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Geocoder failed due to: INVALID_REQUEST")) System.out.println("Blank Input Test: Passed");
        else System.out.println("Blank Input Test: Failed");

        //Blank longitude
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/enterCoordinates.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("40, ");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Geocoder failed due to: INVALID_REQUEST")) System.out.println("Blank Longitude Test: Passed");
        else System.out.println("Blank Longitude Test: Failed");

        //Blank Latitude
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/enterCoordinates.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys(", 40");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Geocoder failed due to: INVALID_REQUEST")) System.out.println("Blank Latitude Test: Passed");
        else System.out.println("Blank Latitude Test: Failed");

        //Invalid latitude
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/enterCoordinates.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("bb, 40 ");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Geocoder failed due to: INVALID_REQUEST")) System.out.println("Invalid Latitude Test: Passed");
        else System.out.println("Invalid Latitude Test: Failed");

        //Invalid longitude
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/enterCoordinates.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("40, bb ");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Geocoder failed due to: INVALID_REQUEST")) System.out.println("Invalid Longitude Test: Passed");
        else System.out.println("Invalid Longitude Test: Failed");

        //CURRENT LOCATION

        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/currentLocation.html");
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.findElement(By.xpath("//*[@id=\"map\"]/div/div/div[1]/div[3]/div/div[4]/div[1]/div/div/div/div/div")).getText();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message1 = driverChrome.findElement(By.cssSelector("#msg")).getText();
        if (message.equals("Distance To Nearest City Center: 23.54km.") || message1.equals("Distance To Nearest City Center: 23.54km.")) System.out.println("Current Location Test: Passed");
        else System.out.println("Correct Location Test: Failed");

        //DISTANCE TO EARTH CENTER (MANUEL)

        //Existence of Components
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/earthCenterManuel.html");
        boolean exist1 = driverChrome.findElement(By.cssSelector("#latlng")).isDisplayed();
        boolean exist2 = driverChrome.findElement(By.cssSelector("#submit")).isDisplayed();
        boolean exist3 = driverChrome.findElement(By.cssSelector("#map")).isDisplayed();
        if(exist1 && exist2 && exist3) System.out.println("Existence Of Elements: Passed");
        else System.out.println("Existence Of Elements: Failed");

        //Blank coordinate
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/earthCenterManuel.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.findElement(By.cssSelector("#msg")).getText();
        if(message.equals("Distance to Earth Center: NaN kilometers.")) System.out.println("Blank Coordinate Test: Passed");
        else System.out.println("Blank Coordinate Test: Failed");

        //Invalid coordinate
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/earthCenterManuel.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("%+^, aaa");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.findElement(By.cssSelector("#msg")).getText();
        if(message.equals("Distance to Earth Center: NaN kilometers.")) System.out.println("Invalid Coordinate Test: Passed");
        else System.out.println("Invalid Coordinate Test: Failed");

        //Valid Coordinate
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/earthCenterManuel.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.findElement(By.cssSelector("#msg")).getText();
        if(message.equals("Distance to Earth Center: 658.561 kilometers.")) System.out.println("Valid Coordinate Test: Passed");
        else System.out.println("Valid Coordinate Test: Failed");

        //Blank Longitude
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/earthCenterManuel.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("10, ");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.findElement(By.cssSelector("#msg")).getText();
        if(message.equals("Distance to Earth Center: NaN kilometers.")) System.out.println("Blank Longitude Test: Passed");
        else System.out.println("Blank Longitude Test: Failed");

        //Blank Latitude
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/earthCenterManuel.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys(", 10");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.findElement(By.cssSelector("#msg")).getText();
        if(message.equals("Distance to Earth Center: NaN kilometers.")) System.out.println("Blank Latitude Test: Passed");
        else System.out.println("Blank Latitude Test: Failed");

        //Invalid Longitude
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/earthCenterManuel.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("25, aaa");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.findElement(By.cssSelector("#msg")).getText();
        if(message.equals("Distance to Earth Center: NaN kilometers.")) System.out.println("Invalid Longitude Test: Passed");
        else System.out.println("Invalid Longitude Test: Failed");

        //Invalid Latitude
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/earthCenterManuel.html");
        driverChrome.findElement(By.cssSelector("#latlng")).sendKeys("aaa, 10");
        driverChrome.findElement(By.cssSelector("#submit")).click();
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.findElement(By.cssSelector("#msg")).getText();
        if(message.equals("Distance to Earth Center: NaN kilometers.")) System.out.println("Invalid Latitude Test: Passed");
        else System.out.println("Invalid Latitude Test: Failed");

        //DISTANCE TO EARTH (GPS)
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/project3/location/earthCenterGPS.html");
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driverChrome.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        message = driverChrome.findElement(By.cssSelector("#msg")).getText();
        System.out.println(message);
        if (message.equals("Distance to Earth Center: 839.37 kilometers.")) System.out.println("Distance To Earth Center (GPS) Test: Passed");
        else System.out.println("Distance To Earth Center (GPS) Test: Failed");




        driverChrome.close();
        driverChrome.quit();

    }
}
