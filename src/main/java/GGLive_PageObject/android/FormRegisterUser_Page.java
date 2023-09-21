package GGLive_PageObject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.android.AndroidAction;

public class FormRegisterUser_Page extends AndroidAction {

    AndroidDriver driver;

    public FormRegisterUser_Page(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hoàn tất thông tin đăng ký']")
    private WebElement text1;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tên hiển thị']")
    private WebElement text2;
    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ed_display_name")
    private WebElement inputName;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ngày sinh']")
    private WebElement text3;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mật khẩu']")
    private WebElement text4;
    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ed_pass")
    private WebElement inputPw;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mật khẩu tối thiểu 6 ký tự, bao gồm cả chữ và số']")
    private WebElement text5;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nhập lại mật khẩu']")
    private WebElement text6;
    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/ed_pass_retype")
    private WebElement inputRetypePw;
    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/btn_finish")
    private WebElement btnHoanTat;
    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/tv_error")
    private WebElement msg_error;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bắt đầu GGLive nào!']")
    private WebElement textBtnSucess;

    public String getText1() {
        return text1.getText();
    }
    public String getText2() {
        return text2.getText();
    }
    public void inputName(String name) {
        inputName.sendKeys(name);
    }
    public String getInputName() {
        return inputName.getText();
    }
    public String getText3() {
        return text3.getText();
    }
    public String getText4() {
        return text4.getText();
    }
    public void inputPw(String pw) {
        inputPw.sendKeys(pw);
    }
    public String getText5() {
        return text5.getText();
    }
    public String getText6() {
        return text6.getText();
    }
    public void inputRetypePw(String pw) {
        inputRetypePw.sendKeys(pw);
    }
    public void clickBtnHoanTat() {
        btnHoanTat.click();
    }
    public String getPlaceholder_inputName() {
        return inputName.getText();
    }
    public String getPlaceholder_inputPw() {
        return inputPw.getText();
    }
    public String getPlaceholder_inputRetype_Pw() {
        return inputRetypePw.getText();
    }
    public boolean getStatusBtnHoanTat() {
        return btnHoanTat.isEnabled();
    }
    public String getErrorMsg() {
        return msg_error.getText();
    }
    public String getTextBtnSuccess() {
        return textBtnSucess.getText();
    }


}
