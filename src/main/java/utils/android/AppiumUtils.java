package utils.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumUtils {
    AndroidDriver driver;
    public AppiumUtils(AndroidDriver driver){
        this.driver=driver;
    }
    public Double getFomatterAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }
    public void waitToElementAppear(WebElement element, String valueText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(element,"text",valueText));
    }
}
