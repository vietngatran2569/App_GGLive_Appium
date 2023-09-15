package usingFramework;

import GGLive_PageObject.android.Login_Page;
import GGLive_PageObject.android.Register_Page;
import org.example.notUsingFramework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class AuthenTest extends BaseTest {

    String phoneInput = "0977000002";
    String pwInput = "abc123";

    //check UI verify text
    @Test
    public void verifyText_LoginPage() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(10000);
        loginPage.clickBtnTaiKhoan();
        Assert.assertEquals("Chào mừng đến với GGLive", loginPage.getText1());
        Assert.assertEquals("Đăng nhập hoặc Tạo tài khoản", loginPage.getText2());
        Assert.assertEquals("Số điện thoại", loginPage.getText3());
        Assert.assertEquals("Nhập số điện thoại",loginPage.getPlaceholderInInputPhone());
        //Assert.assertEquals("Tiếp tục",loginPage.gettextBtnTiepTuc());
        Assert.assertEquals("Hoặc tiếp tục với tài khoản",loginPage.getText4());
        Assert.assertEquals("Tôi đồng ý với Điều khoản sử dụng và xác nhận đã đọc hiểu Chính sách Quyền riêng tư của GGLive",loginPage.getText5());
        loginPage.setInputPhone(phoneInput);
        loginPage.clickbtnTiepTuc();
        Assert.assertEquals("Nhập mật khẩu",loginPage.getText2_1());
        Assert.assertEquals("Mật khẩu",loginPage.getText2_2());
        Assert.assertEquals("Quên mật khẩu?",loginPage.getText2_3());
        Assert.assertEquals("Nhập mật khẩu",loginPage.getPlaceholderInInputPassword());
        loginPage.setInputPassword(pwInput);
    }

    //check login success happy case
    @Test
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
    @Test
    public void login_phone_invalid() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(10000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_invalid);
        loginPage.clickbtnTiepTuc();
        Assert.assertEquals("Số điện thoại không hợp lệ",loginPage.getErr_msg_invalid());
    }

    //check sdt chua register
    Random random = new Random();
    int randomInRange = random.nextInt(10);
    String phoneInput_not_register = "096700000"+ String.valueOf(randomInRange);
    @Test
    public void login_phone_not_register() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(10000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage=new Register_Page(driver);
        Thread.sleep(8000);
        Assert.assertEquals("Đăng ký tài khoản GGLive với số điện thoại", registerPage.getText1());
        Assert.assertEquals(phoneInput_not_register, registerPage.getPhone());
        Assert.assertEquals("Tôi đồng ý với Điều khoản sử dụng và xác nhận đã đọc hiểu Chính sách Quyền riêng tư của GGLive", registerPage.getTerm());
        registerPage.checkStatus_btnRegister();
        registerPage.clickRegister();
    }

    //check nhap otp sai
    @Test
    public void register_wrong_otp() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(10000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        registerPage.clickRegister();

        String textExpected = "Nhập mã xác thực gồm 4 số vừa được gửi đến "+phoneInput_not_register;
        Assert.assertEquals(textExpected,registerPage.getText_SendTextOtp());

        registerPage.send_otp_0("2");
        registerPage.send_otp_1("2");
        registerPage.send_otp_2("2");
        registerPage.send_otp_3("1");
        Thread.sleep(4000);

        registerPage.clickbtnTiepTuc();
        Assert.assertEquals("Mã xác thực không chính xác",registerPage.getText_msg_error_otp());
    }

    //check resend otp
    @Test
    public void register_resend_otp() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(10000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput_not_register);
        loginPage.clickbtnTiepTuc();

        Register_Page registerPage = new Register_Page(driver);
        Thread.sleep(8000);
        registerPage.clickRegister();

        String textExpected = "Nhập mã xác thực gồm 4 số vừa được gửi đến "+phoneInput_not_register;
        Assert.assertEquals(textExpected,registerPage.getText_SendTextOtp());

        registerPage.send_otp_0("2");
        registerPage.send_otp_1("2");
        registerPage.send_otp_2("2");
        registerPage.send_otp_3("1");
        Thread.sleep(4000);

        registerPage.clickbtnTiepTuc();
        Assert.assertEquals("Mã xác thực không chính xác",registerPage.getText_msg_error_otp());
        Thread.sleep(60000);
        registerPage.click_resend_otp();
    }


}
