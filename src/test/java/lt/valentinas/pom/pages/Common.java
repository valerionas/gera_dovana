package lt.valentinas.pom.pages;

import lt.valentinas.pom.utils.Driver;
import lt.valentinas.pom.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
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

    public static void waitPageLoaded(int waitSeconds) {
        Driver.getChromeDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(waitSeconds));
    }

    public static void openUrl(String url) {
        Driver.getChromeDriver().get(url);
    }

    public static void quitChromeDriver() {
        Driver.quitChromeDriver();
    }

    public static void goBack() {
        Driver.getChromeDriver().navigate().back();
        waitPageLoaded(7);
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

    public static boolean waitElementPresent(By locator, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getChromeDriver(), Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
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

        if (result instanceof HashMap newMap) {
            return newMap;
        }
        return new HashMap<>();
    }

    public static void hoverOverElement(By locator) {
        Actions action = new Actions(Driver.getChromeDriver());
        action.moveToElement(getElement(locator)).perform();
    }

    public static List<Double> getAllCardsPrices(By locator) {
        List<Double> listOfPrices = new ArrayList<>();
        Double priceDouble;

        for (WebElement element : getElements(locator)) {
            priceDouble = Utils.parseNumberFromString(element.getText());
            listOfPrices.add(priceDouble);
        }
        return listOfPrices;
    }

    public static List<String> getAllCardsTitles(By locator) {
        String text;
        List<String> listOfTitles = new ArrayList<>();

        for (WebElement element : getElements(locator)) {
            text = Utils.deLithuaniseStringToLower(element.getText());
            listOfTitles.add(text);
        }
        return listOfTitles;
    }

    public static String getAttributeValueOfAnElement(By locator) {
        Map map;
        map = getElementAttributes(locator);
        return map.get("value").toString();
    }

    public static int countElements(By locator) {
        return getElements(locator).size();
    }
}
