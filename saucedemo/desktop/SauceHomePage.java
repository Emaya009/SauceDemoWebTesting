package com.zebrunner.carina.demo.gui.pages.saucedemo.desktop;

import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.zebrunner.carina.demo.gui.pages.common.HomePageBase;
import com.zebrunner.carina.demo.gui.pages.saucedemo.common.SauceHomepageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.invoke.MethodHandles;
import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class SauceHomePage extends SauceHomepageBase {
        private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

        public SauceHomePage(WebDriver driver) {
            super(driver);
            setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
            setUiLoadedMarker(productsTitle);
        }

        @FindBy(css = ".title")
        private ExtendedWebElement productsTitle;

        @FindBy(xpath = "//div[@class='inventory_item_name']")
        private List<ExtendedWebElement> productsLink;

        @FindBy(xpath = "//a")
        private List<ExtendedWebElement> allLinks;

        @FindBy(xpath = "//button[text()='Add to cart']")
        private ExtendedWebElement btnAddToCart;

        @FindBy(css = ".product_sort_container")
        private ExtendedWebElement sortOrder;

        @Override
        public void addProductToCart(String product) {
            for(ExtendedWebElement link: productsLink) {
                LOGGER.info("Selecting product : " + product);
                String currentProduct = link.getText();
                if(product.equalsIgnoreCase(currentProduct)) {
                    btnAddToCart.click();
                }
            }
        }

        @Override
        public String selectSortOrder(String text) {
            LOGGER.info("Sorting Order before : " + sortOrder.getSelectedValue());
            sortOrder.select(text);
            String order = sortOrder.getSelectedValue();
            LOGGER.info("Sorting Order after : " + order);
            return order;
        }

        @Override
        public List<ExtendedWebElement> getProductsLink() {
            return productsLink;
        }

    }

