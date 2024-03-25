package lt.valentinas.pom.tests.geraDovana;

import lt.valentinas.pom.pages.CardProduct;
import lt.valentinas.pom.pages.geraDovana.HomePage;
import lt.valentinas.pom.pages.geraDovana.PaieskaPage;
import lt.valentinas.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open("https://www.geradovana.lt/");
        HomePage.clickAcceptCookies();
        HomePage.closePopUpWindow();
    }

    @DataProvider(name = "dataProviderTitleSearchService")
    public Object[][] dataProviderForTitleSearchService() {
        return new Object[][]{
                {"jodinejimas", "jodinejim", "jojim", "zirg", "raitom"},
                {"skrydis", "skrydis"}
        };
    }

    @Test(dataProvider = "dataProviderTitleSearchService")
    public void testTitlesOfSearchService(
            String input,
            String expectedResult1,
            String expectedResult2,
            String expectedResult3,
            String expectedResult4) {

        HomePage.writeToSearchBar(input);
        HomePage.clickSearchIconButton();

        List<CardProduct<String, Double>> cardsOfProducts;
        cardsOfProducts = PaieskaPage.getAllFilteredCardsInAPage();

        String cardTitle;

        for (CardProduct<String, Double> card : cardsOfProducts) {
            cardTitle = card.getTitle();
            Assert.assertTrue(
                    cardTitle.contains(expectedResult1) ||
                            cardTitle.contains(expectedResult2) ||
                            cardTitle.contains(expectedResult3) ||
                            cardTitle.contains(expectedResult4),
                    "One or more titles did not satisfy the search filtering.\nTitle \"" +
                            cardTitle + "\" does not contain any of '%s','%s','%s','%s'".formatted(
                            expectedResult1,
                            expectedResult2,
                            expectedResult3,
                            expectedResult4
                    )
            );
        }
    }

    @DataProvider(name = "dataProviderPriceSearchService")
    public Object[][] dataProviderForPricesSearchService() {
        return new Object[][]{
                {"jodinejimas"},
                {"skrydis"}
        };
    }

    @Test(dataProvider = "dataProviderPriceSearchService")
    public void testPricesOfSearchService(String input) {
        Double minPrice;
        Double maxPrice;

        HomePage.writeToSearchBar(input);
        HomePage.clickSearchIconButton();

        minPrice = PaieskaPage.getMinimumPrice();
        maxPrice = PaieskaPage.getMaximumPrice();

        List<CardProduct<String, Double>> cardsOfProducts;
        cardsOfProducts = PaieskaPage.getAllFilteredCardsInAPage();

        Double cardPrice;

        for (CardProduct<String, Double> card : cardsOfProducts) {
            cardPrice = card.getPrice();
            Assert.assertTrue(
                    cardPrice >= minPrice && cardPrice <= maxPrice,
                    "One or more of the prices did not satisfy the filtering interval.\nCard: \"" +
                            card.getTitle() + "\" Price is: %s, which is not between %s and %s".formatted(
                            cardPrice,
                            minPrice,
                            maxPrice
                    )
            );
        }
    }

}
