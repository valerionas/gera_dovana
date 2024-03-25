package lt.valentinas.pom.pages.geraDovana;

import lt.valentinas.pom.pages.Common;
import lt.valentinas.pom.pages.Locators;
import lt.valentinas.pom.utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingCartPage {
    public static int countProductsAddedToCart() {
        return Common.countElements(Locators.GeraDovana.ShoppingCart.textCartItems);
    }

    public static Double calculateActualTotalPrice() {
        Map<String, ?> attributes;
        Double sumPrices = 0.0;

        attributes = Common.getElementAttributes(Locators.GeraDovana.ShoppingCart.divFirstCartItem);
        sumPrices += Double.parseDouble(attributes.get("data-price").toString());
        attributes = Common.getElementAttributes(Locators.GeraDovana.ShoppingCart.divSecondCartItem);
        sumPrices += Double.parseDouble(attributes.get("data-price").toString());

        return new BigDecimal(sumPrices).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static Double readShownPrice() {
        String string = Common.getTextFromElement(Locators.GeraDovana.ShoppingCart.divTotalPrice);
        return Utils.parseNumberFromString(string);
    }
}
