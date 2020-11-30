import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;


public class Webdriver {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/Users/BERKYILDIZ/Downloads/chromedriver_win32/chromedriver.exe");
        WebDriver driverChrome=new ChromeDriver();
        String message;

        //Test for successful login
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/starsLogin/index.html");
        driverChrome.findElement(By.cssSelector("#bilkent_ID")).sendKeys("1234567");
        driverChrome.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driverChrome.findElement(By.cssSelector("#password")).sendKeys("something");
        driverChrome.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driverChrome.findElement(By.cssSelector("#loginButton")).click();
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("You are logged in.")) System.out.println("Test for valid login is successful");
        else System.out.println("Test for valid login fails");

        driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverChrome.switchTo().alert().accept();

        //Test for invalid login
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/starsLogin/index.html");
        driverChrome.findElement(By.cssSelector("#bilkent_ID")).sendKeys("1234567");
        driverChrome.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driverChrome.findElement(By.cssSelector("#password")).sendKeys("something1");
        driverChrome.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driverChrome.findElement(By.cssSelector("#loginButton")).click();
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Bilkent ID or password is wrong!")) System.out.println("Test for invalid login is successful");
        else System.out.println("Test for invalid login fails");

        driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverChrome.switchTo().alert().accept();


        //Test for blank BilkentID & Password
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/starsLogin/index.html");
        driverChrome.findElement(By.cssSelector("#loginButton")).click();
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Bilkent ID and password cannot be blank!")) System.out.println("Test for blank BilkentID & password is successful");
        else System.out.println("Test for blank BilkentID & password fails");

        driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverChrome.switchTo().alert().accept();
        //Test for blank BilkentID
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/starsLogin/index.html");
        driverChrome.findElement(By.cssSelector("#password")).sendKeys("something1");
        driverChrome.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driverChrome.findElement(By.cssSelector("#loginButton")).click();
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Bilkent ID cannot be blank!")) System.out.println("Test for blank BilkentID is successful");
        else System.out.println("Test for blank BilkentID fails");

        driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverChrome.switchTo().alert().accept();


        //Test for blank password
        driverChrome.navigate().to("file:///C:/Users/BERKYILDIZ/Desktop/cs458/starsLogin/index.html");
        driverChrome.findElement(By.cssSelector("#bilkent_ID")).sendKeys("1234567");
        driverChrome.findElement(By.cssSelector("#loginButton")).click();
        message = driverChrome.switchTo().alert().getText();
        if(message.equals("Password cannot be blank!")) System.out.println("Test for blank password is successful");
        else System.out.println("Test for blank password fails");

        driverChrome.switchTo().alert().accept();
        driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driverChrome.close();
        driverChrome.quit();
    }
}
