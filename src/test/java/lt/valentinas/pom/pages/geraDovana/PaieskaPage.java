package lt.valentinas.pom.pages.geraDovana;

import lt.valentinas.pom.pages.CardProduct;
import lt.valentinas.pom.pages.Common;
import lt.valentinas.pom.pages.Locators;

import java.util.ArrayList;
import java.util.List;

public class PaieskaPage {
    public static List<CardProduct<String, Double>> getAllFilteredCardsInAPage() {
        List<CardProduct<String, Double>> cardProducts = new ArrayList<>();

        List<Double> listPrices = Common.getAllCardsPrices(Locators.GeraDovana.Paieska.spansCardProductPrices);
        List<String> listTitles = Common.getAllCardsTitles(Locators.GeraDovana.Paieska.paragraphsCardProductTitles);

        if (listPrices.size() == listTitles.size()) {
            for (int i = 0; i < listTitles.size(); i++) {

                CardProduct<String, Double> cardProduct = new CardProduct<>(listTitles.get(i),listPrices.get(i));//papasakoti, kaip instance buvai pries cikla pasidares ir del to listas nukentejo
                cardProducts.add(cardProduct);
            }
        }
        return cardProducts;
    }

    public static Double getMinimumPrice() {
        return Double.parseDouble(Common.getAttributeValueOfAnElement(Locators.GeraDovana.Paieska.textBoxMinPrice));
    }

    public static Double getMaximumPrice() {
        return Double.parseDouble(Common.getAttributeValueOfAnElement(Locators.GeraDovana.Paieska.textBoxMaxPrice));
    }

    public static void clickOnFirstCard() {
        Common.clickOnElement(Locators.GeraDovana.Paieska.linkFirstCardProduct);
    }

    public static void clickOnSecondCard() {
        Common.clickOnElement(Locators.GeraDovana.Paieska.linkSecondCardProduct);
    }
}
