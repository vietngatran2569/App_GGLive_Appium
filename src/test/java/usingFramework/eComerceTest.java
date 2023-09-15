package usingFramework;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import GeneralStore_PageObject.android.CartPage;
import GeneralStore_PageObject.android.FormPage;
import GeneralStore_PageObject.android.ProductCatalouge;


@Test
public class eComerceTest extends BaseTest {
    @Test
    public void FillFormTest() throws InterruptedException {
        FormPage formPage = new FormPage(driver);
        Thread.sleep(8000);
        formPage.sendkeyNameField("Nga nè");
        formPage.setGender("female");
        formPage.setCountrySelection1("Angola");
        formPage.clickbtnSubmit();
    }

    @Test
    public void AddToCartRedirectCartForm() throws InterruptedException {
        FormPage formPage = new FormPage(driver);
        Thread.sleep(8000);
        formPage.sendkeyNameField("Nga nè");
        formPage.setGender("female");
        formPage.setCountrySelection1("Angola");
        ProductCatalouge productCatalouge = formPage.clickbtnSubmit();

        productCatalouge.addProductToCart(0);
        productCatalouge.addProductToCart(1);
        productCatalouge.clickViewCart();
    }

    @Test
    public void CartFormAndVerifyTotalAmount() throws InterruptedException {
        FormPage formPage = new FormPage(driver);
        Thread.sleep(8000);
        formPage.sendkeyNameField("Nga nè");
        formPage.setGender("female");
        formPage.setCountrySelection1("Angola");
        ProductCatalouge productCatalouge = formPage.clickbtnSubmit();
        Thread.sleep(8000);
        productCatalouge.addProductToCart(0);
        productCatalouge.addProductToCart(0);
        CartPage cartPage = productCatalouge.clickViewCart();
        double x1= cartPage.sumPriceProd();
        double x2= cartPage.getTotalAmountLable();
        System.out.println(cartPage.sumPriceProd());
        System.out.println(cartPage.getTotalAmountLable());
  //      Assert.assertEquals(x1, x2);
    }


    //    @Test
//    public void FillFormToastMsgTest() throws InterruptedException {
//        Thread.sleep(8000);
//        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//        driver.hideKeyboard();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
//        String toastMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
//        Assert.assertEquals(toastMsg, "Please enter your name");
//        System.out.println(toastMsg);
//    }
//
//    @Test
//    public void AddProductsInCartTest() throws InterruptedException {
//        Thread.sleep(8000);
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nga nè");
//        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
//        driver.findElement(By.id("android:id/text1")).click();
//        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Angola\").instance(0))";
//        driver.findElement(AppiumBy.androidUIAutomator(scrollElement)).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//
//        String scrollProd = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"PG 3\").instance(0))";
//        driver.findElement(AppiumBy.androidUIAutomator(scrollProd));
//        int prodCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//        for (int i = 0; i < prodCount; i++) {
//            String prodName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//            if (prodName.equalsIgnoreCase("PG 3")) {
//                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//            }
//        }
//        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
////        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
//
//        String lastPageProd = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//        Assert.assertEquals(lastPageProd, "PG 3");
//    }
//
    @Test
    public void AddProductsInCart_VerifyTotalPriceTest() throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Nga nè");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        String scrollElement = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Angola\").instance(0))";
        driver.findElement(AppiumBy.androidUIAutomator(scrollElement)).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(8000);
        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        int size = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sumAmount = 0;
        for (int i = 0; i < size; i++) {
            String priceString = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
            Double amount = getFomatterAmount(priceString);
            sumAmount = sumAmount + amount;
        }

        String totalText = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double to_totalText = getFomatterAmount(totalText);

        Assert.assertEquals(sumAmount, to_totalText);
        System.out.println("tong la: " + sumAmount);

        longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
    }
}
