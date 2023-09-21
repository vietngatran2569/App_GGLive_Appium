package usingFramework;

import GGLive_PageObject.android.GGDuo_Page;
import GGLive_PageObject.android.Login_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GGDuoTest extends BaseTest {

    //check UI verify text not login
    //verify popup Login required
    String phoneInput = "0977000002";
    String pwInput = "abc123";
    @Test(priority = 1)
    public void verifyText_KhamPhaPage_caseNotLogin() throws InterruptedException {
        GGDuo_Page ggDuoPage = new GGDuo_Page(driver);
        Thread.sleep(10000);
        ggDuoPage.clickGGDuo();
        Assert.assertEquals("Bạn cần đăng nhập để sử dụng tính năng này", ggDuoPage.getText1());
        Assert.assertEquals("Nhanh tay đăng nhập thôi nào!", ggDuoPage.getText2());
        ggDuoPage.clickLogin();

        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(10000);
        loginPage.setInputPhone(phoneInput);
        loginPage.clickbtnTiepTuc();
        loginPage.setInputPassword(pwInput);
        loginPage.clickDangNhap();
    }
}
