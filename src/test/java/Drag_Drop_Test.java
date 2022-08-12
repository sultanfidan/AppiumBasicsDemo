import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Drag_Drop_Test {

    public AppiumDriver driver;
    public AndroidTouchAction actions;


    @BeforeTest
    public void SetUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");

        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
    }

        @Test
        public void dragDropTest(){
            AndroidElement views= (AndroidElement) driver.findElementByAccessibilityId("Views");

            actions=new AndroidTouchAction(driver);
            actions.tap(ElementOption.element(views)).perform();

            AndroidElement drag_drop= (AndroidElement) driver.findElementByAccessibilityId("Drag and Drop");
            actions.tap(ElementOption.element(drag_drop)).perform();

            AndroidElement drag= (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
            AndroidElement drop= (AndroidElement) driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));

            //AndroidElement drag2= findAndroidElement(By.id("io.appium.android.apis:id/drag_dot_1"));

            actions.longPress(ElementOption.element(drag))
                    .waitAction()
                    .moveTo(ElementOption.element(drop))
                    .release()
                    .perform();

        }

//        private AndroidElement findAndroidElement(By by){
//            return (AndroidElement) driver.findElement(by);
//        }

        @AfterTest
        public void tearDown(){
            if(driver!=null)
                driver.quit();
    }
}
