package GeneralStore_PageObject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.android.AndroidAction;

import java.util.List;

public class CartPage extends AndroidAction {
    AndroidDriver driver;

    public CartPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
    
    private List<WebElement> prodPrice;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmountLabel;

    public double sumPriceProd() {
        int x = prodPrice.size();
        double sumStart = 0;
        for (int i = 0; i < x; i++) {
            String amt = prodPrice.get(i).getText();
            Double sumPriceProduct = getFomatterAmount(amt);
            return sumStart = sumStart + sumPriceProduct;
        }
        return sumStart;
    }

    public Double getTotalAmountLable(){
        return getFomatterAmount(totalAmountLabel.getText());
    }


}
