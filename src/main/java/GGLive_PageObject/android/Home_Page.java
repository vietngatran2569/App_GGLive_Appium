package GGLive_PageObject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.android.AndroidAction;

public class Home_Page extends AndroidAction {
    AndroidDriver driver;

    public Home_Page(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Phổ biến']")
    private WebElement text1;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Theo dõi']")
    private WebElement text2;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Giải Trí']")
    private WebElement text3;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PC Game']")
    private WebElement text4;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile Game']")
    private WebElement text5;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hot Live']")
    private WebElement text6;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dành cho bạn']")
    private WebElement text7;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Event']")
    private WebElement text8;

    public void clickPhobien(){
        text1.click();
    }
    public String getText1(){
        return text1.getText();
    }
    public void clickTheoDoi(){
        text2.click();
    }
    public String getText2(){
        return text2.getText();
    }
    public void clickGiaiTri(){
        text3.click();
    }
    public String getText3(){
        return text3.getText();
    }
    public void clickPCGame(){
        text4.click();
    }
    public String getText4(){
        return text4.getText();
    }
    public void clickMobileGame(){
        text5.click();
    }
    public String getText5(){
        return text5.getText();
    }
    public void clickHotlive(){
        text6.click();
    }
    public String getText6(){
        return text6.getText();
    }
    public void clickDanhchoban(){
        text7.click();
    }
    public String getText7(){
        return text7.getText();
    }
    public void clickEvent(){
        text8.click();
    }
    public String getText8(){
        return text8.getText();
    }

}
