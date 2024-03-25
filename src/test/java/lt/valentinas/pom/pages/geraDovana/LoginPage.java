package lt.valentinas.pom.pages.geraDovana;

import lt.valentinas.pom.pages.Common;
import lt.valentinas.pom.pages.Locators;

public class LoginPage {
    public static void writeEmail(String email) {
        Common.sendKeysToElement(Locators.GeraDovana.Login.textBoxEmail, email);
    }

    public static void writePassword(String password) {
        Common.sendKeysToElement(Locators.GeraDovana.Login.textBoxPassword, password);
    }

    public static void clickButtonLogin() {
        Common.clickOnElement(Locators.GeraDovana.Login.buttonLogin);
        Common.waitPageLoaded(7);
    }

    public static boolean checkForErrorMessage() {
        return Common.waitElementPresent(Locators.GeraDovana.Login.paragraphBadAlert,2);
    }
}
