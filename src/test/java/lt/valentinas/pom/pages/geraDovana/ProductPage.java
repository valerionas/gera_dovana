package lt.valentinas.pom.pages.geraDovana;

import lt.valentinas.pom.pages.Common;
import lt.valentinas.pom.pages.Locators;

public class ProductPage {

    public static void clickOnAddToCart() {
        Common.clickOnElement(Locators.GeraDovana.Product.buttonAddToCart);
    }
}
