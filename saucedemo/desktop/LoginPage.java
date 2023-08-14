package com.zebrunner.carina.demo.gui.pages.saucedemo.desktop;

import com.zebrunner.carina.demo.gui.pages.saucedemo.common.SauceHomepageBase;
import com.zebrunner.carina.demo.gui.pages.saucedemo.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP,parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(id="user-name")
    private ExtendedWebElement userName;

    @FindBy(id="password")
    private ExtendedWebElement password;
    @FindBy(xpath = "//*[@name='login-button']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(password);
    }

    @Override
    public SauceHomepageBase performLoginbutton() {

     /*   Properties prop=new Properties();
        prop.load(new FileInputStream("carina.properties"));
     String inputUserName= prop.getProperty("username");
     String inputPassword= prop.getProperty("password");
*/
        String inputUserName = "standard_user";
        String inputPassword = "secret_sauce";
        System.out.println("Entering User name: " +inputUserName);
        assertElementPresent(userName);
        userName.type(inputUserName);
        System.out.println("Entering the password:" +inputPassword);
        assertElementPresent(password);
        password.assertElementPresent();
        password.type(inputPassword);
        loginButton.assertElementPresent();
        loginButton.clickIfPresent();
        return initPage(getDriver(), SauceHomepageBase.class);
         }

    }
