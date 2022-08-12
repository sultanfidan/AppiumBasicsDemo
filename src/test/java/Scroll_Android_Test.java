import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Scroll_Android_Test {

   public AppiumDriver driver;
   public AndroidTouchAction actions;



    @BeforeTest
    public void SetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        //caps.setCapability("platformVersion", "9.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");


        driver = new AndroidDriver( new URL("http://localhost:4723/wd/hub"),caps);
    }

    private void scrollDown(){

        // Define y start and end point
        Dimension dimension= driver.manage().window().getSize();
        int scrollStart= (int) (dimension.getHeight() * 0.8);
        int scrollEnd= (int) (dimension.getHeight() * 0.1);

        //to use press and move we should use actions
        actions= new AndroidTouchAction(driver)
                .press(PointOption.point(0,scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(PointOption.point(0,scrollEnd))
                .release()
                .perform();


    }

        @Test
        public void scrollTest(){
            AndroidElement views = (AndroidElement) driver.findElementByAccessibilityId("Views");

            //Tap
            actions= new AndroidTouchAction(driver);
            actions.tap(ElementOption.element(views)).perform();

            //ScrollDown
            scrollDown();

            AndroidElement lists= (AndroidElement) driver.findElementByAccessibilityId("Lists");
            actions.tap(ElementOption.element(lists)).perform();


        }

}
