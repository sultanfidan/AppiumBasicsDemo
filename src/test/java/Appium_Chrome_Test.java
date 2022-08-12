import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Appium_Chrome_Test {

    public AppiumDriver driver;

    @BeforeTest
    public void SetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("browserName", "Chrome");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }

    @Test
    public void userLogin(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
       WebElement userName= driver.findElementByCssSelector("input#username");
       userName.sendKeys("tomsmith");
       WebElement password= driver.findElementByCssSelector("input#password");
       password.sendKeys("SuperSecretPassword!");
       WebElement loginBtn=driver.findElementByCssSelector("button.radius");
       loginBtn.click();

        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.urlContains("secure"));
        System.out.println(driver.getCurrentUrl());

    }
}
