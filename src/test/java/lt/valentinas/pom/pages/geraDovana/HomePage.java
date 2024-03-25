package lt.valentinas.pom.pages.geraDovana;

import lt.valentinas.pom.pages.Common;
import lt.valentinas.pom.pages.Locators;

public class HomePage {
    public static void open(String url) {
        Common.setUpChrome(7);
        Common.openUrl(url);
    }

    public static void clickAcceptCookies() {
        Common.waitElementPresent(Locators.GeraDovana.Home.buttonCookiesAcceptAll, 10);
        Common.clickOnElement(Locators.GeraDovana.Home.buttonCookiesAcceptAll);
    }

    public static void closePopUpWindow() {
        Common.waitElementPresent(Locators.GeraDovana.Home.buttonCloseOmniSendForm, 10);
        Common.clickOnElement(Locators.GeraDovana.Home.buttonCloseOmniSendForm);
    }

    public static void clickPrisijungti() {
        Common.clickOnElement(Locators.GeraDovana.Home.hyperlinkPrisijungti);
        Common.waitPageLoaded(7);
    }

    public static void hoverOverProfileDropdownMenu() {
        Common.hoverOverElement(Locators.GeraDovana.Home.dropdownListProfile);
    }

    public static boolean checkLoginStatus() {
        return Common.waitElementPresent(Locators.GeraDovana.Home.buttonHeaderProfile, 2);
    }

    public static void writeToSearchBar(String input) {
        Common.sendKeysToElement(Locators.GeraDovana.Home.textBoxSearch, input);
    }

    public static void clickSearchIconButton() {
        Common.clickOnElement(Locators.GeraDovana.Home.buttonSearchIcon);
        Common.waitPageLoaded(7);
    }
}
