package usingFramework;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void configAppium() throws MalformedURLException {
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\trang\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("0.0.0.0").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel6ProAPI30");
        options.setApp("C:\\Users\\trang\\Documents\\NgaNgokNgek\\AppiumProject\\src\\test\\java\\resource\\General-Store.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
    }

//    @AfterClass
//    public void tearDown() {
//        //actual automation
//        //stop server
//        driver.quit();
//        service.stop();
//    }

    @BeforeMethod
    public void watingHandleElement(){
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(50))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
    }
    public Double getFomatterAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    //long press action
    public void longPressAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),"duration",2000
        ));
    }

    //scroll action
    public void scrollAction(){
        boolean canScrollMore;
           do {
               canScrollMore
                       = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                       "left", 100, "top", 100, "width", 200, "height", 200,
                       "direction", "down",
                       "percent", 3.0
               ));
           }while (canScrollMore);
    }

    //swipe action
    public void swipeAction(WebElement element, String direction){
    ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
            "elementId", ((RemoteWebElement) element).getId(),
            "direction", direction,
            "percent", 0.75
    ));
    }
    //drag action
    public void dragAction(WebElement element){
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 100,
                "endY", 100
        ));
    }

//    scrollAndClick

//    public void scrollAndClick(String visibleText) {
//        androidDriver.findElementByAndroidUIAutomator
//                ("new UiScrollable(new UiSelector().scrollable(true).
//                        instance(0)).scrollIntoView(
//                new UiSelector().textContains(\""+visibleText+
//                        "\").instance(0))").click();
//    }
//}

    //Miscellaneous

    //xoay màn hình ngang-dọc : device rotation
//    DeviceRotation landScape = new DeviceRotation(0,0,90);
//    drive.retote(landScape);

    //copy to clipboard - paste it clipboard
//   drive.setClipboardText()
//   drive.sendKeys(driver.getClipboardText())
}
