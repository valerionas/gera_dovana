package lt.valentinas.pom.tests.geraDovana;

import lt.valentinas.pom.pages.geraDovana.HomePage;
import lt.valentinas.pom.pages.geraDovana.LoginPage;
import lt.valentinas.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open("https://www.geradovana.lt/");
        HomePage.clickAcceptCookies();
        HomePage.closePopUpWindow();
    }

    @DataProvider(name = "dataProviderLoginCorrectInput", parallel = true)
    public Object[][] dataProviderForLoginCorrectInput() {
        return new Object[][]{
                {"valiuspus@gmail.com", "slaptazodis123"},
                {"valiuspu@gmail.com", "123slaptazodis"}
        };
    }

    @Test(dataProvider = "dataProviderLoginCorrectInput", threadPoolSize = 2)
    public void testLogin_ProvidedCorrectInput(String email, String password) {
        boolean expectedResult = true;

        HomePage.hoverOverProfileDropdownMenu();
        HomePage.clickPrisijungti();

        LoginPage.writeEmail(email);
        LoginPage.writePassword(password);
        LoginPage.clickButtonLogin();

        boolean actualResult = HomePage.checkLoginStatus();

        Assert.assertEquals(actualResult, expectedResult,
                "\nExpected: %s,\nActual: %s\n".formatted(expectedResult, actualResult)
        );
    }

    @DataProvider(name = "dataProviderLoginIncorrectInput", parallel = true)
    public Object[][] dataProviderForLoginIncorrectInput() {
        return new Object[][]{
                {"valiuspus@gmail.com", "neteisingas_slaptazodis"},
                {"nevalidus_el_pastas.lt", "slaptazodis123"},
                {"valiuspu@gmail.com", ""}
        };
    }

    @Test(dataProvider = "dataProviderLoginIncorrectInput", threadPoolSize = 3)
    public void testLogin_ProvidedIncorrectInput(String email, String password) {
        boolean expectedResult = true;

        HomePage.hoverOverProfileDropdownMenu();
        HomePage.clickPrisijungti();

        LoginPage.writeEmail(email);
        LoginPage.writePassword(password);
        LoginPage.clickButtonLogin();

        boolean actualResult = LoginPage.checkForErrorMessage();

        Assert.assertEquals(actualResult, expectedResult,
                "\nExpected: %s,\nActual: %s\n".formatted(expectedResult, actualResult)
        );
    }
}
