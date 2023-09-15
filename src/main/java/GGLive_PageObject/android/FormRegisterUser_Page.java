package GGLive_PageObject.android;

import io.appium.java_client.android.AndroidDriver;
import utils.android.AndroidAction;

public class FormRegisterUser_Page extends AndroidAction {

    AndroidDriver driver;
    public FormRegisterUser_Page(AndroidDriver driver) {
        super(driver);
        this.driver = driver;

    }
}
