package GGLive_PageObject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.android.AndroidAction;

public class GGDuo_Page extends AndroidAction {
    AndroidDriver driver;

    public GGDuo_Page(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GG Duo']")
    private WebElement btnGGDou;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bạn cần đăng nhập để sử dụng tính năng này']")
    private WebElement text1;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nhanh tay đăng nhập thôi nào!']")
    private WebElement text2;
    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/btnUnderstand")
    private WebElement btnDangNhapNgay;

    public void clickGGDuo() {
        btnGGDou.click();
    }
    public String getText1() {
        return text1.getText();
    }
    public String getText2() {
        return text2.getText();
    }
    public void clickLogin(){
        btnDangNhapNgay.click();
    }
}
