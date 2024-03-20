package lt.valentinas.pom.pages;

import lt.valentinas.pom.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Common {
    public static void setUpChrome() {
        Driver.setUpChrome();
    }

    public static void setUpChrome(int waitSeconds) {
        Driver.setUpChrome();
        Driver.getChromeDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSeconds));
    }

    public static void openUrl(String url) {
        Driver.getChromeDriver().get(url);
    }

    public static void quitChromeDriver() {
        Driver.quitChromeDriver();
    }

    private static WebElement getElement(By locator) {
        return Driver.getChromeDriver().findElement(locator);
    }

    private static List<WebElement> getElements(By locator) {
        return Driver.getChromeDriver().findElements(locator);
    }

    public static void sendKeysToElement(By locator, String text) {
        getElement(locator).sendKeys(text);
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public static boolean waitElementVisible(By locator, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getChromeDriver(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static boolean isElementSelected(By locator) {
        return getElement(locator).isSelected();
    }

    public static boolean isElementEnabled(By locator) {
        return getElement(locator).isEnabled();
    }

    public static List<Boolean> isElementGroupSelected(By locator) {
        List<Boolean> list = new ArrayList<>();

        for (WebElement element : getElements(locator)) {
            list.add(element.isSelected());
        }

        return list;
    }

    public static void doubleClickOnElementByAction(By locator) {
        Actions action = new Actions(Driver.getChromeDriver());
        action.
                moveToElement(getElement(locator)).
                doubleClick().
                perform();
    }

    public static void clickOnElementByAction(By locator) {
        Actions action = new Actions(Driver.getChromeDriver());
        action.
                moveToElement(getElement(locator)).
                click().
                perform();
    }

    public static void rightClickOnElementByAction(By locator) {
        Actions action = new Actions(Driver.getChromeDriver());
        action.
                moveToElement(getElement(locator)).
                contextClick().
                perform();
    }

}
