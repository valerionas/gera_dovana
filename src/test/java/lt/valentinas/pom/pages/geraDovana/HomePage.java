package lt.valentinas.pom.pages.geraDovana;

import lt.valentinas.pom.pages.Common;
import lt.valentinas.pom.pages.Locators;

public class HomePage {
    public static void open(String url) {
        Common.setUpChrome(7);
        Common.openUrl(url);
    }

    public static void closePopUpWindow() {
        if (Common.waitElementPresent(Locators.GeraDovana.Home.buttonCloseOmniSendForm, 7)) {
            Common.clickOnElement(Locators.GeraDovana.Home.buttonCloseOmniSendForm);
        }
    }

    public static void clickAcceptCookies() {
        Common.clickOnElement(Locators.GeraDovana.Home.buttonCookiesAcceptAll);
    }

    public static void clickPrisijungti() {
        Common.clickOnElement(Locators.GeraDovana.Home.hyperlinkPrisijungti);
        Common.loadPage(7);
    }

    public static void hoverOverProfileDropdownMenu() {
        Common.hoverOverElement(Locators.GeraDovana.Home.dropdownListProfile);
    }

    public static boolean checkLoginStatus() {
        return Common.waitElementPresent(Locators.GeraDovana.Home.buttonHeaderProfile, 2);
    }
}