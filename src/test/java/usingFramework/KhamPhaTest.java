package usingFramework;

import GGLive_PageObject.android.KhamPha_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KhamPhaTest extends BaseTest {

    //check UI verify text not login
    @Test(priority = 1)
    public void verifyText_KhamPhaPage_caseNotLogin() throws InterruptedException {
        KhamPha_Page khamPhaPage = new KhamPha_Page(driver);
        Thread.sleep(10000);
        khamPhaPage.clickKhamPha();
        Assert.assertEquals("Khám phá", khamPhaPage.getTextKhamPha());
        Assert.assertEquals("Giải Trí", khamPhaPage.getTextGiaiTri());
        Assert.assertEquals("PC Game", khamPhaPage.getTextPCGame());
        Assert.assertEquals("Mobile Game", khamPhaPage.getTextMobileGame());
    }

    //verify tab giải trí
    @Test(priority = 2)
    public void verifyText_HomePage_caseNotLogin() throws InterruptedException {
        KhamPha_Page khamPhaPage = new KhamPha_Page(driver);
        Thread.sleep(10000);
        khamPhaPage.clickKhamPha();
        khamPhaPage.clickGiaiTri();
        khamPhaPage.click_categoryTroChuyen();
        Assert.assertEquals("Trò Chuyện", khamPhaPage.getText_category());
        khamPhaPage.clickTabKenhTrucTiep();
        khamPhaPage.clickTabVideoClip();
        khamPhaPage.clickbuttonBack();
    }


}
