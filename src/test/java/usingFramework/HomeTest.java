package usingFramework;

import GGLive_PageObject.android.Home_Page;
import GGLive_PageObject.android.Login_Page;
import org.example.notUsingFramework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    //check UI verify text not login
    //Ko hiển thị tab Theo dõi
    @Test(priority = 1)
    public void verifyText_HomePage_caseNotLogin() throws InterruptedException {
        Home_Page homePage = new Home_Page(driver);
        Thread.sleep(10000);
        Assert.assertEquals("Phổ biến", homePage.getText1());
        //Assert.assertEquals("Theo dõi", homePage.getText2());
        Assert.assertEquals("Giải Trí", homePage.getText3());
        Assert.assertEquals("PC Game", homePage.getText4());
        Assert.assertEquals("Mobile Game", homePage.getText5());
        Assert.assertEquals("Hot Live", homePage.getText6());
        Assert.assertEquals("Dành cho bạn", homePage.getText7());
        Assert.assertEquals("Event", homePage.getText8());
    }

    //check UI verify text login
    //Hiển thị tab Theo dõi
    String phoneInput = "0977000002";
    String pwInput = "abc123";
    @Test(priority = 2)
    public void verifyText_HomePage_caseLogin() throws InterruptedException {
        Login_Page loginPage = new Login_Page(driver);
        Thread.sleep(10000);
        loginPage.clickBtnTaiKhoan();
        loginPage.setInputPhone(phoneInput);
        loginPage.clickbtnTiepTuc();
        loginPage.setInputPassword(pwInput);
        loginPage.clickDangNhap();

        Home_Page homePage = new Home_Page(driver);
        Thread.sleep(10000);
        Assert.assertEquals("Phổ biến", homePage.getText1());
        Assert.assertEquals("Theo dõi", homePage.getText2());
        Assert.assertEquals("Giải Trí", homePage.getText3());
        Assert.assertEquals("PC Game", homePage.getText4());
        Assert.assertEquals("Mobile Game", homePage.getText5());
        Assert.assertEquals("Hot Live", homePage.getText6());
        Assert.assertEquals("Dành cho bạn", homePage.getText7());
        Assert.assertEquals("Event", homePage.getText8());
    }
}
