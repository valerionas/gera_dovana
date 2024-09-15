package lt.valentinas.pom.tests.geraDovana;

import lt.valentinas.pom.pages.Common;
import lt.valentinas.pom.pages.geraDovana.HomePage;
import lt.valentinas.pom.pages.geraDovana.SearchPage;
import lt.valentinas.pom.pages.geraDovana.ProductPage;
import lt.valentinas.pom.pages.geraDovana.ShoppingCartPage;
import lt.valentinas.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open("https://www.geradovana.lt/");
        HomePage.closePopUpWindow();
        HomePage.clickAcceptCookies();
    }

    @DataProvider(name = "dataProviderAddToCart", parallel = true)
    public Object[][] dataProviderForTestAddToCart() {
        return new Object[][]{
                {"jodinejimas"},
                {"skrydis"}
        };
    }

    @Test(dataProvider = "dataProviderAddToCart", threadPoolSize = 2)
    public void testAddToCart(String input) {
        HomePage.writeToSearchBar(input);
        HomePage.clickSearchIconButton();

        SearchPage.clickOnFirstCard();
        ProductPage.clickOnAddToCart();
        Common.goBack();
        SearchPage.clickOnSecondCard();
        ProductPage.clickOnAddToCart();

        ShoppingCartPage.addCountToFirstCartItem();

        int productCount = ShoppingCartPage.countProductsAddedToCart();
        Double productsPriceSum = ShoppingCartPage.calculateActualTotalPrice();
        Double shownPrice = ShoppingCartPage.readShownPrice();

        Assert.assertEquals(productCount, 2,
                "Turejome rasti 2 produktus sarase, radome: " + productCount);

        Assert.assertEquals(productsPriceSum, shownPrice,
                "Parodyta kaina (%s) nesutampa su paskaiciuota kaina (%s)".formatted(shownPrice, productsPriceSum));
    }
}
