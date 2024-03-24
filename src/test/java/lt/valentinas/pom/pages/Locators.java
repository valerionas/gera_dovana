package lt.valentinas.pom.pages;

import org.openqa.selenium.By;

public class Locators {
    public static class GeraDovana {
        public class Home {
            public static By buttonCookiesAcceptAll = By.xpath("//button[@class='cookies-accept-all']");
            public static By hyperlinkPrisijungti = By.xpath("(//a[contains(text(),' Prisijungti')])[1]");
            public static By buttonCloseOmniSendForm = By.xpath(
                    "//div[contains(@id,'close-button') and contains(@class, 'close-button')]"
            );
            public static By dropdownListProfile = By.xpath(
                    "//div[@class='dropdown dropdown--backdrop dropdown--profile']"
            );
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
            public static By cardProductTitles = By.xpath("//p[@class='card--product__heading']");
            public static By cardProductPrices = By.xpath(
                    "//span[@class='card--product__price-current card--product__price-current--discount']"
            );
        }
    }
}
