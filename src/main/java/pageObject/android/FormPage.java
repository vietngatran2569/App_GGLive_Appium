package pageObject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.android.AndroidAction;

public class FormPage extends AndroidAction {
//    @Test
//    public void FillFormTest() throws InterruptedException {
//        Thread.sleep(8000);
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nga nè");
//        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//        driver.findElement(By.id("android:id/text1")).click();
//        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Angola\").instance(0))";
//        driver.findElement(AppiumBy.androidUIAutomator(scrollElement)).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
//    }

    AndroidDriver driver;

    public FormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleOption;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleOption;

    //     driver.findElement(By.id("android:id/text1")).click();
    @AndroidFindBy(id = "android:id/text1")
    private WebElement countrySelection;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement btnLetsShop;

    public void sendkeyNameField(String name) {
        nameField.sendKeys(name);
    }

    public void setGender(String gender) {
        if (gender.contains("female")) {
            femaleOption.click();
        } else
            maleOption.click();
    }

    public void setCountrySelection1(String countryname){
        countrySelection.click();
        scrollToTextandClick(countryname);
    }

    public ProductCatalouge clickbtnSubmit(){
        btnLetsShop.click();
        return new ProductCatalouge(driver);
    }



}
