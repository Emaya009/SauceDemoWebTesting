package com.zebrunner.carina.demo.gui.pages.saucedemo.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class SauceHomepageBase extends AbstractPage {
    public SauceHomepageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addProductToCart(String product);

    public abstract String selectSortOrder(String text);

    public abstract List<ExtendedWebElement> getProductsLink();



}
