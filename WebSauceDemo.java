package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.gui.pages.saucedemo.common.SauceHomepageBase;
import com.zebrunner.carina.demo.gui.pages.saucedemo.common.LoginPageBase;
import org.testng.annotations.Test;

import java.io.IOException;

public class WebSauceDemo implements IAbstractTest {

    //private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Test
    public void testLogin() throws IOException {
    LoginPageBase loginPageBase = initPage(getDriver(), LoginPageBase.class);
    loginPageBase.open();
    //Home page is opened
    loginPageBase.assertPageOpened();
    SauceHomepageBase homePageBase=loginPageBase.performLoginbutton();
        homePageBase.assertPageOpened();
}
}
