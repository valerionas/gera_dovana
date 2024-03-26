package lt.valentinas.pom.pages;

import org.openqa.selenium.By;

public class Locators {
    public static class GeraDovana {
        public class Home {
            public static By buttonCookiesAcceptAll = By.xpath("//button[@class='cookies-accept-all']");
            public static By linkPrisijungti = By.xpath("(//a[contains(text(),' Prisijungti')])[1]");
            public static By buttonCloseOmniSendForm = By.xpath(
                    "//div[contains(@id,'close-button') and contains(@class, 'close-button')]");
            public static By divDropdownProfile = By.xpath(
                    "//div[@class='dropdown dropdown--backdrop dropdown--profile']");
            public static By buttonHeaderProfile = By.xpath("//span[text() = 'Profilis']");
            public static By textBoxSearch = By.xpath("//input[@id='filterKeyword']");
            public static By buttonSearchIcon = By.xpath("(//button[@type='submit'])[1]");
        }

        public class Login {
            public static By textBoxEmail = By.xpath("//input[@id='email']");
            public static By textBoxPassword = By.xpath("//input[@id='password']");
            public static By buttonLogin = By.xpath("//button[@class='loginbtn']");
            public static By paragraphBadAlert = By.xpath("//p[@class='alert badalert']");
        }

        public class Paieska {
            public static By paragraphsCardProductTitles = By.xpath(
                    "//p[@class='card--product__heading']");
            public static By spansCardProductPrices = By.xpath(
                    "//span[@class='card--product__price-current card--product__price-current--discount']"
            );
            public static By textBoxMinPrice = By.xpath("//input[@id='min-price']");
            public static By textBoxMaxPrice = By.xpath("//input[@id='max-price']");
            public static By linkFirstCardProduct = By.xpath(
                    "(//div[@class='card card--product card--product--hoverable']/a)[1]");
            public static By linkTwentyFirstCardProduct = By.xpath(
                    "(//div[@class='card card--product card--product--hoverable']/a)[21]");
            public static By nodeOfPriceSelectorFirst = By.xpath("(//div[@class='noUi-touch-area'])[1]");
            public static By nodeOfPriceSelectorSecond = By.xpath("(//div[@class='noUi-touch-area'])[2]");
        }

        public class Product {
            public static By buttonAddToCart = By.xpath("(//a[@class='prodbuybtn '])[3]");
        }

        public class ShoppingCart {
            public static By divCartItems = By.xpath(
                    "//div[@class='cart-items-block']//div[@class='heading']");
            public static By divFirstCartItem = By.xpath(
                    "(//div[@class='cart-item cart-item-active gift'])[1]");
            public static By divSecondCartItem = By.xpath(
                    "(//div[@class='cart-item cart-item-active gift'])[2]");
            public static By divTotalPrice = By.xpath(
                    "//div[@class='sum-total']/div[@class='total-price-1']");
            public static By buttonIncreaseItemCountFirstCartItem = By.xpath(
                    "(//i[@class='icon icon-box-arrow-up'])[1]");
            public static By inputItemQuantityFirstCartItem = By.xpath("(//input[@class='item-quantity'])[1]");
        }
    }
}
