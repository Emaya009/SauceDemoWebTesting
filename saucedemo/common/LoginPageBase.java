package com.zebrunner.carina.demo.gui.pages.saucedemo.common;

import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);

    }

    public abstract SauceHomepageBase performLoginbutton() throws IOException;
@Override
    public void open() {
        super.open();
    }
}