package lt.valentinas.pom.pages.geraDovana;

import lt.valentinas.pom.pages.CardProduct;
import lt.valentinas.pom.pages.Common;
import lt.valentinas.pom.pages.Locators;

import java.util.ArrayList;
import java.util.List;

public class PaieskaPage {
    public static List<CardProduct<String, Double>> getAllFilteredCardsInAPage() {
        List<CardProduct<String, Double>> cardProducts = new ArrayList<>();
        CardProduct<String, Double> cardProduct = new CardProduct<>();

        List<Double> listPrices = Common.getAllCardsPrices(Locators.GeraDovana.Paieska.cardProductPrices);
        List<String> listTitles = Common.getAllCardsTitles(Locators.GeraDovana.Paieska.cardProductTitles);

        if (listPrices.size() == listTitles.size()) {
            for (int i = 0; i < listTitles.size(); i++) {
                cardProduct.setTitle(listTitles.get(i));
                cardProduct.setPrice(listPrices.get(i));
                cardProducts.add(cardProduct);
            }
        }
        return cardProducts;
    }
}
