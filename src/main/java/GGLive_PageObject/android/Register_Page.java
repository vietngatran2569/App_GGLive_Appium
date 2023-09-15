package GGLive_PageObject.android;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.android.AndroidAction;

public class Register_Page extends AndroidAction {

    AndroidDriver driver;
    public Register_Page(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Đăng ký tài khoản GGLive với số điện thoại']")
    private WebElement text1;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/tvPhone")
    private WebElement phone;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/tvRules")
    private WebElement term;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ivRules")
    private WebElement iconCheckboxTerm;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/btnRegister")
    private WebElement btnRegister;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/tv_message")
    private WebElement textSendOTP;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ed_otp_0")
    private WebElement input_otp_0;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ed_otp_1")
    private WebElement input_otp_1;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ed_otp_2")
    private WebElement input_otp_2;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ed_otp_3")
    private WebElement input_otp_3;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/btn_finish")
    private WebElement btnTieptuc;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/tv_error")
    private WebElement error_wrong_otp;

    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/btn_resend_otp")
    private WebElement btn_resend;

    public String getText1(){
        return text1.getText();
    }

    public String getPhone(){
        return phone.getText();
    }

    public String getTerm(){
        return term.getText();
    }

    public void clickRegister(){
        btnRegister.click();
    }

    public void checkStatus_btnRegister(){
        if (iconCheckboxTerm.isSelected()){
            btnRegister.isEnabled();
        }
    }

    public String getText_SendTextOtp(){
        return textSendOTP.getText();
    }

    public void send_otp_0(String num){
        input_otp_0.sendKeys(num);
    }
    public void send_otp_1(String num){
        input_otp_1.sendKeys(num);
    }
    public void send_otp_2(String num){
        input_otp_2.sendKeys(num);
    }
    public void send_otp_3(String num){
        input_otp_3.sendKeys(num);
    }

    public void clickbtnTiepTuc(){
        btnTieptuc.click();
    }

    public String getText_msg_error_otp(){
        return error_wrong_otp.getText();
    }

    public void click_resend_otp(){
         btn_resend.click();
    }







}
