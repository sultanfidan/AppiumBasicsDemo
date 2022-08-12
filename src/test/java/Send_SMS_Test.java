import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Send_SMS_Test {

    public AndroidDriver driver;

    @BeforeTest
    public void SetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("appPackage","com.android.mms");
        caps.setCapability("appActivity",".ui.ConversationList");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }

    @Test
    public void sendSMS(){

        //for sendSMS function we should use AndroidDriver not AppiumDriver
        driver.sendSMS("0850 485 2139","Hello,This is just test message");
    }
}
