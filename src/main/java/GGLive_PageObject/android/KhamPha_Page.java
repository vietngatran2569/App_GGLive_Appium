package GGLive_PageObject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.android.AndroidAction;

public class KhamPha_Page extends AndroidAction {
    AndroidDriver driver;

    public KhamPha_Page(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Khám phá']")
    private WebElement btnKhamPha;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Giải Trí']")
    private WebElement btnGiaiTri;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PC Game']")
    private WebElement btnPCGame;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Mobile Game']")
    private WebElement btnMobileGame;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Trò Chuyện']")
    private WebElement category_trochuyen;
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Di chuyển lên\"]")
    private WebElement buttonBack;
    @AndroidFindBy(id = "com.boxvn.gglive.staging:id/cate_name")
    private WebElement cate_name;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Kênh trực tiếp']")
    private WebElement tab_KenhTrucTiep;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Video clip']")
    private WebElement tab_VideoClip;
    public void clickKhamPha(){
        btnKhamPha.click();
    }
    public String getTextKhamPha(){
        return btnKhamPha.getText();
    }
    public void clickGiaiTri(){
        btnGiaiTri.click();
    }
    public String getTextGiaiTri(){
        return btnGiaiTri.getText();
    }
    public void clickPCGame(){
        btnPCGame.click();
    }
    public String getTextPCGame(){
        return btnPCGame.getText();
    }
    public void clickMobileGame(){
        btnMobileGame.click();
    }
    public String getTextMobileGame(){
        return btnMobileGame.getText();
    }
    public void click_categoryTroChuyen(){
        category_trochuyen.click();
    }
    public void clickbuttonBack(){
        buttonBack.click();
    }
    public String getText_category(){
        return cate_name.getText();
    }
    public void clickTabKenhTrucTiep(){
        tab_KenhTrucTiep.click();
    }
    public void clickTabVideoClip(){
        tab_VideoClip.click();
    }
}
