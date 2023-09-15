package GeneralStore_PageObject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.android.AndroidAction;

import java.util.List;

public class ProductCatalouge extends AndroidAction {
    AndroidDriver driver;

    public ProductCatalouge(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement btnViewCart;

    public void addProductToCart(int index){
        addToCart.get(index).click();
    }

    public CartPage clickViewCart(){
        btnViewCart.click();
        return new CartPage(driver);
    }


}
