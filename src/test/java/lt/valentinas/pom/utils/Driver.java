package lt.valentinas.pom.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static WebDriver chromeDriver;

    public static void setUpChrome() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("--force-device-scale-factor=0.85");
//        options.addArguments("--headless=new");
//        options.addArguments("window-size=5000,3000");

        chromeDriver = new ChromeDriver(options);
    }

    public static WebDriver getChromeDriver() {
        return chromeDriver;
    }

    public static void quitChromeDriver() {
        chromeDriver.quit();
    }
}
