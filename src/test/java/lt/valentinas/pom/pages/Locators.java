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
        }

        public class Login {
            public static By textBoxEmail = By.xpath("//input[@id='email']");
            public static By textBoxPassword = By.xpath("//input[@id='password']");
            public static By buttonLogin = By.xpath("//button[@class='loginbtn']");
            public static By paragraphBadAlert = By.xpath("//p[@class='alert badalert']");
        }
    }
}
