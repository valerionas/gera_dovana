package lt.valentinas.pom.pages;

import lt.valentinas.pom.utils.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static boolean waitElementPresent(By locator, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getChromeDriver(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static boolean waitElementPresentCustomised(By locator, int seconds) {
        boolean isElementPresent = false;

        for (int i = 0; i < 2 * seconds; i++) {
            try {
                Thread.sleep(500);
                getElement(locator);
                return true;
            } catch (NoSuchElementException e) {

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public static Map<String, ?> getElementAttributes(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getChromeDriver();
        Object result = executor.executeScript(
                """
                var items = {};
                for (index = 0; index < arguments[0].attributes.length; ++index){
                    items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value
                };
                return items;
                """,
                getElement(locator)
        );

        if (result instanceof HashMap newMap ){
            return newMap;
        }

        return new HashMap<>();

    }

    public static boolean waitElementClickable(By locator, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getChromeDriver(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static boolean waitElementAttributeChange(By locator, int seconds, String attribute, String value) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getChromeDriver(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.attributeContains(locator, attribute, value));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static Alert getAlert() {
        return Driver.getChromeDriver().switchTo().alert();
    }

    public static void acceptAlert() {
        getAlert().accept();
    }

    public static void dismissAlert() {
        getAlert().dismiss();
    }

    public static boolean waitAlertPresent(int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getChromeDriver(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public static void writeToAlert(String input) {

        getAlert().sendKeys(input);
    }

    public static void hoverOverElement(By locator) {
        Actions action = new Actions(Driver.getChromeDriver());
        action.moveToElement(getElement(locator)).perform();
    }

    public static void loadPage(int waitSeconds) {
        Driver.getChromeDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSeconds));
    }
}
