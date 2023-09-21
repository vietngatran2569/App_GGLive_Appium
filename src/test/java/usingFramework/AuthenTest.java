package usingFramework;

import GGLive_PageObject.android.FormRegisterUser_Page;
import GGLive_PageObject.android.Login_Page;
import GGLive_PageObject.android.Register_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AuthenTest extends BaseTest {

    String phoneInput = "0977000002";
    String pwInput = "abc123";

    //check UI verify text
    @Test(priority = 1)
    public void verifyText_LoginPage() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(10000);
        loginPage.clickBtnTaiKhoan();
        Assert.assertEquals("Chào mừng đến với GGLive", loginPage.getText1());
        Assert.assertEquals("Đăng nhập hoặc Tạo tài khoản", loginPage.getText2());
        Assert.assertEquals("Số điện thoại", loginPage.getText3());
        Assert.assertEquals("Nhập số điện thoại", loginPage.getPlaceholderInInputPhone());
        //Assert.assertEquals("Tiếp tục",loginPage.gettextBtnTiepTuc());
        Assert.assertEquals("Hoặc tiếp tục với tài khoản", loginPage.getText4());
        Assert.assertEquals("Tôi đồng ý với Điều khoản sử dụng và xác nhận đã đọc hiểu Chính sách Quyền riêng tư của GGLive", loginPage.getText5());
        loginPage.setInputPhone(phoneInput);
        loginPage.clickbtnTiepTuc();
        Assert.assertEquals("Nhập mật khẩu", loginPage.getText2_1());
        Assert.assertEquals("Mật khẩu", loginPage.getText2_2());
        Assert.assertEquals("Quên mật khẩu?", loginPage.getText2_3());
        Assert.assertEquals("Nhập mật khẩu", loginPage.getPlaceholderInInputPassword());
        loginPage.setInputPassword(pwInput);
    }

    //check login success happy case
    @Test(priority = 2)
    public void login_happycase() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(10000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput);
        loginPage.clickbtnTiepTuc();
        loginPage.setInputPassword(pwInput);
        loginPage.clickDangNhap();
    }

    //check sdt khong hop le
    String phoneInput_invalid = "09770000022";

    @Test(priority = 3)
    public void login_phone_invalid() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(10000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_invalid);
        loginPage.clickbtnTiepTuc();
        Assert.assertEquals("Số điện thoại không hợp lệ", loginPage.getErr_msg_invalid());
    }

    //check sdt chua register
    Random random = new Random();
    int randomInRange = random.nextInt(10);
    String phoneInput_not_register = "096200000" + String.valueOf(randomInRange);

    @Test(priority = 4)
    public void login_phone_not_register() throws InterruptedException {
        Thread.sleep(20000);
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(20000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        Assert.assertEquals("Đăng ký tài khoản GGLive với số điện thoại", registerPage.getText1());
        Assert.assertEquals(phoneInput_not_register, registerPage.getPhone());
        Assert.assertEquals("Tôi đồng ý với Điều khoản sử dụng và xác nhận đã đọc hiểu Chính sách Quyền riêng tư của GGLive", registerPage.getTerm());
        registerPage.checkStatus_btnRegister();
        registerPage.clickRegister();
        driver.quit();
    }

    //check nhap otp sai
    @Test(priority = 5)
    public void register_wrong_otp() throws InterruptedException {
        Thread.sleep(20000);
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(20000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        registerPage.clickRegister();

        String textExpected = "Nhập mã xác thực gồm 4 số vừa được gửi đến " + phoneInput_not_register;
        Assert.assertEquals(textExpected, registerPage.getText_SendTextOtp());

        registerPage.send_otp_0("2");
        registerPage.send_otp_1("2");
        registerPage.send_otp_2("2");
        registerPage.send_otp_3("1");
        Thread.sleep(4000);

        registerPage.clickbtnTiepTuc();
        Assert.assertEquals("Mã xác thực không chính xác", registerPage.getText_msg_error_otp());
        driver.quit();
    }

    //check resend otp
    @Test(priority = 6)
    public void register_resend_otp() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(20000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        registerPage.clickRegister();

        String textExpected = "Nhập mã xác thực gồm 4 số vừa được gửi đến " + phoneInput_not_register;
        Assert.assertEquals(textExpected, registerPage.getText_SendTextOtp());

        registerPage.send_otp_0("2");
        registerPage.send_otp_1("2");
        registerPage.send_otp_2("2");
        registerPage.send_otp_3("1");
        Thread.sleep(4000);

        registerPage.clickbtnTiepTuc();
        Assert.assertEquals("Mã xác thực không chính xác", registerPage.getText_msg_error_otp());
        Thread.sleep(60000);
        registerPage.click_resend_otp();
        driver.quit();
    }

    //check text,UI form thong tin dang ky
    @Test(priority = 7)
    public void verify_text_form_register() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(20000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        registerPage.clickRegister();
        registerPage.send_otp_0("2");
        registerPage.send_otp_1("2");
        registerPage.send_otp_2("2");
        registerPage.send_otp_3("2");
        Thread.sleep(4000);
        registerPage.clickbtnTiepTuc();

        FormRegisterUser_Page formRegisterUserPage = new FormRegisterUser_Page(driver);
        Thread.sleep(4000);
        Assert.assertEquals("Hoàn tất thông tin đăng ký", formRegisterUserPage.getText1());
        Assert.assertEquals("Tên hiển thị", formRegisterUserPage.getText2());
        Assert.assertEquals("Nhập tên hiển thị", formRegisterUserPage.getPlaceholder_inputName());
        Assert.assertEquals("Ngày sinh", formRegisterUserPage.getText3());
        Assert.assertEquals("Mật khẩu", formRegisterUserPage.getText4());
        Assert.assertEquals("Nhập mật khẩu", formRegisterUserPage.getPlaceholder_inputPw());
        Assert.assertEquals("Mật khẩu tối thiểu 6 ký tự, bao gồm cả chữ và số", formRegisterUserPage.getText5());
        Assert.assertEquals("Nhập lại mật khẩu", formRegisterUserPage.getText6());
        Assert.assertEquals("Nhập mật khẩu", formRegisterUserPage.getPlaceholder_inputRetype_Pw());
        driver.quit();
    }

    //check input Name > 25 kí tự
    @Test(priority = 8)
    public void checkInputName_limit() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(20000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        registerPage.clickRegister();
        registerPage.send_otp_0("2");
        registerPage.send_otp_1("2");
        registerPage.send_otp_2("2");
        registerPage.send_otp_3("2");
        Thread.sleep(4000);
        registerPage.clickbtnTiepTuc();

        FormRegisterUser_Page formRegisterUserPage = new FormRegisterUser_Page(driver);
        Thread.sleep(4000);
        String inputName = "STUDY WITH MESTUDY WITH ME";
        formRegisterUserPage.inputName(inputName);
        String actual_inputName = formRegisterUserPage.getInputName();
        Assert.assertEquals(25, actual_inputName.length());
        driver.quit();
    }

    //check input password <6 kí tự
    @Test(priority = 9)
    public void checkInputPassword_limit() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(20000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        registerPage.clickRegister();
        registerPage.send_otp_0("2");
        registerPage.send_otp_1("2");
        registerPage.send_otp_2("2");
        registerPage.send_otp_3("2");
        Thread.sleep(4000);
        registerPage.clickbtnTiepTuc();

        FormRegisterUser_Page formRegisterUserPage = new FormRegisterUser_Page(driver);
        Thread.sleep(4000);
        String inputName = "STUDY WITH MESTUDY WITH ME";
        formRegisterUserPage.inputName(inputName);
        formRegisterUserPage.inputPw("abc12");
        formRegisterUserPage.inputRetypePw("abc12");
        Assert.assertEquals(false, formRegisterUserPage.getStatusBtnHoanTat());
        driver.quit();
    }

    //check input password khong bao gồm cả chữ và số
    //error msg : Mật khẩu phải bao gồm chữ & số
    @Test(priority = 10)
    public void checkInputPassword_notValid() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(20000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        registerPage.clickRegister();
        registerPage.send_otp_0("2");
        registerPage.send_otp_1("2");
        registerPage.send_otp_2("2");
        registerPage.send_otp_3("2");
        Thread.sleep(4000);
        registerPage.clickbtnTiepTuc();

        FormRegisterUser_Page formRegisterUserPage = new FormRegisterUser_Page(driver);
        Thread.sleep(4000);
        String inputName = "STUDY WITH MESTUDY WITH ME";
        formRegisterUserPage.inputName(inputName);
        formRegisterUserPage.inputPw("abccde");
        formRegisterUserPage.inputRetypePw("abccde");
        formRegisterUserPage.clickBtnHoanTat();
        Assert.assertEquals("Mật khẩu phải bao gồm chữ & số", formRegisterUserPage.getErrorMsg());
        driver.quit();
    }

    //check input password and retype pw khong match
    //error msg : 2 mật khẩu phải trùng nhau
    @Test(priority = 11)
    public void checkInputPasswordAndRetype_notMatch() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(20000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        registerPage.clickRegister();
        registerPage.send_otp_0("2");
        registerPage.send_otp_1("2");
        registerPage.send_otp_2("2");
        registerPage.send_otp_3("2");
        Thread.sleep(4000);
        registerPage.clickbtnTiepTuc();

        FormRegisterUser_Page formRegisterUserPage = new FormRegisterUser_Page(driver);
        Thread.sleep(2000);
        String inputName = "STUDY WITH MESTUDY WITH ME";
        formRegisterUserPage.inputName(inputName);
        formRegisterUserPage.inputPw("abc1234");
        formRegisterUserPage.inputRetypePw("abc12345");
        formRegisterUserPage.clickBtnHoanTat();
        Assert.assertEquals("2 mật khẩu phải trùng nhau", formRegisterUserPage.getErrorMsg());
        driver.quit();
    }

    //check register success
    @Test(priority = 12)
    public void checkRegister_Success() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(20000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        registerPage.clickRegister();
        registerPage.send_otp_0("2");
        registerPage.send_otp_1("2");
        registerPage.send_otp_2("2");
        registerPage.send_otp_3("2");
        Thread.sleep(4000);
        registerPage.clickbtnTiepTuc();

        FormRegisterUser_Page formRegisterUserPage = new FormRegisterUser_Page(driver);
        Thread.sleep(4000);
        String inputName = "STUDY WITH MESTUDY WITH ME";
        formRegisterUserPage.inputName(inputName);
        formRegisterUserPage.inputPw("abc1234");
        formRegisterUserPage.inputRetypePw("abc1234");
        formRegisterUserPage.clickBtnHoanTat();
        Assert.assertEquals("Bắt đầu GGLive nào!", formRegisterUserPage.getTextBtnSuccess());
        driver.quit();
    }


}
