package GGLive_PageObject.android;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.android.AndroidAction;

public class Login_Page extends AndroidAction {
    AndroidDriver driver;

    public Login_Page(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Tài khoản\"]/android.view.ViewGroup")
    private WebElement btnTaiKhoan;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Chào mừng đến với GGLive']")
    private WebElement text1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Đăng nhập hoặc Tạo tài khoản']")
    private WebElement text2;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Số điện thoại']")
    private WebElement text3;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hoặc tiếp tục với tài khoản']")
    private WebElement text4;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tôi đồng ý với Điều khoản sử dụng và xác nhận đã đọc hiểu Chính sách Quyền riêng tư của GGLive']")
    private WebElement text5;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ed_phone")
    private WebElement inputPhone;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/btn_sign_in")
    private WebElement btnTieptuc;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/tv_error")
    private WebElement err_phone_invalid;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ivRules")
    private WebElement iconCheckRule;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nhập mật khẩu']")
    private WebElement text2_1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mật khẩu']")
    private WebElement text2_2;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ed_pass")
    private WebElement inputPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Quên mật khẩu?']")
    private WebElement text2_3;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/btn_sign_in")
    private WebElement btnDangNhap;
    public void clickBtnTaiKhoan() {
        btnTaiKhoan.click();
    }

    public String getText1() {
        return text1.getText();
    }

    public String getText2() {
        return text2.getText();
    }

    public String getText3() {
        return text3.getText();
    }

    public String getText4(){
        return text4.getText();
    }

    public String getText5(){
        return text5.getText();
    }

    public void setInputPhone(String phone) {
        inputPhone.sendKeys(phone);
    }

    public String getPlaceholderInInputPhone(){
        return inputPhone.getText();
    }

    public void clickbtnTiepTuc() {
        btnTieptuc.click();
    }

    public String gettextBtnTiepTuc() {
        return btnTieptuc.getText();
    }
    public String getErr_msg_invalid() {
        return err_phone_invalid.getText();
    }
    public void clickCheckboxTerm() {
        iconCheckRule.click();
    }

    public String getText2_1(){
        return text2_1.getText();
    }

    public String getText2_2(){
        return text2_2.getText();
    }

    public String getText2_3(){
        return text2_3.getText();
    }

    public void setInputPassword(String pw){
        inputPassword.sendKeys(pw);
    }

    public String getPlaceholderInInputPassword(){
        return inputPassword.getText();
    }
    public void clickDangNhap(){
        btnDangNhap.click();
    }

}
